package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;

public class Check_in extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCheckIn;
	private JList list;
	
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

	    // Establece el tamaño de la ventana
	    setSize(500, 500);
	    
	    table = new JTable();
	    
	    btnCheckIn = new JButton("Check In");
	    btnCheckIn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            
	            
	        }
	    });
	    
	    JButton btnVolver = new JButton("Volver");
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
                Main m = new Main(null);
                m.setVisible(true);
                
	            
	        }
	    });
	    
	    list = new JList();
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGap(128)
	                .addComponent(btnCheckIn)
	                .addGap(53)
	                .addComponent(btnVolver)
	                .addContainerGap(137, Short.MAX_VALUE))
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGap(222)
	                .addComponent(table, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
	                .addGap(37))
	            .addGroup(groupLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(list, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
	                .addContainerGap())
	    );
	    groupLayout.setVerticalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGap(37)
	                .addComponent(list, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
	                .addGap(18)
	                .addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
	                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	                    .addComponent(btnCheckIn)
	                    .addComponent(btnVolver))
	                .addGap(75))
	    );
	    getContentPane().setLayout(groupLayout);
	   
	  }
}
