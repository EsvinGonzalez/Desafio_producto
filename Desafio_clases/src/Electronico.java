public class Electronico extends Producto {
    private final String marca;
    public Electronico(int id, String nombre, double precio, int cantidad, String marca) {
        super(id, nombre, precio, cantidad);
        this.marca = marca;
    }

    public double calcularDescuento(){
        return getPrecio() * 0.15;

    }

    public String getMarca() {
        return marca;
    }

}

