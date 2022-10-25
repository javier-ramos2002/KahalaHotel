package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import Window.Main;
import java.awt.Color;
public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnVolver = new JButton("Volver");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap(355, Short.MAX_VALUE)
		            .addComponent(btnVolver)
		            .addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.TRAILING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addContainerGap(232, Short.MAX_VALUE)
		            .addComponent(btnVolver))
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
	}

}
