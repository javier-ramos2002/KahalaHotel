package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Check_in extends JFrame {

	private JPanel contentPane;
	private JButton checkInButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_in frame = new Check_in();
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
	public Check_in() {
	    setTitle("Ventana con botón y JList");

	    // Establece el tamaño de la ventana
	    setSize(500, 500);

	   
	    checkInButton = new JButton("Check In");
	   

	    // Crea una JList utilizando el modelo de lista creado anteriormente
	  

	    // Agrega el botón y la lista a la ventana
	    add(checkInButton, BorderLayout.NORTH);
	   
	  }
	

}
