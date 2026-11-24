package CafeCentral.model;

public class Alimento extends Producto {

    private double precioFinal;


    public Alimento(String codigo, String nombre, double precioBase, int stock) {
        super(codigo, nombre, precioBase, stock);
    }

    public void calcularPrecioFinal() {
        this.precioFinal = getPrecioBase() + 0.05; // Aplicar un aumento del 10%

    }
}
