package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Database.DB;

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
	private JButton btnVolver;
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
	private JProgressBar progressBar;
	

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
	    setIconImage(Toolkit.getDefaultToolkit().getImage(Registrarse.class.getResource("/Images/RegistrarseIcon.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnVolver = new JButton("Volver");
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
		            .addGap(180)
		            .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(186, Short.MAX_VALUE))
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(111)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblContrasenya, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblFechaNacimineto)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldFechaNacimineto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.UNRELATED)
		                    .addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		            .addGap(167))
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap(182, Short.MAX_VALUE)
		            .addComponent(btnEnviar)
		            .addGap(125)
		            .addComponent(btnVolver)
		            .addGap(47))
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap()
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblRegistrarse)
		                    .addGap(30)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                        .addComponent(lblDni)
		                        .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                    .addGap(18)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                        .addComponent(lblNombre)
		                        .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                    .addGap(27)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                        .addComponent(lblApellido)
		                        .addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                    .addGap(18)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                        .addComponent(lblFechaNacimineto)
		                        .addComponent(textFieldFechaNacimineto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                    .addGap(18)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                        .addComponent(lblContrasenya)
		                        .addComponent(textFieldContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                    .addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
		                    .addComponent(btnEnviar)
		                    .addContainerGap())
		                .addComponent(btnVolver, Alignment.TRAILING)))
		);
		contentPane.setLayout(gl_contentPane);
		btnEnviar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = textFieldDni.getText();
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String contrasenia = textFieldContrasenya.getText();
                String fechaNacimiento = textFieldFechaNacimineto.getText();
                Cliente c = new Cliente(dni, nombre, apellido, contrasenia, fechaNacimiento);
                try {
                    DB.initDB("KahalaHotel.db", false);
                    DB.anadirCliente(c);
                    Thread hilo = new Thread() {
                        @Override
                        public void run() {
                            for (int i=1;i<100;i++) {
                                progressBar.setValue(i);
                                try {Thread.sleep( 50 ); } catch (Exception e) {}
                            }

                            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente", "Registro finalizado.",JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            DB.closeDB();
                            Main m = new Main();
                            m.setVisible(true);
                        }
                    };
                    hilo.start();
              } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
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
                while(true)
                {
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


