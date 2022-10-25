package Class;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String fechaNacimiento;

    public Cliente(String dni, String nombre, String apellido, String contrasenia, String fechaNacimiento){
        super();
        this.dni = dni;
        this.nombre = nombre; 
        this.apellido = apellido;
        this.contrasenia = contrasenia;            
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDni(String dni) {
    	this.dni = dni;
    }

    public String getDni() {
    	return dni;
    }

    public void setNombre(String nom) {
    	this.nombre = nombre;
    }

    public String getNombre() {
    	return nombre;
    }

    public void setApellido(String ape) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setContrasenia(String con) {
		this.contrasenia = contrasenia;
	}
    public String getContrasenia() {
		return contrasenia;
	}
    public void setFechaNacimiento(long Fechanacim) {
		this.fechaNacimiento = fechaNacimiento;

	}
    public String getFechaNacimiento() {
		return fechaNacimiento;
	}

    public String toString(){
        return dni + ',' + nombre + ',' + apellido + ',' + contrasenia + ',' + fechaNacimiento;
    }






    
    
}
