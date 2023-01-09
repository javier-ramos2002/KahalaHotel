package Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Class.ReservaTabla;
import Database.GestorBD;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;

public class Check_in extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnCheckIn;
	private JFrame va;
	
	public static ArrayList<Object[]> co;

	

	/**
	 * Create the frame.
	 */
	public Check_in(JFrame va) {

	    this.va = va;
	    co = new ArrayList<>();
	    // Establece el tamaño de la ventana
	    setSize(500, 500);
	    String [] titulos = {"FECHAINICIO", "FECHAFIN", "DNI", "COD", "NUMPERSONAS"};
	    modelo = new DefaultTableModel();
	    cargarModelo();
	    modelo.setColumnIdentifiers(titulos);
	    table = new JTable(modelo);
	    scroll = new JScrollPane(table);
	    
	    btnCheckIn = new JButton("Check In");
	    btnCheckIn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int f = table.getSelectedRow();
	            Object [] fila = {modelo.getValueAt(f, 0),modelo.getValueAt(f, 1),modelo.getValueAt(f, 2),modelo.getValueAt(f, 3),modelo.getValueAt(f, 4)};
	            co.add(fila);
	        }
	    });
	    
	    JButton btnVolver = new JButton("Volver");
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            setVisible(false);
                va.setVisible(true);
                
	            
	        }
	    });
	    
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGap(128)
	                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addComponent(btnCheckIn)
	                        .addGap(53)
	                        .addComponent(btnVolver)))
	                .addContainerGap())
	    );
	    groupLayout.setVerticalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
	                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	                    .addComponent(btnCheckIn)
	                    .addComponent(btnVolver))
	                .addGap(75))
	    );
	    getContentPane().setLayout(groupLayout);
	    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
	            Component c = super.getTableCellRendererComponent(table,value,isSelected, hasFocus,row,column);
	            c.setForeground(Color.BLACK);
	            return c;
	            
	        }
	    });
	   
	  }
	
	private void cargarModelo() {
	    ArrayList<ReservaTabla> a = GestorBD.obtenerReservasCliente(InicioSesion.dni);
	    System.out.println("Se van a cargar "+a.size()+" reservas");
	    for(ReservaTabla rt : a) {
	        Object [] fila = {rt.getFechaInicio(),rt.getFechaFin(),InicioSesion.dni,rt.getCod(),rt.getNumPersonas()};
	        System.out.println(fila[0]);
	        modelo.addRow(fila);
	    }
	}
}
