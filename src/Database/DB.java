package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static Connection con;
    private static Logger logger = Logger.getLogger("KahalaHotel");

    public static void initBD(String nombreBD) {

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
            logger.log(Level.INFO, "Conexión establecida con jdbc:sqlite:" + nombreBD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeBD() {
        if (con != null) {
            try {
                con.close();
                logger.log(Level.INFO, "Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();

            }

        }
    }

    public static void insertarCliente(String dni, String nombre, String apellido, String contrasenia,
            String fechaNacimiento) {
        String sent = "INSERT INTO Cliente VALUES('" + dni + "','" + nombre + "','" + apellido + "','" + contrasenia
                + "','" + fechaNacimiento + "')";
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate(sent);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                logger.log(Level.INFO, "Cliente guardado correctamente en la base de datos");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void eliminarCliente(String dni) throws SQLException {
        Statement st = con.createStatement();
        String s = "DELETE FROM CLIENTE WHERE dni = '" + dni + "'";
        st.executeUpdate(s);
        logger.log(Level.INFO, "El cliente ha sido eliminado de la base de datos");
        st.close();
    }
}
