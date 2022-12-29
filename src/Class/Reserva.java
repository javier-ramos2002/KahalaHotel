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
    
    public Reserva(Cliente cliente) {
        this.cliente = cliente;
        this.ListaHabitaciones = new ArrayList<>();
    }

    public Reserva(int cod, String fechaInicio, String fechaFin, Cliente cliente, ArrayList<Habitacion> alHabitaciones, int numPersonas) {
        super();
        cod++;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.ListaHabitaciones = alHabitaciones;
        this.numPersonas = numPersonas;
    }
    
    
    public int getCod() {
        return cod;
    }
   
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return ListaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        ListaHabitaciones = listaHabitaciones;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    
    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

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

    public String toString() {
        return "Reserva->[fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cliente=" + cliente
                + ", ListaHabitaciones=" + ListaHabitaciones + "]";
    }

}
