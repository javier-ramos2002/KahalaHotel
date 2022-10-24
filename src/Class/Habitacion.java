package Class;

public class Habitacion {

    private String nombre;
    private int cod;
    private float precio;
    private int numPersonas;
    private String imag; //a cada habitacion se le asociará una imagen

    public Habitacion(String nombre, int cod, float precio, String imag){
        super();
        this.nombre = nombre;
        this.cod = cod;
        this.precio = precio;
        this.numPersonas = numPersonas;
        this.imag = imag;
    }

    public Habitacion(){
        super();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setCod(String cod){
        this.cod = cod;
    }
    public String getCod(){
        return cod;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getPrecio(){
        return precio;
    }
    public void numPersonas(int numPersonas){
        this.numPersonas = numPersonas;
    }
    public int numPersonas(){
        return numPersonas;
    }
    public void setImag(String imag){
        this.imag = imag;
    }
    public String getImag(){
        return imag;
    }

    @Override
    public String toString(){
        return ""+nombre+"\t"+"Precio: "+precio;
    }
}

