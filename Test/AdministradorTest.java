import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.Administrador;

public class AdministradorTest {
    private Administrador administrador;
    private String dni = "78453809G";
    private String contrasenia = "contrasenia";

    @Before
    public void setUp() throws Exception {
        administrador = new Administrador(dni, contrasenia);
    }

    @After
    public void tearDown() throws Exception {
        administrador = null;
    }

    @Test
    public void testAdministrador() {
        assertNotNull(administrador);
        assertEquals(dni, administrador.getDni());
        assertEquals(contrasenia, administrador.getContrasenia());
    }

    @Test
    public void testSetDni() {
        administrador.setDni(dni);
        assertEquals(dni, administrador.getDni());
    }

    @Test
    public void testGetDni() {
        assertEquals(dni, administrador.getDni());
    }

    @Test
    public void testSetContrasenia() {
        administrador.setContrasenia(contrasenia);
        assertEquals(contrasenia, administrador.getContrasenia());
    }

    @Test
    public void testGetContrasenia() {
        assertEquals(contrasenia, administrador.getContrasenia());
    }

    @Test
    public void testToString() {
        String toString = String.format("%s, %s", dni, contrasenia);
        assertEquals(toString, administrador.toString());
    }

}
