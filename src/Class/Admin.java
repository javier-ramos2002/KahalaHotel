package Class;

import java.io.Serializable;

public class Administrador implements Serializable{
    
    private static final long  serialVersionUID = 1L;
    private String nom;
    private String dni;
    private String contrasenya;

    public Administrador(String dni, String contrasenya){
        super();

        this.dni = dni;
        this.contrasenya = contrasenya;
    }


    public String setDni(String dni) {
		this.dni = dni;
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