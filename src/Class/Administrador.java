package Class;

public class Administrador{
    
    private String dni;
    private String contrasenia;

    public Administrador(String dni, String contrasenia){
       
        this.dni = dni;
        this.contrasenia = contrasenia;
    }

    public String getDni() {
		return dni;
	}
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    

    public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
    public String getContrasenia() {
		return contrasenia;
	}

    @Override
    public String toString(){
        return  dni + ',' + contrasenia ;
    }
}