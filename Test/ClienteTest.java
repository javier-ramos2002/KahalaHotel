import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.Cliente;

public class ClienteTest {
    private Cliente cliente;
    
    
    private String dni = "45616147R";
    private String nombre = "Nombre";
    private String apellido = "Apellido";
    private String contrasenia = "Contrasenia ";
    private String fechaNacimiento = "01/01/2000";

    @Before
    public void setUp() throws Exception {
        cliente = new Cliente(dni, nombre,apellido, contrasenia, fechaNacimiento);
        
        
        
    }

    @After
    public void tearDown() throws Exception {
        cliente = null;
        
    }

    @Test
    public void testCliente() {
        assertNotNull(cliente);
        assertEquals(dni, cliente.getDni());
        assertEquals(nombre, cliente.getNombre());
        assertEquals(apellido, cliente.getApellido());
        assertEquals(contrasenia, cliente.getContrasenia());
        assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
            
    }

    @Test
    public void testSetDni() {
        
       cliente.setDni(dni);
       assertEquals(dni, cliente.getDni());
       
    }

    @Test
    public void testGetDni() {
        
        assertEquals(dni, cliente.getDni());
      
    }

    @Test
    public void testSetNombre() {
        
       cliente.setNombre(nombre);
       assertEquals(nombre, cliente.getNombre());
    }

    @Test
    public void testGetNombre() {
     assertEquals(nombre, cliente.getNombre());
    }

    @Test
    public void testSetApellido() {
        cliente.setApellido(apellido);
        assertEquals(apellido, cliente.getApellido());
    }

    @Test
    public void testGetApellido() {
        assertEquals(apellido, cliente.getApellido());
    }

    @Test
    public void testSetContrasenia() {
        cliente.setContrasenia(contrasenia);
        assertEquals(contrasenia, cliente.getContrasenia());
    }

    @Test
    public void testGetContrasenia() {
        assertEquals(contrasenia, cliente.getContrasenia());
    }

    @Test
    public void testSetFechaNacimiento() {
        cliente.setFechaNacimiento(fechaNacimiento);
        assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
    }

    @Test
    public void testToString() {
        String toString = String.format("%s, %s, %s, %s, %s", dni, nombre, apellido, contrasenia, fechaNacimiento);
        assertEquals(toString, cliente.toString());
    }

}
