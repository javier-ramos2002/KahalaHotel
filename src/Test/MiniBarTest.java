package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.MiniBar;
import Class.MiniBar.TiposProductos;

public class MiniBarTest {
    private MiniBar miniBar;
    
    private float precio = (float) 4.5;
    private TiposProductos tiposProductos = TiposProductos.CERVEZA;

    @Before
    public void setUp() throws Exception {
        miniBar = new MiniBar(precio, tiposProductos);
    }

    @After
    public void tearDown() throws Exception {
        miniBar = null;
    }

    @Test
    public void testMiniBar() {
        assertNotNull(miniBar);
        assertEquals(precio,precio, miniBar.getPrecio());
        assertEquals(tiposProductos, miniBar.getTiposProductos());
    }

    @Test
    public void testGetPrecio() {
        miniBar.setPrecio(precio);
        assertEquals(precio, precio, miniBar.getPrecio());
    }

    @Test
    public void testSetPrecio() {
        assertEquals(precio, precio, miniBar.getPrecio());
    }

    @Test
    public void testGetTiposProductos() {
        miniBar.setTiposProductos(tiposProductos);
        assertEquals(tiposProductos, miniBar.getTiposProductos());
    }

    @Test
    public void testSetTiposProductos() {
        assertEquals(tiposProductos, miniBar.getTiposProductos());
    }

    @Test
    public void testToString() {
        String toString = String.format("%2f, %s",precio, tiposProductos);
        assertEquals(toString, miniBar.toString());
    }

}
