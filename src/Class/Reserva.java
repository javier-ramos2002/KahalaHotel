package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    
    private int cod; 
    private String fechaInicio;
    private String fechaFin;
    private Cliente cliente;
    private ArrayList<Habitacion> ListaHabitaciones;
    private int numPersonas;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    
    /**
     * Constructor que crea un nuevo arraylist de habitaciones
     * @param cliente
     */
    public Reserva(Cliente cliente) {
        this.cliente = cliente;
        this.ListaHabitaciones = new ArrayList<>();
    }
    /**
     * Constructor del objeto reserva
     * @param cod
     * @param fechaInicio
     * @param fechaFin
     * @param cliente
     * @param alHabitaciones
     * @param numPersonas
     */
    public Reserva(int cod, String fechaInicio, String fechaFin, Cliente cliente, ArrayList<Habitacion> alHabitaciones, int numPersonas) {
        this.cod = cod;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.ListaHabitaciones = alHabitaciones;
        this.numPersonas = numPersonas;
    }
    
    /**
     * Metodo que obtione el codigo del objeto reserva
     * @return codigo (int)
     */
    public int getCod() {
        return cod;
    }
   /**
    * Metodo que establece el codigo del objeto reserva
    * @param cod (int)
    */
    public void setCod(int cod) {
        this.cod = cod;
    }
    /**
     * Metodo que obtiene la fecha de inicio del objeto reserva
     * @return
     */
    public String getFechaInicio() {
        return fechaInicio;
    }
    /**
     * Metodo que establece la fecha de inicio del objeto reserva
     * @param fechaInicio (string)
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    /**
     * Metodo que obtiene la fecha de fin del objeto reserva
     * @return fecha fin (string)
     */
    public String getFechaFin() {
        return fechaFin;
    }
    /**
     * Metodo que establece la fecha fin del objeto reserva
     * @param fechaFin (string)
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    /**
     * Metodo que obtioene el cliente del objeto reserva
     * @return cliente (obj)
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Metodo que stablece el cliente del objeto reserva
     * @param cliente (obj)
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Metodo que obtiene el arraylist de habitaciones del objeto reserva
     * @return ListaHabitaciones (arrayList)
     */
    public ArrayList<Habitacion> getListaHabitaciones() {
        return ListaHabitaciones;
    }
    /**
     * Metodo que establece el arraylist de habitaciones del objeto reserva
     * @param listaHabitaciones
     */
    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        ListaHabitaciones = listaHabitaciones;
    }
    /**
     * metodo que obtiene el la fecha en simple date format del objeto reserva
     * @return fecha (simple date format)
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }
    /**
     * Metodo que establece la fecha en simple date format del onjeto rserva
     * @param sdf
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    /**
     * Metodo que obtiene el numero de personas del objeto reserva
     * @return numero de personas (int)
     */
    public int getNumPersonas() {
        return numPersonas;
    }
    /**
     * Metodo que establece el numero de personas del objeto reserva
     * @param numPersonas (int)
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    /**
     * Metodo que calcula el numero de dias de una reserva, usando la decha de inicio y la de fin
     * @return numero de dias (int)
     */
    public int numeroDeDias() {
    	int num = 0;
    	try {
			Date fi = sdf.parse(fechaInicio);
			Date ff = sdf.parse(fechaFin);
			num = (int) ((ff.getTime()-fi.getTime()) / (24*60*60*1000));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return num;
    }
    /**
     * Metodo to string que devuelve los datos del objeto reserva
     * @return fecha de inicio, fecha de fin, cliente, lista habitaciones
     */
    public String toString() {
        return "Reserva->[fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cliente=" + cliente
                + ", ListaHabitaciones=" + ListaHabitaciones + "]";
    }

}
