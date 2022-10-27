import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.Administrador;

public class AdministradorTest {
    private Administrador administrador;
    private String dni;
    private String contrasenia;

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
        administrador.se
        assertEquals(dni, cliente.getDni());
    }

    @Test
    public void testGetDni() {
        administrador.getDni(dni);
    }

    @Test
    public void testSetContrasenia() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetContrasenia() {
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

}
