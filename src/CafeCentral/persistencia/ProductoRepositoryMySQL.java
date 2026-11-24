package CafeCentral.persistencia;


import CafeCentral.model.Producto;
import CafeCentral.model.ProductoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductoRepositoryMySQL{
    private final String url;
    private final String usuario;
    private final String clave;

    public ProductoRepositoryMySQL() {
        this.url = env("ACT_DB_URL", "jdbc:mysql://localhost:3306/actividades_db");
        this.usuario = env("ACT_DB_USER", "act_app");
        this.clave = System.getenv("ACT_DB_PASSWORD");
    }

    private static String env(String nombre, String porDefecto) {
        String v = System.getenv(nombre);
        return (v   == null || v.isBlank()) ? porDefecto : v;
    }

    private Connection conectar(){
        if (clave == null)
            throw new IllegalArgumentException("Falta la variable de entorno ACT_DB_PASSWORD");
        try {
            return DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            throw new IllegalArgumentException("No se pudo conectar a la base de datos", e);
        }
    }

    public List<Producto> cargarTodos() {
        List<Producto> resultado = new ArrayList<>();
        try (Connection cn = conectar();
             CallableStatement cs = cn.prepareCall("{CALL sp_listar_productos()}");
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                resultado.add(ProductoFactory.crear(
                        rs.getString("codigo"), rs.getString("nombre"), rs.getString("tipo"),
                        rs.getDouble("precio_base"), rs.getInt("stock")));
            }
        } catch (SQLException e) {
            throw traducir("No se pudo listar las actividades", e);
        }
        return resultado;
    }

    public void insertar(Producto p) {
        try (Connection cn = conectar();
             CallableStatement cs = cn.prepareCall("{CALL sp_insertar_producto(?,?,?,?,?)}")) {
            cs.setString(1, p.getCodigo());
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getTipo());
            cs.setDouble(4, p.getPrecioBase());
            cs.setInt(5, p.getStock());
            cs.execute();
        } catch (SQLException e) {
            throw traducir("No se pudo insertar el producto", e);
        }
    }

    public void actualizar(Producto p) {
        try (Connection cn = conectar();
             CallableStatement cs = cn.prepareCall("{CALL sp_actualizar_productos(?,?)}")) {
            cs.setString(1, p.getCodigo());
            cs.setInt(2, p.getStock());
            cs.execute();
        } catch (SQLException e) {
            throw traducir("No se pudo actualizar el stock del producto", e);
        }
    }



    private IllegalArgumentException traducir(String mensaje, SQLException e) {
        if ("45000".equals(e.getSQLState())) return new IllegalArgumentException(e.getMessage(), e);
        return new IllegalArgumentException(mensaje, e);
    }
}
