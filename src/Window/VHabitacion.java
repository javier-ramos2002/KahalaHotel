package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Class.Habitacion;
import Class.Habitacion.TiposHabitacion;
import Database.GestorBD;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class VHabitacion extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldCodigo;
    private JTextField textFieldPrecio;
    private JButton btnVolver;
    private JButton btnAniadirHabitacion;
    private JLabel lblCod;
    private JLabel lblPrecio;
    private JLabel lblTipo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VHabitacion frame = new VHabitacion();
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
    public VHabitacion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        JComboBox comboBoxTipoHabitacion = new JComboBox(Habitacion.TiposHabitacion.values());
        
        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        
        textFieldCodigo = new JTextField();
        textFieldCodigo.setColumns(10);
        
        textFieldPrecio = new JTextField();
        textFieldPrecio.setColumns(10);
        
        btnVolver = new JButton("Volver");
        
        btnAniadirHabitacion = new JButton("Añadir Habitación");
        
        JLabel lblNombre = new JLabel("Nombre:");
        
        lblCod = new JLabel("Código:");
        
        lblPrecio = new JLabel("Precio:");
        
        lblTipo = new JLabel("Tipo:");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap(116, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(btnAniadirHabitacion)
                                    .addGap(109)
                                    .addComponent(btnVolver)
                                    .addPreferredGap(ComponentPlacement.RELATED))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(28)
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBoxTipoHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
                    .addGap(10))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(41)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(31)
                            .addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(153)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnAniadirHabitacion)
                                .addComponent(btnVolver)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(40)
                            .addComponent(lblCod)
                            .addGap(39)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblPrecio)
                                .addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(34)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblTipo)
                                .addComponent(comboBoxTipoHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
        );
        contentPane.setLayout(gl_contentPane);
        
        btnAniadirHabitacion.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String nombre = textFieldNombre.getText();
                String cod = textFieldCodigo.getText();
                float precio = Float.parseFloat(textFieldPrecio.getText());
                TiposHabitacion tipoHabitacion = (TiposHabitacion) comboBoxTipoHabitacion.getSelectedItem();
                int numPersonas = 0;
                if(comboBoxTipoHabitacion.getSelectedItem().equals("HABITACION_INDIVIDUAL")) {
                    numPersonas = 1;
                }
                
                else if(comboBoxTipoHabitacion.getSelectedItem().equals("HABITACION_DOBLE")){
                    numPersonas = 2;
                }
                
                else if(comboBoxTipoHabitacion.getSelectedItem().equals("HABITACION_TWIN")) {
                    numPersonas = 4;
                }
                
                else if(comboBoxTipoHabitacion.getSelectedItem().equals("SICO")) {
                    numPersonas = 5;
                }
                
                else {
                    numPersonas = 7;
                }
                
                boolean disponible = true;
                
                if (nombre.isEmpty() || cod.isEmpty() || textFieldPrecio.equals("")){
                    JOptionPane.showMessageDialog(null, "Rellene los campos");
                }
                else {
                    Map<String, Habitacion> habitaciones = new HashMap<>();
                    habitaciones = GestorBD.obtenerHabitacion();
                    if (habitaciones.containsKey(textFieldCodigo.getText())) {
                        JOptionPane.showMessageDialog(null, "Habitación ya registrada");
                    } else {
                        Habitacion habitacion = new Habitacion(nombre, cod, precio, numPersonas, tipoHabitacion, disponible);
                        GestorBD.insertarHabitacion(habitacion);
                        dispose();
                        Main m = new Main(null);
                        m.setVisible(true);
                    }
                }
            }
        });
    }
}
