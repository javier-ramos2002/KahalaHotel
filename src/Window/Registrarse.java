package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.sqlite.core.DB;

import java.sql.Connection;
import Class.Cliente;
import Database.GestorBD;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class Registrarse extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldDni;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldFechaNacimineto;
    private JTextField textFieldContrasenya;
    private JLabel lblDni;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblFechaNacimineto;
    private JLabel lblContrasenya;
    private JButton btnEnviar;
    private JButton btnVolver;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registrarse frame = new Registrarse();
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
    public Registrarse() {
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(Registrarse.class.getResource("/Images/RegistrarseIcon.png")));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblRegistrarse = new JLabel("Regístrate");
        lblRegistrarse.setFont(new Font("MV Boli", Font.BOLD, 20));

        lblNombre = new JLabel("Nombre:");

        lblDni = new JLabel("Dni:");

        lblApellido = new JLabel("Apellido:");

        lblFechaNacimineto = new JLabel("Fecha de nacimiento:");

        lblContrasenya = new JLabel("Contraseña:");

        btnEnviar = new JButton("Enviar");

        textFieldDni = new JTextField();
        textFieldDni.setColumns(10);

        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);

        textFieldApellido = new JTextField();
        textFieldApellido.setColumns(10);

        textFieldFechaNacimineto = new JTextField();
        textFieldFechaNacimineto.setColumns(10);

        textFieldContrasenya = new JTextField();
        textFieldContrasenya.setColumns(10);

        btnVolver = new JButton("Volver");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(109)
                    .addComponent(lblFechaNacimineto)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnEnviar)
                            .addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                            .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(27))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(textFieldFechaNacimineto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(163, Short.MAX_VALUE))))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(180)
                            .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(111)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(lblContrasenya, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(textFieldContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(186, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblRegistrarse)
                            .addGap(67))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblDni)
                                .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblNombre)
                                .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(4)))
                    .addGap(22)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblApellido)
                        .addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblContrasenya)
                        .addComponent(textFieldContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(textFieldFechaNacimineto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaNacimineto))
                    .addGap(32)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnEnviar)
                        .addComponent(btnVolver))
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);

        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String dni = textFieldDni.getText();
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String contrasenia = textFieldContrasenya.getText();
                String fechaNacimiento = textFieldFechaNacimineto.getText();
                if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || contrasenia.isEmpty()
                        || fechaNacimiento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellene los campos");
                } else {
                    GestorBD.crearBD();
                    Map<String, Cliente> clientes = new HashMap<>();
                    clientes = GestorBD.obtenerDatos();
                    if (clientes.containsKey(textFieldDni.getText())) {
                        JOptionPane.showMessageDialog(null, "Cliente ya registrado");
                    } else {
                        Cliente c = new Cliente(dni, nombre, apellido, contrasenia, fechaNacimiento);
                        GestorBD.insertarCliente(c);
                        dispose();
                        Main m = new Main();
                        m.setVisible(true);

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
