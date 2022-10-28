import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.Habitacion;
import Class.Habitacion.TiposHabitacion;

public class HabitacionTest {
    private Habitacion habitacion;
    
    private String nombre;
    private String cod;
    private float precio;
    private int numPersonas;
    private String imag;
    private TiposHabitacion tiposHabitacion;

    @Before
    public void setUp() throws Exception {
        habitacion = new Habitacion(nombre, cod, precio, numPersonas, imag, tiposHabitacion);
    }

    @After
    public void tearDown() throws Exception {
        habitacion = null;
    }

    @Test
    public void testHabitacion() {
        assertNotNull(habitacion);
        assertEquals(nombre, habitacion.getNombre());
        assertEquals(cod, habitacion.getCod());
        assertEquals(precio, precio, habitacion.getPrecio());
        assertEquals(numPersonas, habitacion.getNumPersonas());
        assertEquals(imag, habitacion.getImag());
        assertEquals(tiposHabitacion, habitacion.getTiposHabitacion());

    }

    @Test
    public void testGetNombre() {
        habitacion.setNombre(nombre);
        assertEquals(nombre, habitacion.getNombre());
    }

    @Test
    public void testSetNombre() {
        assertEquals(nombre, habitacion.getNombre());
    }

    @Test
    public void testGetCod() {
        habitacion.setCod(cod);
        assertEquals(cod, habitacion.getCod());
    }

    @Test
    public void testSetCod() {
        assertEquals(cod, habitacion.getCod());
    }

    @Test
    public void testGetPrecio() {
        habitacion.setPrecio(precio);
        assertEquals(precio,precio, habitacion.getPrecio());
    }

    @Test
    public void testSetPrecio() {
        assertEquals(precio,precio, habitacion.getPrecio());
    }

    @Test
    public void testGetNumPersonas() {
        habitacion.setNumPersonas(numPersonas);
        assertEquals(numPersonas, habitacion.getNumPersonas());
    }

    @Test
    public void testSetNumPersonas() {
        assertEquals(numPersonas, habitacion.getNumPersonas());
    }

    @Test
    public void testGetImag() {
        habitacion.setImag(imag);
        assertEquals(imag, habitacion.getImag());
    }

    @Test
    public void testSetImag() {
        assertEquals(imag, habitacion.getImag());
    }

    @Test
    public void testGetTiposHabitacion() {
        habitacion.setTiposHabitacion(tiposHabitacion);
        assertEquals(tiposHabitacion, habitacion.getTiposHabitacion());
    }

    @Test
    public void testSetTiposHabitacion() {
        assertEquals(tiposHabitacion, habitacion.getTiposHabitacion());
    }

    @Test
    public void testToString() {
        String toString = String.format("%s, %s, %s, %s, %s, %s", nombre, cod, precio, numPersonas, imag, tiposHabitacion);
        assertEquals(toString, habitacion.toString());
    }

}
