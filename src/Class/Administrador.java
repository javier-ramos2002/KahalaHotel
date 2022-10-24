package Class;

public class Administrador{
    
    private String dni;
    private String contrasenya;

    public Administrador(String dni, String contrasenya){
       
        super();
        this.dni = dni;
        this.contrasenya = contrasenya;
    }

    public String getDni() {
		return dni;
	}

    public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
    public String getContrasenya() {
		return contrasenya;
	}

    @Override
    public String toString(){
        return  dni + ',' + contrasenya ;
    }
}