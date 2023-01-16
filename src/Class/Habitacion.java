package Class;

public class Habitacion implements Comparable<Habitacion> {

    public enum TiposHabitacion {
        HABITACION_INDIVIDUAL, HABITACION_DOBLE, HABITACION_TWIN, SUITE, SICO
    }

    private String nombre;
    private String cod;
    private float precio;
    private int numPersonas;
    private TiposHabitacion tiposHabitacion;
    private boolean disponible;
    
    /**
     * Constructor del objeto Habitacion
     * @param nombre
     * @param cod
     * @param precio
     * @param numPersonas
     * @param tiposHabitacion
     * @param disponible
     */
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
    /**
     * Metodo que obtione el nombre de la habitacion
     * @return nombre (string)
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que establece el nombre de la habitacion
     * @param nombre (string)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que obtione el codigo de la habitacion
     * @return codigo (string)
     */
    public String getCod() {
        return cod;
    }
    /**
     * Metodo qur establece el codigo de la habitacion
     * @param cod (string)
     */
    public void setCod(String cod) {
        this.cod = cod;
    }
    /**
     * Metodo que obtione el precio de la habitacion
     * @return precio (float)
     */
    public float getPrecio() {
        return precio;
    }
    /**
     * Metodo que establece el precio de la habitacion
     * @param precio (float)
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    /**
     * Metodo que obtione el numero de personas de la habitacion
     * @return numero de personas (int)
     */
    public int getNumPersonas() {
        return numPersonas;
    }
    /**
     * Metodo que establece el numero de personas de la habitacion
     * @param numPersonas (int)
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    
    /**
     * Metodo que optiene el tipo de habitacion de la habitacion
     * @return tipos de habitacion (enumeracion TiposHabitacion)
     */
    public TiposHabitacion getTiposHabitacion() {
        return tiposHabitacion;
    }
    /**
     * Metodo que establece el tipo de habitacion de la habitacion
     * @param tiposHabitacion (enumeracion TiposHabitacion) 
     */
    public void setTiposHabitacion(TiposHabitacion tiposHabitacion) {
        this.tiposHabitacion = tiposHabitacion;
    }

    /**
     * Metodo que obtione si la habitacion esta disponible o no
     * @return disponibilidad (boolean)
     */
    public boolean isDisponible() {
        return disponible;
    }
    /**
     * Metodo que establece la disponibilidad de la habitacion
     * @param disponibilidad de la habitacion (boolean)
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    /**
     * Metodo toString que devuelve los dato de objeto Habitacion
     * @return string de el nombre, codigo, precio, numero de personas y tipo de habitacion del objeto habitacion
     */
    @Override
    public String toString() {
        String toString = String.format("%s, %s, %2f, %d, %s", nombre, cod, precio, numPersonas,
                tiposHabitacion);
        return toString;

    }
    @Override
    public int compareTo(Habitacion o) {
        // TODO Auto-generated method stub
        return this.cod.compareTo(o.cod);
    }
}
