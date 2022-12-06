package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Database.GestorBD;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import Window.Main;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldDni;
    private JPasswordField passwordFieldContrasenia;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InicioSesion frame = new InicioSesion();
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
    public InicioSesion() {
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/Images/InicioSesionIcon.png")));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblInicioSesion = new JLabel("Inicio Sesión");
        lblInicioSesion.setFont(new Font("MV Boli", Font.BOLD, 20));

        JLabel lblDni = new JLabel("Dni:");

        JLabel lblContrasenia = new JLabel("Contrasenia:");

        textFieldDni = new JTextField();
        textFieldDni.setColumns(10);

        JButton btnEntrar = new JButton("Entrar");
        
        passwordFieldContrasenia = new JPasswordField();
        
        JButton btnVolver = new JButton("Volver");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(127)
                            .addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblInicioSesion, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(127)
                            .addComponent(lblContrasenia)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(passwordFieldContrasenia, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(206)
                            .addComponent(btnEntrar)))
                    .addGap(61)
                    .addComponent(btnVolver)
                    .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(33)
                    .addComponent(lblInicioSesion)
                    .addGap(57)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblDni)
                        .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(43)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblContrasenia)
                        .addComponent(passwordFieldContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                    .addComponent(btnEntrar)
                    .addGap(29))
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(272, Short.MAX_VALUE)
                    .addComponent(btnVolver)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = textFieldDni.getText();
                String contrasenia = passwordFieldContrasenia.getText();
                String admin = "admin";
                if(dni.equals(admin) && contrasenia.equals(admin)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido administrador");
                    dispose();
                    Main m = new Main();
                    m.setVisible(true);
                    Main.activarBotonAdministrador();
                }
                
                else if(dni.isEmpty() || contrasenia.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellene los campos");
                }
                
                else {
                    GestorBD.crearBD();
                    Map<String, Cliente> clientes = new HashMap<>();
                    clientes = GestorBD.obtenerDatos();
                    if(clientes.containsKey(dni)) {
                        Cliente c = new Cliente();
                        c = clientes.get(dni);
                        String con = c.getContrasenia();
                        if(contrasenia.equals(con)) {
                            JOptionPane.showMessageDialog(null, "Bienvenido usuario: " + dni);
                            dispose();
                            Main m = new Main();
                            m.setVisible(true);
                            Main.activarBotonesCliente();;
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Datos incorrectos");
                           
                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe"); 
                    }
                
                }
            }
        });
        
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main m = new Main();
                m.setVisible(true);
                
            }
            
        });
        Thread reloj = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String timeLabel = new String(LocalTime.now().format(dtf));

                    setTitle(timeLabel);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        reloj.start();

    }
}
