package Window;

import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class MiniBar extends JFrame {

	private JToggleButton tglbtnAgua;
	private JToggleButton tglbtnCerveza;
	private JToggleButton tglbtnChocolate;
	private JToggleButton tglbtnGominolas;
	private JToggleButton tglbtnPatatasFritas;
	private JToggleButton tglbtnRon;
	private ImageIcon ImgGominolas;
	private ImageIcon ImgPatatas;
	private ImageIcon ImgChocolate;
	private ImageIcon ImgCerveza;
	private ImageIcon ImgAgua;
	private ImageIcon ImgRon;
	private JLabel lblAgua;
	private JLabel lblCerveza;
	private JLabel lblChocolate;
	private JLabel lblGominolas;
	private JLabel lblPatatas;
	private JLabel lblRon;
	private JButton btnAnyadir;
	private JButton btnVolver;
	private JLabel lblExplicacion;
	
	private JFrame vactual;
	
	private HashMap<JToggleButton, Double> mapaPrecios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniBar frame = new MiniBar();
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
	public MiniBar() {
	    setMinimumSize(getMinimumSize());
	    setSize(600,  500);
	    vactual = this;
	    mapaPrecios = new HashMap<>();
	    /* Agua */
	    tglbtnAgua = new JToggleButton();
        ImgAgua= new ImageIcon(MiniBar.class.getResource("/Images/Agua.png"));
        Image dabAgua = ImgAgua.getImage();
        Image modAgua = dabAgua.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImgAgua = new ImageIcon(modAgua);
        tglbtnAgua.setIcon(ImgAgua);
        mapaPrecios.put(tglbtnAgua, 2.8);
	    /* Cerveza */
	    tglbtnCerveza = new JToggleButton();
        ImgCerveza = new ImageIcon(MiniBar.class.getResource("/Images/Cerveza.png"));
        Image dabCerveza = ImgCerveza.getImage();
        Image modCerveza = dabCerveza.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImgCerveza = new ImageIcon(modCerveza);
        tglbtnCerveza.setIcon(ImgCerveza);
        mapaPrecios.put(tglbtnCerveza, 6.8);
        
        
	    /* Chocolate */
	    tglbtnChocolate = new JToggleButton();
        ImgChocolate = new ImageIcon(MiniBar.class.getResource("/Images/Chocolate.png"));
        Image dabChocolate = ImgChocolate.getImage();
        Image modChocolate = dabChocolate.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImgChocolate = new ImageIcon(modChocolate);
        tglbtnChocolate.setIcon(ImgChocolate);
        mapaPrecios.put(tglbtnChocolate,4.0);
	    /* patatas */
	    tglbtnGominolas = new JToggleButton();
	    ImgGominolas = new ImageIcon(MiniBar.class.getResource("/Images/Gominolas.png"));
	    Image dabImage = ImgGominolas.getImage();
	    Image modifiedImage = dabImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	    ImgGominolas = new ImageIcon(modifiedImage);
	    tglbtnGominolas.setIcon(ImgGominolas);
	    mapaPrecios.put(tglbtnGominolas,3.0);
	    /* patatas */
	    tglbtnPatatasFritas = new JToggleButton();
	    ImgPatatas = new ImageIcon(MiniBar.class.getResource("/Images/PatatasFritas.png"));
        Image dabPatatas = ImgPatatas.getImage();
        Image modPatatas = dabPatatas.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImgPatatas = new ImageIcon(modPatatas);
        tglbtnPatatasFritas.setIcon(ImgPatatas);
        mapaPrecios.put(tglbtnPatatasFritas,10.0);
        /* Ron */
	    tglbtnRon = new JToggleButton();
	    ImgRon = new ImageIcon(MiniBar.class.getResource("/Images/Ron.png"));
        Image dabRon = ImgRon.getImage();
        Image modRon = dabRon.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImgRon = new ImageIcon(modRon);
        tglbtnRon.setIcon(ImgRon);
        mapaPrecios.put(tglbtnRon,12.4);
	    
	    lblAgua = new JLabel("Agua");
	    
	    lblCerveza = new JLabel("Cerveza");
	    
	    lblChocolate = new JLabel("Chocolate");
	    
	    lblGominolas = new JLabel("Gominolas");
	    
	    lblPatatas = new JLabel("Patatas");
	    
	    lblRon = new JLabel("Ron");
	    
	    btnAnyadir = new JButton("Añadir");
	    btnAnyadir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if(tglbtnAgua.isSelected()) {
	                CheckOut.precioTotal += mapaPrecios.get(tglbtnAgua);
	            }
	            if(tglbtnCerveza.isSelected()) {
                    CheckOut.precioTotal += mapaPrecios.get(tglbtnCerveza);
                }
	            if(tglbtnChocolate.isSelected()) {
                    CheckOut.precioTotal += mapaPrecios.get(tglbtnChocolate);
                }
	            if(tglbtnGominolas.isSelected()) {
                    CheckOut.precioTotal += mapaPrecios.get(tglbtnGominolas);
                }
	            if(tglbtnPatatasFritas.isSelected()) {
                    CheckOut.precioTotal += mapaPrecios.get(tglbtnPatatasFritas);
                }
	            if(tglbtnRon.isSelected()) {
                    CheckOut.precioTotal += mapaPrecios.get(tglbtnRon);
                }
	            dispose();
	            
	        }
	    });
	    
	    btnVolver = new JButton("Volver");
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        
	    
                dispose();
                CheckOut o = new CheckOut(vactual);
                o.setVisible(true);
                
            }
	    });
	    
	    lblExplicacion = new JLabel("Seleccione los productos del minibar que hayan sido consumidos en su estancia.");
        
        
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGap(73)
	                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                            .addComponent(tglbtnAgua)
	                            .addComponent(tglbtnGominolas))
	                        .addGap(47)
	                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	                            .addGroup(groupLayout.createSequentialGroup()
	                                .addComponent(tglbtnPatatasFritas)
	                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(tglbtnRon))
	                            .addGroup(groupLayout.createSequentialGroup()
	                                .addComponent(tglbtnCerveza)
	                                .addGap(43)
	                                .addComponent(tglbtnChocolate))))
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGap(118)
	                        .addComponent(lblAgua)
	                        .addGap(112)
	                        .addComponent(lblCerveza)
	                        .addGap(110)
	                        .addComponent(lblChocolate))
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGap(101)
	                        .addComponent(lblGominolas)
	                        .addGap(93)
	                        .addComponent(lblPatatas)
	                        .addGap(116)
	                        .addComponent(lblRon))
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGap(39)
	                        .addComponent(lblExplicacion))
	                    .addGroup(groupLayout.createSequentialGroup()
	                        .addGap(184)
	                        .addComponent(btnAnyadir)
	                        .addGap(77)
	                        .addComponent(btnVolver)))
	                .addContainerGap(51, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	        groupLayout.createParallelGroup(Alignment.LEADING)
	            .addGroup(groupLayout.createSequentialGroup()
	                .addGap(10)
	                .addComponent(lblExplicacion)
	                .addGap(18)
	                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                    .addComponent(tglbtnAgua)
	                    .addComponent(tglbtnChocolate)
	                    .addComponent(tglbtnCerveza))
	                .addPreferredGap(ComponentPlacement.RELATED)
	                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	                    .addComponent(lblAgua)
	                    .addComponent(lblCerveza)
	                    .addComponent(lblChocolate))
	                .addGap(25)
	                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	                    .addComponent(tglbtnGominolas)
	                    .addComponent(tglbtnPatatasFritas)
	                    .addComponent(tglbtnRon))
	                .addPreferredGap(ComponentPlacement.RELATED)
	                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	                    .addComponent(lblGominolas)
	                    .addComponent(lblPatatas)
	                    .addComponent(lblRon))
	                .addGap(51)
	                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	                    .addComponent(btnAnyadir)
	                    .addComponent(btnVolver))
	                .addContainerGap(197, Short.MAX_VALUE))
	    );
	    getContentPane().setLayout(groupLayout);

	}
}
