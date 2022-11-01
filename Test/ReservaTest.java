import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Class.Cliente;
import Class.Habitacion;
import Class.Reserva;

public class ReservaTest {
    
    private Reserva reserva;
    
    private String fechaInicio = "10/11/2022";
    private String fechaFin = "12/11/2022";
    private Cliente cliente;
    private ArrayList<Habitacion> ListaHabitaciones;
    private  SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yy" );


    @Before
    public void setUp() throws Exception {
        reserva = new Reserva(fechaInicio, fechaFin, cliente, ListaHabitaciones);
    }

    @After
    public void tearDown() throws Exception {
        reserva = null;
    }

    @Test
    public void testReserva() {
        assertNotNull(reserva);
        assertEquals(fechaInicio, reserva.getFechaInicio());
        assertEquals(fechaFin, reserva.getFechaFin());
        assertEquals(cliente, reserva.getCliente());
        assertEquals(ListaHabitaciones, reserva.getListaHabitaciones());
        assertEquals(sdf, reserva.getSdf());
    }

    @Test
    public void testGetFechaInicio() {
        assertEquals(fechaInicio, reserva.getFechaInicio());
    }

    @Test
    public void testSetFechaInicio() {
        reserva.setFechaFin(fechaInicio);
        assertEquals(fechaInicio, reserva.getFechaInicio());
    }

    @Test
    public void testGetFechaFin() {
        assertEquals(fechaFin, reserva.getFechaFin());
    }

    @Test
    public void testSetFechaFin() {
        reserva.setFechaFin(fechaFin);
        assertEquals(fechaFin, reserva.getFechaFin());
    }

    @Test
    public void testGetCliente() {
        assertEquals(cliente, reserva.getCliente());
    }

    @Test
    public void testSetCliente() {
        reserva.setCliente(cliente);
        assertEquals(cliente, reserva.getCliente());
    }

    @Test
    public void testGetListaHabitaciones() {
        assertEquals(ListaHabitaciones, reserva.getListaHabitaciones());
    }

    @Test
    public void testSetListaHabitaciones() {
       reserva.setListaHabitaciones(ListaHabitaciones);
       assertEquals(ListaHabitaciones, reserva.getListaHabitaciones());
    }

    @Test
    public void testGetSdf() {
        assertEquals(sdf, reserva.getSdf());
    }

    @Test
    public void testSetSdf() {
        reserva.setSdf(sdf);
        assertEquals(sdf, reserva.getSdf());
    }

    @Test
    public void testToString() {
        String toString = "Reserva->[fechaInicio=" + fechaInicio +", fechaFin=" + fechaFin + ", cliente=" + cliente + ", ListaHabitaciones=" + ListaHabitaciones+ "]";
        assertEquals(toString, reserva.toString());
    }

}
