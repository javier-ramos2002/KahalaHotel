package Database;

import java.sql.Statement;

import Class.Cliente;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBD {

    protected static final String DRIVER_NAME = "org.sqlite.JDBC";
    protected static final String DATABASE_FILE = "db/database.db";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;
    
    public GestorBD() {     
        try {
            //Cargar el diver SQLite
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }
        
    public static void crearBBDD(Connection con){
        String sent1 = "CREATE TABLE IF NOT EXISTS Cliente(dni String, nombre String, apellido String, contrasenia String, fechaNacimiento String)"; 
        String sent2 = "CRETE TABLE IF NOT EXISTS Reserva(fechaInicio String, fechaFin String, cliente Cliente, ArrayList<Habitacion> ListaHabitaciones)";

        Statement st = null;
        try{
            st = con.createStatement();
            st.executeUpdate(sent1);
            st.executeUpdate(sent2);
        }catch(SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void borrarBBDD() {
        //Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
             Statement stmt = con.createStatement()) {
            
            String sql = "DROP TABLE IF EXISTS CLIENTE";
            
            //Se ejecuta la sentencia de creación de la tabla Clientes
            if (!stmt.execute(sql)) {
                System.out.println("- Se ha borrado la tabla Cliente");
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();           
        }
        
        try {
            //Se borra el fichero de la BBDD
            Files.delete(Paths.get(DATABASE_FILE));
            System.out.println("- Se ha borrado el fichero de la BBDD");
        } catch (Exception ex) {
            System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();                       
        }
    }
    
    public static void insertarDatos(Cliente... clientes ) {
        //Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
             Statement stmt = con.createStatement()) {
            //Se define la plantilla de la sentencia SQL
            String sql = "INSERT INTO CLIENTE (DNI, NOMBRE, APELLIDO, CONTRASENIA, FECHANACIMIENTO) VALUES ('%s', '%s', '%s', '%s', '%s');";
            
            System.out.println("- Insertando clientes...");
            
            //Se recorren los clientes y se insertan uno a uno
            for (Cliente c : clientes) {
                
                if (1 == stmt.executeUpdate(String.format(sql, c.getDni(), c.getNombre(), c.getApellido(), c.getContrasenia(), c.getFechaNacimiento()))) {                  
                    System.out.println(String.format("- Cliente insertado: %s", c.toString()));
                } else {
                    System.out.println(String.format("- No se ha insertado el cliente: %s", c.toString()));
                }
            }           
        } catch (Exception ex) {
            System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();                       
        }               
    }
    
    public static List<Cliente> obtenerDatos() {
        List<Cliente> clientes = new ArrayList<>();
        
        //Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
             Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM CLIENTE";
 
            //Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
            ResultSet rs = stmt.executeQuery(sql);          
            
            //Se recorre el ResultSet y se crean objetos Cliente
            while (rs.next()) {
                
                String dni = rs.getString("DNI");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                String contrasenia= rs.getString("CONTRASENIA");
                String fechaNacimineto= rs.getString("FECHANACIMIENTO");
                Cliente cliente = new Cliente(dni, nombre, apellido, contrasenia, fechaNacimineto);
                
                //Se inserta cada nuevo cliente en la lista de clientes
                clientes.add(cliente);
            }
            
            //Se cierra el ResultSet
            rs.close();
            
            System.out.println(String.format("- Se han recuperado %d clientes...", clientes.size()));           
        } catch (Exception ex) {
            System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();                       
        }       
        
        return clientes;
    }

    public void actualizarContrasenia(Cliente cliente, String nuevaContrasenia) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE CLIENTE SET PASSWORD = '%s' WHERE ID = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, nuevaContrasenia, cliente.getDni()));
			
			System.out.println(String.format("- Se ha actulizado %d clientes", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		

	}

    public void borrarDatos() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM CLIENTE;";			
			int result = stmt.executeUpdate(sql);
			
			System.out.println(String.format("- Se han borrado %d clientes", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}	
   
}
