package Database;

import java.sql.Statement;

import Class.Cliente;
import Class.Habitacion;
import Class.Reserva;
import Class.ReservaTabla;
import Class.Habitacion.TiposHabitacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBD {

    protected static final String DRIVER_NAME = "org.sqlite.JDBC";
    protected static final String DATABASE_FILE = "db/KahalaHotel.db";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DATABASE_FILE;

    public GestorBD() {
        try {
            // Cargar el diver SQLite
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException ex) {
            System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }

    public static void crearBD() {
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {

            String sql1 = "CREATE TABLE IF NOT EXISTS CLIENTE (\n"
                    + " DNI STRING PRIMARY KEY NOT NULL,\n"
                    + " NOMBRE STRING NOT NULL,\n"
                    + " APELLIDO STRING NOT NULL,\n"
                    + " CONTRASENIA STRING NOT NULL,\n"
                    + " FECHANACIMIENTO STRING NOT NULL\n"
                    + ");";

            String sql2 = "CREATE TABLE IF NOT EXISTS HABITACION (\n"
                    + " NOMBRE STRING NOT NULL,\n"
                    + " COD STRING PRIMARY KEY NOT NULL,\n"
                    + " PRECIO FLOAT NOT NULL,\n"
                    + " NUMPERSONAS INTEGER NOT NULL,\n"
                    + " IMAG STRING NOT NULL,\n"
                    + " TIPOSHABITACION STRING NOT NULL, \n"
                    + " DISPONIBLE STRING NOT NULL \n"
                    + ");";
            
            String sql3 = "CREATE TABLE IF NOT EXISTS RESERVA (\n"
                    + " FECHAINICIO STRING NOT NULL,\n"
                    + " FECHAFIN STRING NOT NULL,\n"
                    + " DNI STRING NOT NULL,\n"
                    + " COD STRING NOT NULL,\n"
                    +" NUMPERSONAS INTEGER NOT NULL \n"
                    + ");";

            if (!stmt.execute(sql1) && !stmt.execute(sql2) && !stmt.execute(sql3)) {
                System.out.println("- Se han creado las tablas correctamente");
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }

    public static void borrarBD() {
        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {

            String sql1 = "DROP TABLE IF EXISTS CLIENTE";
            String sql2 = "DROP TABLE IF EXISTS HABITACION";
            String sql3 = "DROP TABLE IF EXISTS RESERVA";

            // Se ejecuta la sentencia de creación de la tabla Clientes
            if (!stmt.execute(sql1) && !stmt.execute(sql2) && !stmt.execute(sql3)) {
                System.out.println("- Se han borrado las tablas correctamente");
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }

        try {
            // Se borra el fichero de la BBDD
            Files.delete(Paths.get(DATABASE_FILE));
            System.out.println("- Se ha borrado el fichero de la BBDD");
        } catch (Exception ex) {
            System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }

    public static void insertarReserva(Reserva reserva) {
        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            // Se define la plantilla de la sentencia SQL
            String sql = "INSERT INTO RESERVA (FECHAINICIO, FECHAFIN, DNI, COD, NUMPERSONAS) VALUES ('%s', '%s', '%s', '%s', '%d');";

            System.out.println("- Insertando reserva...");

            // Se recorren los clientes y se insertan uno a uno
            for (Habitacion h : reserva.getListaHabitaciones()) {

                if (1 == stmt.executeUpdate(String.format(sql, reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getCliente().getDni(),h.getCod(), reserva.getNumPersonas()))) {
                    System.out.println(String.format("- Reserva insertada: %s", reserva.toString()));
                    cambiarDisponibilidadHabtacion(h.getCod(), "false");
                } else {
                    System.out.println(String.format("- No se ha insertado la reserva: %s", reserva.toString()));
                }
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }
    public static void insertarCliente(Cliente... clientes) {
        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            // Se define la plantilla de la sentencia SQL
            String sql = "INSERT INTO CLIENTE (DNI, NOMBRE, APELLIDO, CONTRASENIA, FECHANACIMIENTO) VALUES ('%s', '%s', '%s', '%s', '%s');";

            System.out.println("- Insertando clientes...");

            // Se recorren los clientes y se insertan uno a uno
            for (Cliente c : clientes) {

                if (1 == stmt.executeUpdate(String.format(sql, c.getDni(), c.getNombre(), c.getApellido(),
                        c.getContrasenia(), c.getFechaNacimiento()))) {
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

    public static void insertarHabitacion(Habitacion... habitaciones) {
        String sql = "INSERT INTO Habitacion (nombre, cod, precio, numPersonas, imag, tiposHabitacion) VALUES (?, ?, ?, ?, ?, ?);";

        // Se abre la conexión y se crea el PreparedStatement con la sentencia SQL
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                PreparedStatement pStmt = con.prepareStatement(sql)) {

            // Se recorren los clientes y se insertan uno a uno
            for (Habitacion h : habitaciones) {
                // Se definen los parámetros de la sentencia SQL
                pStmt.setString(1, h.getNombre());
                pStmt.setString(2, h.getCod());
                pStmt.setFloat(3, h.getPrecio());
                pStmt.setInt(4, h.getNumPersonas());
                pStmt.setString(5, h.getImag());
                pStmt.setString(6, h.getTiposHabitacion().toString());

                if (pStmt.executeUpdate() == 1) {
                    System.out.println(String.format("- Se ha insertado la habitacion: %s", h.toString()));

                } else {
                    System.out.println(String.format("- No se ha insertado la habitacion: %s", h.toString()));
                }
            }

        } catch (Exception ex) {
            System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }

    public static Map<String, Cliente> obtenerDatos() {
        Map<String, Cliente> clientes = new HashMap<>();

        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM CLIENTE";

            // Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
            ResultSet rs = stmt.executeQuery(sql);

            // Se recorre el ResultSet y se crean objetos Cliente
            while (rs.next()) {

                String dni = rs.getString("DNI");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                String contrasenia = rs.getString("CONTRASENIA");
                String fechaNacimineto = rs.getString("FECHANACIMIENTO");
                Cliente cliente = new Cliente(dni, nombre, apellido, contrasenia, fechaNacimineto);

                // Se inserta cada nuevo cliente en la lista de clientes
                clientes.put(contrasenia, cliente);
            }

            // Se cierra el ResultSet
            rs.close();

            System.out.println(String.format("- Se han recuperado %d clientes...", clientes.size()));
        } catch (Exception ex) {
            System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }

        return clientes;
    }

    public static void borrarDatos() {
        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            // Se ejecuta la sentencia de borrado de datos
            String sql1 = "DELETE FROM CLIENTE;";
            String sql2 = "DELETE FROM HABITACION;";

            if (!stmt.execute(sql1) && !stmt.execute(sql2)) {
                System.out.println("- Se han borrado los datos correctamente");
            }
        } catch (Exception ex) {
            System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<Cliente> cargarCliente(String nombreFichero){
        ArrayList<Cliente> al = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero)); ){ 
       
            String linea = br.readLine();
            while(linea!=null) {
                String [] datos = linea.split(";");
                Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                al.add(c);
                linea = br.readLine();
            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        return al;
    }
   
    
   
    public static void cambiarDisponibilidadHabtacion(String cod, String disp) {
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            // Se define la plantilla de la sentencia SQL
            String sql = "UPDATE HABITACION SET DISPONIBLE = '%s' WHERE COD = '%s';";

            System.out.println("- Cambiando disponibilidad...");

            if (1 == stmt.executeUpdate(String.format(sql, disp, cod))) {
                    System.out.println(String.format("- Disponibilidad modificada: %s", cod));
            } else {
                    System.out.println(String.format("- No se ha modificado la disponibilidad: %s", cod));
            }
            
        } catch (Exception ex) {
            System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }

    }
    public static ArrayList<Habitacion> obtenerHabitacionesDisponibles() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM HABITACION WHERE disponible = 'true'";

            // Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
            ResultSet rs = stmt.executeQuery(sql);

            // Se recorre el ResultSet y se crean objetos Cliente
            while (rs.next()) {

                String nombre = rs.getString("NOMBRE");
                String cod = rs.getString("COD");
                float precio = rs.getFloat("PRECIO");
                int numpersonas = rs.getInt("NUMPERSONAS");
                String imag = rs.getString("IMAG");
                String tipo = rs.getString("TIPOSHABITACION");
            
                Habitacion h = new Habitacion(nombre, cod, precio, numpersonas, imag, TiposHabitacion.valueOf(tipo),true);
                habitaciones.add(h);
            }

            // Se cierra el ResultSet
            rs.close();

            System.out.println(String.format("- Se han recuperado %d habitaciones...", habitaciones.size()));
        } catch (Exception ex) {
            System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }

        return habitaciones;
    }
    
    public static String obtenerTipoHabitacion(String cod) {
        String tipo = "";
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM HABITACION WHERE COD = '"+cod+"'";

            // Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
            ResultSet rs = stmt.executeQuery(sql);
            
            // Se recorre el ResultSet y se crean objetos Cliente
            if (rs.next()) {
                tipo = rs.getString("TIPOSHABITACION");
            }

            // Se cierra el ResultSet
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tipo;
    }
    
    public static ArrayList<ReservaTabla> obtenerReservasCliente(String dni) {
        ArrayList<ReservaTabla> reservas = new ArrayList<>();

        // Se abre la conexión y se obtiene el Statement
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
                Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM RESERVA WHERE DNI = '"+dni+"'";

            // Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
            ResultSet rs = stmt.executeQuery(sql);

            // Se recorre el ResultSet y se crean objetos Cliente
            while (rs.next()) {

                String fechainicio = rs.getString("FECHAINICIO");
                String fechafin = rs.getString("FECHAFIN");
                String cod = rs.getString("COD");
                String tipo = obtenerTipoHabitacion(cod);
                Integer numPersonas = rs.getInt("NUMPERSONAS");
                ReservaTabla reserva = new ReservaTabla(fechainicio, fechafin, cod, tipo, numPersonas);
                reservas.add(reserva);
            }

            // Se cierra el ResultSet
            rs.close();

            System.out.println(String.format("- Se han recuperado %d reservas...", reservas.size()));
        } catch (Exception ex) {
            System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
            ex.printStackTrace();
        }

        return reservas;
    }

      
        
    
}