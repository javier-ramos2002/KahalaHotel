package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.mail.MessagingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import Class.Cliente;
import Class.Recibo;
import Class.ReservaTabla;
import Database.GestorBD;

public class CheckOut extends JFrame  {
    private JButton btnCheckOut;
    private static JButton btnMiniBar;
    private static JButton btnRecibo;
    public static float precioTotal;
    
    private JPanel contentPane;
    
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;

    private JFrame v,va;
    private JButton btnVolver;
    
    private int fila;
    public CheckOut(JFrame va) {
        
        
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
        setContentPane(contentPane);
        setVisible(true);
        setSize(800,  800);
        
        btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fila = tabla.getSelectedRow();
                String cod = (String)modelo.getValueAt(fila, 3);
                float precio = GestorBD.obtenerPrecioHabitacion(cod);
                precioTotal = 0;
                int filaci = Check_in.mapa.get(fila);
                ReservaTabla rt = Check_in.a.get(filaci);
                precioTotal += precio * rt.numeroDeDias();
                System.out.println("PRECIO; "+precioTotal);
                btnMiniBar.setEnabled(true);
                btnRecibo.setEnabled(true);
                GestorBD.cambiarDisponibilidadHabtacion(cod, "true");
                modelo.removeRow(fila);
                GestorBD.borrarReserva(rt,InicioSesion.dni);
                //Check_in.a.remove(filaci);
            }
        });
        
        btnMiniBar = new JButton("Mini Bar");
        btnMiniBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                MiniBar b = new MiniBar();
                b.setVisible(true);
                
            }
        });
        
        btnRecibo = new JButton("Recibo");
        btnRecibo.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente c = GestorBD.obtenerCliente().get(InicioSesion.dni);
                ReservaTabla rt = Check_in.a.get(fila);
                Recibo.crearRecibo(c, rt, new Document());
                JOptionPane.showMessageDialog(null, "Ya tienes disponible tu recibo");
                try {
                    Recibo.guardardPDF(c, rt);
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (MessagingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
             
            }
        });
        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main m = new Main(null);
                m.setVisible(true);
            }
            
        });
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(84)
                            .addComponent(btnCheckOut)
                            .addGap(46)
                            .addComponent(btnMiniBar)
                            .addGap(48)
                            .addComponent(btnRecibo))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(371, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnRecibo)
                        .addComponent(btnCheckOut)
                        .addComponent(btnMiniBar))
                    .addGap(37)
                    .addComponent(btnNewButton)
                    .addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
        
        
        desactivarBotonMiniBar();
        desactivarBotonRecivo();
    }
    
    
    /**
     * metodo que desactiva el boton del minibar
     */
    public static void desactivarBotonMiniBar() {
        btnMiniBar.setEnabled(false);
 
    }
    /**
     * metodo que activa el boton del minibar 
     */
    public static void desactivarBotonRecivo() {
        btnRecibo.setEnabled(false);
    }
    
    private void cargarModelo() {
        
        for(Object [] fila: Check_in.co) {
            modelo.addRow(fila);
        }
}
}
