package Window;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Class.Cliente;
import Class.ReservaTabla;
import Database.GestorBD;

import java.awt.BorderLayout;
import java.awt.Color;

public class Gestion extends JFrame {
    private JPanel contentPane;
    private JScrollPane scrollC;
    private JList<Cliente> listaC;
    private DefaultListModel<Cliente> modeloC;
    
    private DefaultTableModel modeloR;
    private JTable tablaR;
    private JScrollPane scrollR;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gestion frame = new Gestion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Gestion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        
        modeloC = new DefaultListModel<>();
        listaC = new JList<>(modeloC);
        scrollC = new JScrollPane(listaC);
        contentPane.add(scrollC, BorderLayout.NORTH);
        
        cargarModeloC();
        
        String [] titulos = {"FECHA INICIO","FECHA FIN","CÓDIGO HABITACIÓN","TIPO", "NUMPERSONAS"};
        modeloR = new DefaultTableModel();
        modeloR.setColumnIdentifiers(titulos);
        tablaR = new JTable(modeloR);
        scrollR = new JScrollPane(tablaR);
        contentPane.add(scrollR, BorderLayout.CENTER);
        
        listaC.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Cliente c = listaC.getSelectedValue();
                cargarModeloR(c.getDni());
            }
        });
    }
    
    private void cargarModeloC() {
        HashMap<String, Cliente> hm = (HashMap<String, Cliente>) GestorBD.obtenerDatos();
        for(Cliente c: hm.values()) {
            modeloC.addElement(c);
        }
    }
    
    private void cargarModeloR(String dni) {
        while(modeloR.getRowCount()>0) {
            modeloR.removeRow(0);
        }
        for(ReservaTabla rt: GestorBD.obtenerReservasCliente(dni)) {
            Object [] fila = {rt.getFechaInicio(),rt.getFechaFin(),rt.getCod(),rt.getTipo(), rt.getNumPersonas()};
            modeloR.addRow(fila);
        }
    }
}
