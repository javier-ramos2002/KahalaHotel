package Class;

import java.text.SimpleDateFormat;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String fechaNacimiento;
    
    private  SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yy" );

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
    public void setFechaNacimiento(String FechaNacimento) {
		this.fechaNacimiento = fechaNacimiento;

	}
    public String getFechaNacimiento() {
		return fechaNacimiento;
	}
    

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String toString(){
        String toString = String.format("%s, %s, %s, %s, %s", dni, nombre, apellido, contrasenia, fechaNacimiento);
        return toString;
    }






    
    
}
