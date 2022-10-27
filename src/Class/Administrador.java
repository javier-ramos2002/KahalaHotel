package Class;

public class Administrador{
    
    private String dni;
    private String contrasenia;

    public Administrador(String dni, String contrasenia){
       
        super();
        this.dni = dni;
        this.contrasenia = contrasenia;
    }

    public String getDni() {
		return dni;
	}

    public void setContrasenia(String contrasenya) {
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