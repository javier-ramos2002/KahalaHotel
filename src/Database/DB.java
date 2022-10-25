package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class DB {
        private static Connection con;
        private static Logger logger = Logger.getLogger( "BD" );
        
        public static void initBD(String nombreBD) {  
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
                logger.log(Level.INFO, "Conexión establecida con jdbc:sqlite:"+nombreBD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void closeBD() {
            if(con!=null) {
                try {
                    con.close();
                    logger.log(Level.INFO, "Conexión cerrada");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
