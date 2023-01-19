package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Class.Habitacion;
import Class.Reserva;
import Database.GestorBD;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VReserva extends JFrame {
	
	private JPanel contentPane, pCentro, pBotonera;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JLabel lblCodigoHabitación;
	private JLabel lblnumPersonas;
	private JComboBox cbHabitacion;
	private JComboBox cbNumPersonas;
	private JButton btnReservar, btnAniadirHabitacion;
	private Reserva reserva;
	/**
	 * Create the frame.
	 */
	public VReserva(Cliente c) {
		reserva = new Reserva(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		pCentro = new JPanel(new GridLayout(0, 2, 0, 0));
		
		lblFechaInicio = new JLabel("Introduce la fecha de inicio:");
		pCentro.add(lblFechaInicio);
		
		txtFechaInicio = new JTextField();
		pCentro.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		lblFechaFin = new JLabel("Introduce la fecha de fin:");
		pCentro.add(lblFechaFin);
		
		txtFechaFin = new JTextField();
		pCentro.add(txtFechaFin);
		txtFechaFin.setColumns(10);
		
		lblnumPersonas = new JLabel("Introduce el número de personas:");
        pCentro.add(lblnumPersonas);
        
        cbNumPersonas = new JComboBox();
        cbNumPersonas.addItem(1);
        cbNumPersonas.addItem(2);
        cbNumPersonas.addItem(3);
        cbNumPersonas.addItem(4);
        cbNumPersonas.addItem(5);
        cbNumPersonas.addItem(6);
        cbNumPersonas.addItem(7);
        pCentro.add(cbNumPersonas);
		
		lblCodigoHabitación = new JLabel("Elige la habitación: ");
		pCentro.add(lblCodigoHabitación);
		GestorBD.obtenerHabitacion();
		ArrayList<Habitacion> habitaciones = GestorBD.obtenerHabitacionesDisponibles();
		cbHabitacion = new JComboBox(habitaciones.toArray());
		pCentro.add(cbHabitacion);
		
		pCentro.add(new JPanel());
		btnAniadirHabitacion = new JButton("AÑADIR HABITACIÓN");
		pCentro.add(btnAniadirHabitacion);
		
		pBotonera = new JPanel();
		btnReservar = new JButton("RESERVAR");
		pBotonera.add(btnReservar);
		contentPane.add(pCentro, BorderLayout.CENTER);
		contentPane.add(pBotonera, BorderLayout.SOUTH);
		
		btnAniadirHabitacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Habitacion h = (Habitacion)cbHabitacion.getSelectedItem();
				if((int) cbNumPersonas.getSelectedItem() > h.getNumPersonas()) {
				    JOptionPane.showMessageDialog(null, "Has superado el límite de personas de la habitación");
				}
				else {
				reserva.getListaHabitaciones().add(h);
				cbHabitacion.removeItem(h);
				}
			}
		});
		btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtFechaInicio.getText().equals("") || txtFechaFin.getText().equals("")|| reserva.getListaHabitaciones().size()==0) {
					JOptionPane.showMessageDialog(null, "Faltan campos por rellenar");
				
				}else {
					reserva.setFechaInicio(txtFechaInicio.getText());
					reserva.setFechaFin(txtFechaFin.getText());
					reserva.setNumPersonas((int) cbNumPersonas.getSelectedItem());
					GestorBD.insertarReserva(reserva);
					JOptionPane.showMessageDialog(null, "Reserva realizada correctamente");
					dispose();
		            Main m = new Main(c);
		            m.setVisible(true);
				}
				
			}
		});
	}

}
