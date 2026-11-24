package CafeCentral.service;

import CafeCentral.model.Producto;
import CafeCentral.persistencia.Repositorio;

import java.util.List;

public class CatalogoProductos implements Repositorio<Producto> {

    List<Producto> productos;

    public CatalogoProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public void agregarProducto(Producto elemento){
        if(elemento == null){
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(elemento);
    }

    @Override
    public Producto buscarPorCodigo(String codigo) {
        if(codigo == null || codigo.isEmpty()){
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public List<Producto> listarTodos() {
        return productos;
    }
}
