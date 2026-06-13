package laboratoriofinal;

public class Main {

    public static void main(String[] args) {

        // 1. Crear la categoría de los productos
        Categoria categoriaPociones = new Categoria(1, "Pociones y Elíxires");
        Categoria categoriaArmas = new Categoria(2, "Armamento Ligero");

        // 2. Crear un Cliente y un Empleado de prueba (Corregidos con Mayúscula)
        cliente cliente1 = new cliente(101, "Miguel Ángel", "7777-1234");
        cliente1.setDireccion("Sonsonate, El Salvador");

        empleado empleado1 = new empleado(201, "Carlos Gómez", "Vendedor Principal");

        // 3. Crear los Productos disponibles en el inventario
        Producto prod1 = new Producto(501, "Poción de Vida", 5.0, 12.50, categoriaPociones);
        prod1.setCantidadMax(100);
        prod1.setCantidadMin(10);

        Producto prod2 = new Producto(502, "Espada Corta de Bronce", 20.0, 45.0, categoriaArmas);
        prod2.setCantidadMax(50);
        prod2.setCantidadMin(5);

        // 4. Iniciar una nueva Venta
        Venta nuevaVenta = new Venta(1001, "12/06/2026", cliente1, empleado1);

     // 5. Crear el detalle de la venta
        DetalleVenta detalle1 = new DetalleVenta(1, 3, prod1); // 3 Pociones de Vida
        DetalleVenta detalle2 = new DetalleVenta(2, 1, prod2); // 1 Espada Corta

        // 6. Asociar los detalles a la venta
        nuevaVenta.agregarDetalle(detalle1);
        nuevaVenta.agregarDetalle(detalle2);

        // =================================================================
        // 7. MOSTRAR EL REPORTE O TICKET DE VENTA POR CONSOLA
        // =================================================================
        System.out.println("==================================================");
        System.out.println("                TICKET DE VENTA                   ");
        System.out.println("==================================================");
        System.out.println("ID Venta: " + nuevaVenta.getIdVenta());
        System.out.println("Fecha   : " + nuevaVenta.getFecha());
        System.out.println("Cliente : " + nuevaVenta.getCliente().getNombre());
        System.out.println("Atendido por: " + nuevaVenta.getEmpleado().getNombre() + " (" + nuevaVenta.getEmpleado().getCargo() + ")");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-22s %-10s %-10s %-10s\n", "Producto", "Cant.", "P. Unit", "Subtotal");
        System.out.println("--------------------------------------------------");

        // Recorremos la lista de detalles guardada en la venta
        for (DetalleVenta det : nuevaVenta.getDetalles()) {
            System.out.printf("%-22s %-10d $%-9.2f $%-9.2f\n", 
                det.getProducto().getNombre(), 
                det.getCantidad(), 
                det.getProducto().getPrecioVenta(), 
                det.getSubtotal() // Corregido con 's' minúscula
            );
        }

        System.out.println("--------------------------------------------------");
        // Al llamar a calcularTotal(), se procesa la suma de todos los subtotales
        System.out.printf("TOTAL A PAGAR:                               $%.2f\n", nuevaVenta.calcularTotal());
        System.out.println("==================================================");
        System.out.println("          ¡Gracias por su aventura!               ");
        System.out.println("==================================================");
    }
}