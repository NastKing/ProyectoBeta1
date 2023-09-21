import java.util.*;
class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private Orden orden;
    private String descripcion;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.orden = new Orden();
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio()* producto.getCantidadSolicitada();
        }
        return total;
    }

    public void imprimirFactura() {

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                    Factura " );
        System.out.println("|               Fabrica De Sillas S.A");
        System.out.println("|        1ra calle 3-93 kaminal juyu 1 ZONA 7");
        System.out.println("|");
        System.out.println("|");
        System.out.println("| Numero de Orden :"+orden.getNumeroOrden());
        System.out.println("|");
        System.out.println("|");
        System.out.println("|Nombre: "+cliente.getNombre()+" "+cliente.getApellido()+"    Nit: "+cliente.getNit());
        System.out.println("-------------------------------------------------------------------------------------");
        int cantidad = 0;
        double preciouni = 0;
        for (Producto producto : productos) {
            preciouni = producto.getPrecio();
            cantidad = producto.getCantidadSolicitada();
        }
        System.out.println("|Cantidad      Descripcion       Precio Unit     ");
        System.out.println("|"+cantidad+"              "+descripcion+"           Q : "+preciouni);

        System.out.println("|                    Total a pagar: $" + calcularTotal());
        System.out.println("..........................................................................................");
    }
    private int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(1000) + 1; // Genera un número aleatorio entre 1 y 1000
    }
}
