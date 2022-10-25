package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Window.Main;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
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
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblDni = new JLabel("Dni:");
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		JLabel lblFechaNacimineto = new JLabel("Fecha de nacimiento:");
		
		JLabel lblContrasenya = new JLabel("Contraseña:");
		
		JButton btnEnviar = new JButton("Enviar");
		
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
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap(206, Short.MAX_VALUE)
		            .addComponent(btnEnviar)
		            .addGap(138)
		            .addComponent(btnVolver)
		            .addContainerGap())
		        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
		            .addGap(180)
		            .addComponent(lblRegistrarse, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(186, Short.MAX_VALUE))
		        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
		            .addGap(111)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblContrasenya, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldContrasenya, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblFechaNacimineto)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldFechaNacimineto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap(167, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap()
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
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		                .addComponent(btnVolver)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(btnEnviar)
		                    .addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
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


