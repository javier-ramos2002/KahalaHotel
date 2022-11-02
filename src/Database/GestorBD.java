package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

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
        
    public static void crearBBDD() {
       
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
             Statement stmt = con.createStatement()) {
            
            String sql = "CREATE TABLE IF NOT EXISTS CLIENTE (\n"
                       + " DNI INTEGER PRIMARY KEY,\n"
                       + " NOMBRE TEXT NOT NULL,\n"
                       + " APELLIDO TEXT NOT NULL,\n"
                       + " CONTRASENIA TEXT NOT NULL,\n"
                       + " FECHANACIMIENTO TEXT NOT NULL\n"
                       + ");";
                        
            if (!stmt.execute(sql)) {
                System.out.println("- Se ha creado la tabla Cliente");
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();           
        }
    }
   
}
