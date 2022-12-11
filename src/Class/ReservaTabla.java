package Class;

public class ReservaTabla {
	private String fechaInicio;
	private String fechaFin;
	private String cod;
	private String tipo;
	public ReservaTabla() {
		// TODO Auto-generated constructor stub
	}
	public ReservaTabla(String fechaInicio, String fechaFin, String cod, String tipo) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cod = cod;
		this.tipo = tipo;
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
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
