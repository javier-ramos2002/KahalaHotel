package Class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Reserva {

    private String fechaInicio;
    private String fechaFin;
    private Cliente cliente;
    private ArrayList<Habitacion> ListaHabitaciones;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public Reserva(String fechaInicio, String fechaFin, Cliente cliente, ArrayList<Habitacion> alHabitaciones) {

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.ListaHabitaciones = alHabitaciones;

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
