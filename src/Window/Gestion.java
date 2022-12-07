package Window;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Database.GestorBD;

import java.awt.BorderLayout;
import java.awt.Color;

public class Gestion extends JFrame {

    private JPanel contentPane;
    private JScrollPane scrollC;
    private JList<Cliente> listaC;
    private DefaultListModel<Cliente> modeloC;
    private JPanel panelNorte;

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
        
        panelNorte = new JPanel();
        panelNorte.setBackground(new Color(255, 255, 255));
        contentPane.add(panelNorte, BorderLayout.NORTH);
        
        modeloC = new DefaultListModel<>();
        listaC = new JList<>(modeloC);
        scrollC = new JScrollPane(listaC);
        panelNorte.add(scrollC);
        cargarModeloC();
    }
    
    private void cargarModeloC() {
        ArrayList<Cliente> al = GestorBD.cargarCliente("Cliente.csv");
        for(Cliente c: al) {
            modeloC.addElement(c);
        }
    }
}
