package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaCheckOut extends JFrame {

    private JPanel contentPane;
    
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;

    private JFrame v,va;
    private JButton btnVolver;
    
    public static float precioTotal;

    /**
     * Create the frame.
     */
    public VentanaCheckOut(JFrame va) {
        precioTotal = 0;
        v = this;
        this.va = va;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        String [] titulos = {"FECHAINICIO", "FECHAFIN", "DNI", "COD", "NUMPERSONAS"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(titulos);
        cargarModelo();
        tabla = new JTable(modelo);
        scroll = new JScrollPane(tabla);
        contentPane.add(scroll,BorderLayout.CENTER);
        btnVolver = new JButton("Volver");
        contentPane.add(btnVolver,BorderLayout.SOUTH);
        setContentPane(contentPane);
        setVisible(true);
        
        btnVolver.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                va.setVisible(true);
                v.setVisible(false);
            }
        });
    }
    
    
    private void cargarModelo() {
        
        for(Object [] fila: Check_in.co) {
            modelo.addRow(fila);
        }
    }

}
