package Class;

import java.util.ArrayList;
import java.util.List;

import Database.GestorBD;

public class Main {
    public static void main(String[] args) {
        GestorBD.crearBBDD();

        List<Cliente> clientes = initClientes();
        GestorBD.insertarDatos(clientes.toArray(new Cliente[clientes.size()]));
        GestorBD.borrarBBDD();

    }

    private static List<Cliente> initClientes() {
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente("78945612D", "Pedro", "Lopez", "PedroLopez2", "20/05/1999");

        clientes.add(cliente);
        return clientes;
    }
}
