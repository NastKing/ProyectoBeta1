class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadSolicitada() {
        return cantidad;
    }

    public void setCantidadSolicitada(int cantidad) {
        this.cantidad = cantidad;
    }
}







