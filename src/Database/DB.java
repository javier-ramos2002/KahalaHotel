package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Class.Cliente;

    public class DB {
        public static Connection initDB(String nombreBD){
            Connection con = null;
            
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return con;
        }
        
        public static void closeDB(Connection con) {
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        public static void crearTablaCliente(Connection con) {
            String sent = "CREATE TABLE IF NOT EXISTS Cliente(dni String, nombre String, apellido String, contrasenia String, fechaNacimiento String)";
            Statement st = null;
            
            try {
                st = con.createStatement();
                st.executeUpdate(sent);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if(st!=null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        
        public static void aniadirCliente(Connection con, Cliente c) {
            String sent = "INSERT INTO Usuario VALUES('"+c.getDni()+"','"+c.getNombre()+"','"+c.getApellido()+"','"+c.getContrasenia()+"','"+c.getFechaNacimiento()+"')";
            Statement st = null;
            
            try {
                st = con.createStatement();
                st.executeUpdate(sent);
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if(st!=null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            
        }
}
