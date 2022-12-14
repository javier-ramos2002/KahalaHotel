package Class;

public class Habitacion {

    public enum TiposHabitacion {
        HABITACION_INDIVIDUAL, HABITACION_DOBLE, HABITACION_TWIN, SUITE, SICO
    }

    private String nombre;
    private String cod;
    private float precio;
    private int numPersonas;
    private TiposHabitacion tiposHabitacion;
    private boolean disponible;

    public Habitacion(String nombre, String cod, float precio, int numPersonas,
            TiposHabitacion tiposHabitacion, boolean disponible) {
        super();
        this.nombre = nombre;
        this.cod = cod;
        this.precio = precio;
        this.numPersonas = numPersonas;
        this.tiposHabitacion = tiposHabitacion;
        this.disponible = disponible;
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

    

    public TiposHabitacion getTiposHabitacion() {
        return tiposHabitacion;
    }

    public void setTiposHabitacion(TiposHabitacion tiposHabitacion) {
        this.tiposHabitacion = tiposHabitacion;
    }

    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        String toString = String.format("%s, %s, %2f, %d, %s", nombre, cod, precio, numPersonas,
                tiposHabitacion);
        return toString;

    }
}
