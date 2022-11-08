package Class;

import java.util.ArrayList;
import java.util.List;

import Class.Habitacion.TiposHabitacion;
import Database.GestorBD;

public class Main {
    public static void main(String[] args) {
        GestorBD.crearBBDD();

        List<Cliente> clientes = initClientes();
        GestorBD.insertarCliente(clientes.toArray(new Cliente[clientes.size()]));
        
        List<Habitacion> habitaciones = initHabitaciones();
        GestorBD.insertarHabitacion(habitaciones.toArray(new Habitacion[habitaciones.size()]));

        clientes = GestorBD.obtenerDatos();
		printClientes(clientes);
		
		GestorBD.borrarDatos();
        
        GestorBD.borrarBBDD();



    }

    private static List<Habitacion> initHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        TiposHabitacion tp = TiposHabitacion.HABITACION_DOBLE;

        Habitacion habitacion = new Habitacion("Kahala", "111A", "80", "4", "t6", tp);
        habitaciones.add(habitacion);
        return habitaciones;
    }

    private static List<Cliente> initClientes() {
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente("78945612D", "Pedro", "Lopez", "PedroLopez2", "20/05/1999");

        clientes.add(cliente);
        return clientes;
    }

    private static void printClientes(List<Cliente> clientes) {
		if (!clientes.isEmpty()) {		
			for(Cliente cliente : clientes) {
				System.out.println(String.format("- %s", cliente.toString()));
			}
		}		
	}
	
}
