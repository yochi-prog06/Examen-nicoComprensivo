package CafeCentral.model;

public abstract class Producto {

    private final String codigo;
    private String nombre;
    private double precioBase;
    private int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) {
        if(precioBase < 0){
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        }
        if(stock < 0){
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }


    public abstract void calcularPrecioFinal();

    public void reducirStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a reducir no puede ser negativa");
        }
        if (cantidad > stock) {
            throw new IllegalArgumentException("No hay suficiente stock para reducir la cantidad solicitada");
        }
        this.stock -= cantidad;
    }

    public abstract String getTipo();

    public String getCodigo() {return codigo;}
    public double getPrecioBase() {
        return precioBase;
    }
}
