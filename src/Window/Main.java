package Window;

import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnInicioSesion = new JButton("Iniciar Sesión");
		
		JButton btnRegistrarse = new JButton("Registrarse");
		
		JButton btnReserva = new JButton("Reservar");
		
		JButton btnCheck_in = new JButton("Check-in");
		
		JButton btnCheck_out = new JButton("Check-out");
		
		JButton btnGestion = new JButton("Gestión");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/Images/Logo.png")));
		
		JLabel lblTitulo1 = new JLabel("KAHALA");
		lblTitulo1.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		JLabel lblTitulo2 = new JLabel("HOTEL");
		lblTitulo2.setFont(new Font("MV Boli", Font.BOLD, 25));
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(188)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addComponent(btnGestion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
		                .addComponent(btnCheck_out, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
		                .addComponent(btnCheck_in, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
		                .addComponent(btnReserva, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
		                .addComponent(btnInicioSesion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
		                .addComponent(btnRegistrarse, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
		            .addGap(193))
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(51)
		            .addComponent(lblTitulo1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		            .addGap(32)
		            .addComponent(lblTitulo2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
		            .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(38)
		            .addComponent(lblTitulo2)
		            .addContainerGap(224, Short.MAX_VALUE))
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(39)
		            .addComponent(lblTitulo1)
		            .addContainerGap(223, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
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
	

