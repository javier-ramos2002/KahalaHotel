package Class;

import java.text.SimpleDateFormat;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String fechaNacimiento;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    public Cliente() {
        super();
    }
    /**
     * Constructor del objeto Cliente
     * @param dni
     * @param nombre
     * @param apellido
     * @param contrasenia
     * @param fechaNacimiento
     */
    public Cliente(String dni, String nombre, String apellido, String contrasenia, String fechaNacimiento) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Metodo que cambia/establece el dni de un cliente
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Metodo que devuelve el dni del Cliente
     * @return Dni del cliente (string)
     */
    public String getDni() {
        return dni;
    }
    /**
     * Metodo que establece el nombre de un Cliente
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que devielve el nombre del Cliente
     * @return nombre (string)
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que establece en apellido de un cliente
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Metodo que obtione el apellido de un cliente
     * @return apellido (string)
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * metodo que establece la contrasenya del cliente
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /**
     * Metodo que obtione la contrasenya del Cliente
     * @return contrasenya (string)
     */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
     * metoodo que establece la Fecha de nacimiento del Cliente
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;

    }
    /**
     * Metodo que obtione la Fecha de Nacimiento del Cliente
     * @return fecha de nacimiento (string)
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Metodo que obtiene la fecha en Simple Date Format
     * @return sdf SimpleDateFormat
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }
    /**
     * Metodo que establece la fecha en Simple Date Format
     * @param sdf
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
    /**
     * Metodo to string que devuelve los datos del Cliente 
     * @return string del dni, apellido, contrasenya y fecha de nacimiento del cliente
     */
    public String toString() {
        String toString = String.format("%s, %s, %s, %s, %s", dni, nombre, apellido, contrasenia, fechaNacimiento);
        return toString;
    }

}
