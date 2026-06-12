package laboratoriofinal;

public class detalledeventa {
	public class DetalleVenta {
	    private int idDetalle;
	    private int cantidad;
	    private double subtotal;
	    private Producto producto; // Relación con Producto

	    public DetalleVenta(int id, int cant, Producto prod) {
	        this.idDetalle = id;
	        this.cantidad = cant;
	        this.producto = prod;
	        calcularSubtotal(); // Se calcula automáticamente al instanciar
	    }

	    // Método interno para mantener la coherencia del negocio
	    private void calcularSubtotal() {
	        if (this.producto != null) {
	            this.subtotal = this.cantidad * this.producto.getPrecioVenta();
	        }
	    }

	    public int getIdDetalle() { return idDetalle; }
	    
	    public int getCantidad() { return cantidad; }
	    public void setCantidad(int cant) { 
	        this.cantidad = cant; 
	        calcularSubtotal(); // Recalcular si cambia la cantidad
	    }

	    public double getSubtotal() { return subtotal; }

	    public Producto getProducto() { return producto; }
	    public void setProducto(Producto prod) { 
	        this.producto = prod; 
	        calcularSubtotal(); // Recalcular si cambia el producto
	    }
	}
}
