package Class;

import static org.junit.Assert.assertEquals;

public class Habitacion {

    public enum TiposHabitacion{
        HABITACION_INDIVIDUAL, HABITACION_DOBLE, HABITACION_TWIN, SUITE, SICO
    }
    private String nombre;
    private String cod;
    private float precio;
    private int numPersonas;
    private String imag; //a cada habitacion se le asociará una imagen
    private TiposHabitacion tiposHabitacion;

    public Habitacion(String nombre, String cod, float precio, int numPersonas, String imag,
            TiposHabitacion tiposHabitacion) {
        super();
        this.nombre = nombre;
        this.cod = cod;
        this.precio = precio;
        this.numPersonas = numPersonas;
        this.imag = imag;
        this.tiposHabitacion = tiposHabitacion;
    }

   

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getCod() {
        return cod;
    }



    public void setCod(String cod) {
        this.cod = cod;
    }



    public float getPrecio() {
        return precio;
    }



    public void setPrecio(float precio) {
        this.precio = precio;
    }



    public int getNumPersonas() {
        return numPersonas;
    }



    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }



    public String getImag() {
        return imag;
    }



    public void setImag(String imag) {
        this.imag = imag;
    }



    public TiposHabitacion getTiposHabitacion() {
        return tiposHabitacion;
    }



    public void setTiposHabitacion(TiposHabitacion tiposHabitacion) {
        this.tiposHabitacion = tiposHabitacion;
    }

    @Override
    public String toString(){
        String toString = String.format("%s, %s, %2f, %d, %s, %s", nombre, cod, precio, numPersonas, imag, tiposHabitacion);
        return toString;
            
        
    }
}

