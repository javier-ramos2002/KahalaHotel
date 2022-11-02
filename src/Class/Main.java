package Class;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Database.GestorBD;

public class Main {
    public static void main(String[] args) {
        GestorBD.crearBBDD(Connection con);

        List<Cliente> clientes = initClientes();
        GestorBD.insertarDatos(clientes.toArray(new Cliente[clientes.size()]));
        
        clientes = GestorBD.obtenerDatos();
		printClientes(clientes);
        GestorBD.borrarBBDD();



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
