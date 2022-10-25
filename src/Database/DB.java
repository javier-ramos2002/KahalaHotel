package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Class.Cliente;

    public class DB {
        private static Connection con;
        private static Logger logger = Logger.getLogger( "DB" );
        
        public static void initDB(String nombreBD, boolean primeraVez) throws SQLException {  
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
                logger.log(Level.INFO, "Conexión establecida con jdbc:sqlite:"+nombreBD);
                
                if(primeraVez) {  
                    crearTablaCliente(nombreBD);
                    logger.log(Level.INFO, "Creada nueva tabla clientes");
                }
                }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void closeDB() {
            if(con!=null) {
                try {
                    con.close();
                    logger.log(Level.INFO, "Conexión cerrada");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public static void crearTablaCliente(String nombreBD) throws SQLException{
            try{
                Statement stmt = con.createStatement();
                String sentSQL = "DROP TABLE IF EXISTS cliente;";  
                logger.log( Level.INFO, "Statement: " + sentSQL );
                stmt.execute( sentSQL );
               
                sentSQL = "CREATE TABLE cliente ( dni varchar(9) PRIMARY KEY, nombre varchar(55), apellido varchar(55), contrasenia varchar(55), fechaNacimineto varchar(55);";
                logger.log( Level.INFO, "Statement: " + sentSQL );
                stmt.execute(sentSQL);
                stmt.close();
                System.out.println("Valores introducidos correctamente");
            }
            catch(SQLException e) {
                logger.log( Level.SEVERE, "No se ha podido ejecutar la sentencia" );
            }
            
        }
        
        public static void anadirCliente(Cliente c) {
            try (Statement stmt = con.createStatement()){
                String sentSQL = "INSERT INTO cliente VALUES('"+c.getDni()+"','"+c.getNombre()+"','"+c.getApellido()+"','"+c.getContrasenia()+"',"+c.getFechaNacimiento()+"')";
                logger.log( Level.INFO, "Statement: " + sentSQL );
                stmt.executeUpdate(sentSQL);
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                logger.log( Level.SEVERE, "Excepción", e );
                e.printStackTrace();
            }
        }
}
