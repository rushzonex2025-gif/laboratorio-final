package laboratoriofinal;

public class DetalleVenta {
    private int idDetalle;
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public DetalleVenta(int id, int cant, Producto prod) {
        this.idDetalle = id;
        this.cantidad = cant;
        this.producto = prod;
        calcularSubtotal();
    }

    private void calcularSubtotal() {
        if (this.producto != null) {
            this.subtotal = this.cantidad * this.producto.getPrecioVenta();
        }
    }

    public int getIdDetalle() { return idDetalle; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cant) {
        this.cantidad = cant;
        calcularSubtotal();
    }

    public double getSubtotal() { return subtotal; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto prod) {
        this.producto = prod;
        calcularSubtotal();
    }
}