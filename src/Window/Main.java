package Window;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Cliente;
import Database.GestorBD;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;


public class Main extends JFrame {

	private JPanel contentPane;
	private static JButton btnRegistrarse;
	private static JButton btnInicioSesion;
	private static JButton btnReserva;
	private static JButton btnCheck_in;
	private static JButton btnCheck_out;
	private static JButton btnGestion;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main(null);
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
	public Main(Cliente c) {
	    GestorBD.crearBD();
	    setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Images/MainIcon.png")));
	    setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnInicioSesion = new JButton("Iniciar Sesión");
		btnRegistrarse = new JButton("Registrarse");
		btnReserva = new JButton("Reservar");
		btnCheck_in = new JButton("Check-in");
		btnCheck_out = new JButton("Check-out");
		btnGestion = new JButton("Gestión");
		btnSalir = new JButton("Salir");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/Images/Logo.png")));
		
		JLabel lblTitulo1 = new JLabel("KAHALA");
		lblTitulo1.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		JLabel lblTitulo2 = new JLabel("HOTEL");
		lblTitulo2.setFont(new Font("MV Boli", Font.BOLD, 25));
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(51)
		                    .addComponent(lblTitulo1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
		                    .addGap(18)
		                    .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		                    .addGap(32)
		                    .addComponent(lblTitulo2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(176)
		                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		                        .addComponent(btnCheck_out, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
		                        .addComponent(btnCheck_in, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
		                        .addComponent(btnReserva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
		                        .addComponent(btnInicioSesion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
		                        .addComponent(btnRegistrarse, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
		                        .addComponent(btnGestion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
		                    .addGap(74)
		                    .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(39)
		                    .addComponent(lblTitulo1))
		                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(38)
		                    .addComponent(lblTitulo2)))
		            .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addComponent(btnRegistrarse)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnInicioSesion)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnReserva)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnCheck_in)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnCheck_out)
		                    .addPreferredGap(ComponentPlacement.RELATED)
		                    .addComponent(btnGestion)
		                    .addGap(4))
		                .addComponent(btnSalir)))
		);
		contentPane.setLayout(gl_contentPane);
		
		desactivarBotonesCliente();   
		desactivarBotonAdministrador();
		
		btnSalir.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            System.exit(0);
	        }
	    });
		
		btnRegistrarse.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrarse r = new Registrarse();
                dispose();
                r.setVisible(true);                
            }
        });
		    
		btnInicioSesion.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioSesion is = new InicioSesion();
                dispose();
                is.setVisible(true);                
            }
        });
		
		btnReserva.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                VReserva r = new VReserva(c);
                dispose();
                r.setVisible(true);                
            }
        });
        
        btnCheck_in.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Check_in ci = new Check_in();
                dispose();
                ci.setVisible(true);                
            }
        });
        
        btnCheck_out.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Check_out co = new Check_out();
                dispose();
                co.setVisible(true);                
            }
        });
        
        btnGestion.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opciones = {"Añadir habitación", "Visualizar"};
               
                int opc = JOptionPane.showOptionDialog(null, "Elige una opción",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                if(opc == 0) {
                    System.out.println("AÑADIR HABITACIÓN");
                }
                else {
                    Gestion g = new Gestion();
                    dispose();
                    g.setVisible(true);   
                }
                             
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
		

        if(c != null) {
            activarBotonesCliente();
        }
		}
	
	
	public static void desactivarBotonesCliente() {
	    btnReserva.setEnabled(false);
	    btnCheck_in.setEnabled(false);
	    btnCheck_out.setEnabled(false);
	}
	
	public static void activarBotonesCliente() {
        btnReserva.setEnabled(true);
        btnCheck_in.setEnabled(true);
        btnCheck_out.setEnabled(true);
    }
	
	public static void desactivarBotonAdministrador() {
        btnGestion.setEnabled(false);
    }
	public static void activarBotonAdministrador() {
        btnGestion.setEnabled(true);
    }
}
	

