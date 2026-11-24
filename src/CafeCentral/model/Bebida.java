package CafeCentral.model;

public class Bebida extends Producto {

    private double precioFinal;

    public Bebida(String codigo, String nombre, double precioBase, int stock) {
        super(codigo, nombre, precioBase, stock);
    }

    @Override
    public void calcularPrecioFinal() {
        this.precioFinal = getPrecioBase() + 0.10; // Aplicar un aumento del 10%
    }

    public String getTipo() {
        return "Bebida";
    }
}
