package Class;



public class Cliente {
    private String nom;
    private String dni;
    private String con;
    private long fechanacim;

    public Cliente(String nom, String dni, String con, long fechanacim){
        super();
        this.con = con;
        this.nom = nom;
        this.dni = dni;
        this.fechanacim = fechanacim;
    }

    public void setCon(String con) {
		this.con = con;
	}
    public String getCon() {
		return con;
	}
    public void setNom(String nom) {
		this.nom = nom;
	}
    public String getNom() {
		return nom;
	}
    public void setDni(String dni) {
		this.dni = dni;
	}
    public String getDni() {
		return dni;
	}
    public void setFechanacim(long Fechanacim) {
		this.fechanacim = fechanacim;

	}
    public long getFechanacim() {
		return fechanacim;
	}

    public String toString(){
        return nom + ',' + dni + ',' + con + ',' + fechanacim;
    }






    
    
}
