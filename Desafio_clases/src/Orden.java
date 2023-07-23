import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final List<Producto> productos;

    public Orden() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotalOrden() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    public void mostrarDetallesOrden() {
        System.out.println("Detalles de la orden:");
        for (Producto producto : productos) {
            System.out.println("Id: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: Q" + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            if (producto instanceof Electronico) {
                Electronico electronico = (Electronico) producto;
                System.out.println("Marca: " + electronico.getMarca());
            }
            System.out.println("--------------------------");
        }
        System.out.println("Total de la orden: Q" + calcularTotalOrden());

    }
}

class Main {
    public static void main(String[] args) {

        Producto producto1 = new Producto(1, "Telefono", 1099.99, 1);
        Producto producto2 = new Producto(2, "Auriculares", 399.45, 1);
        Electronico productoElectronico = new Electronico(3, "Bosina Bluetooth", 500.99, 1, "JBL");

        double descuentoElectronico = productoElectronico.calcularDescuento();
        System.out.println("Descuento aplicado al producto electronico: Q" + descuentoElectronico);

        Orden orden = new Orden();
        orden.agregarProducto(producto1);
        orden.agregarProducto(producto2);
        orden.agregarProducto(productoElectronico);

        orden.mostrarDetallesOrden();
    }
}