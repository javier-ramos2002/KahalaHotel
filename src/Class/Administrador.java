package Class;

public class Administrador {

    private String dni;
    private String contrasenia;

    public Administrador(String dni, String contrasenia) {

        this.dni = dni;
        this.contrasenia = contrasenia;
    }
    /**
     * Metodo que obtione el dni de un administrador
     * @return dni
     */
    public String getDni() {
        return dni;
    }
    /**
     * Metodo que cambia el dni de un administrador
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Metodo que cambia la contasenya de el administrador
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /**
     * Metodo que obtione la contasenya de el administrador
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
     * Metodo que que devuelve en forma de string todos los datos del obejto Administrador
     * @return string dni, contraseya
     */
    @Override
    public String toString() {
        String toString = String.format("%s, %s", dni, contrasenia);
        return toString;
    }
}