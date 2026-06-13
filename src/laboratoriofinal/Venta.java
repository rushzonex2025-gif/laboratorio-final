package laboratoriofinal;

import java.util.ArrayList; 

public class Venta {
    
    private int idVenta;
    private String fecha;
    private double total;
    private cliente cliente;   // Corregido: 'Cliente' con C mayúscula
    private empleado empleado; // Corregido: 'Empleado' con E mayúscula
    private ArrayList<DetalleVenta> detalles; // Usa la 'v' minúscula de tu archivo

    // Constructor arreglado con los nombres de clase correctos
    public Venta(int id, String fecha, cliente cl, empleado emp) {
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

    public cliente getCliente() { return cliente; }
    public void setCliente(cliente cl) { this.cliente = cl; }

    public empleado getEmpleado() { return empleado; }
    public void setEmpleado(empleado emp) { this.empleado = emp; }

    public void agregarDetalle(DetalleVenta det) {
        this.detalles.add(det);
    }

    public double calcularTotal() {
        double suma = 0.0;
        for (DetalleVenta det : detalles) {
            suma += det.getSubtotal(); // Conecta con el getsubtotal() de tu Detalleventa
        }
        this.total = suma;
        return this.total;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }
}