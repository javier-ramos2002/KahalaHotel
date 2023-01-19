package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaTabla {
	private String fechaInicio;
	private String fechaFin;
	private String cod;
	private String tipo;
	private int numPersonas;
	 
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	  
	public ReservaTabla() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor del objeto reserva tabla
	 * @param fechaInicio
	 * @param fechaFin
	 * @param cod
	 * @param tipo
	 * @param numPersonas
	 */
	public ReservaTabla(String fechaInicio, String fechaFin, String cod, String tipo, int numPersonas) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cod = cod;
		this.tipo = tipo;
		this.numPersonas = numPersonas;
	}
	/**
     * Metodo que obtione el la fecha de inicio del objeto ReservaTabla
     * @return fecha de inicio (string)
     */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
     * Metodo que establece la fecha de inicio del objeto ReservaTabla
     * @param fechaInicio (string)
     */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
     * Metodo que obtione la fecha fin del objeto ReservaTabla
     * @return fecha fin (string)
     */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
     * Metodo que establece la fecha de fin del objeto ReservaTabla
     * @param fechaFin (string)
     */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
     * Metodo que obtione el codigo del objeto ReservaTabla
     * @return codigo (string)
     */
	public String getCod() {
		return cod;
	}
	/**
     * Metodo que establece el codigo del objeto ReservaTabla
     * @param codigo (string)
     */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
     * Metodo que obtione el tipo del objeto ReservaTabla
     * @return tipo (string)
     */
	public String getTipo() {
		return tipo;
	}
	/**
     * Metodo que establece el tipo del objeto ReservaTabla
     * @param tipo (string)
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
     * Metodo que obtione el numero de personas del objeto ReservaTabla
     * @return numero de personas (int)
     */
    public int getNumPersonas() {
        return numPersonas;
    }
    /**
     * Metodo que establece el numero de personas del objeto ReservaTabla
     * @param numero de personas (int)
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

}
