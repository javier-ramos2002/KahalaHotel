package Class;

public class Cliente {
    private String dni;
    private String nom;
    private String ape;
    private String con;
    private String fechanacim;

    public Cliente(String dni, String nom, String ape, String con, String fechanacim){
        super();
        this.dni = dni;
        this.nom = nom; 
        this.nom = ape;
        this.con = con;            
        this.fechanacim = fechanacim;
    }

    public void setDni(String dni) {
    	this.dni = dni;
    }

    public String getDni() {
    	return dni;
    }

    public void setNom(String nom) {
    	this.nom = nom;
    }

    public String getNom() {
    	return nom;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getApe() {
        return ape;
    }

    public void setCon(String con) {
		this.con = con;
	}
    public String getCon() {
		return con;
	}
    public void setFechanacim(long Fechanacim) {
		this.fechanacim = fechanacim;

	}
    public String getFechanacim() {
		return fechanacim;
	}

    public String toString(){
        return dni + ',' + nom + ',' + ape + ',' + con + ',' + fechanacim;
    }






    
    
}
