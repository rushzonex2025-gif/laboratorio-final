package laboratoriofinal;

public class venta {
	import java.util.ArrayList;

	public class Venta {
	    private int idVenta;
	    private String fecha;
	    private double total;
	    private Cliente cliente;
	    private Empleado empleado;
	    private ArrayList<DetalleVenta> detalles; // Composición: Rombo azul en el UML

	    public Venta(int id, String fecha, Cliente cl, Empleado emp) {
	        this.idVenta = id;
	        this.fecha = fecha;
	        this.cliente = cl;
	        this.empleado = emp;
	        this.detalles = new ArrayList<>();
	        this.total = 0.0;
	    }

	    public int getIdVenta() { return idVenta; }
	    
	    public String getFecha() { return fecha; }
	    public void setFecha(String fecha) { this.fecha = fecha; }

	    public Cliente getCliente() { return cliente; }
	    public void setCliente(Cliente cl) { this.cliente = cl; }

	    public Empleado getEmpleado() { return empleado; }
	    public void setEmpleado(Empleado emp) { this.empleado = emp; }

	    // Agrega un detalle de producto a la lista de la venta
	    public void agregarDetalle(DetalleVenta det) {
	        this.detalles.add(det);
	    }

	    // Calcula el total sumando el subtotal de cada línea de detalle
	    public double calcularTotal() {
	        double suma = 0.0;
	        for (DetalleVenta det : detalles) {
	            suma += det.getSubtotal();
	        }
	        this.total = suma;
	        return this.total;
	    }

	    public ArrayList<DetalleVenta> getDetalles() {
	        return detalles;
	    }

	    @Override
	    public String toString() {
	        return "Venta{" + "id=" + idVenta + ", fecha='" + fecha + "', cliente=" + cliente.getNombre() + ", total=" + calcularTotal() + '}';
	    }
	}
}
