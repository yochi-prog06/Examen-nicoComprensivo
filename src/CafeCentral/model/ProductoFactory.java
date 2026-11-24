package CafeCentral.model;

import CafeCentral.model.Alimento;
import CafeCentral.model.Bebida;
import CafeCentral.model.Producto;

public class ProductoFactory {
    private ProductoFactory() {}

    public static Producto crear(String codigo, String nombre, String tipo, double precioBase, int stock) {
        return switch (tipo.trim().toUpperCase()) {
            case "BEBIDA" -> new Bebida(codigo, nombre, "BEBIDA", precioBase, stock);
            case "ALIMENTO" -> new Alimento(codigo, nombre, "ALIMENTO", precioBase, stock);
            default -> throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        };
    }
}
