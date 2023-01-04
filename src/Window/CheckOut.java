package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CheckOut extends JFrame  {
    private JButton btnCheckOut;
    private static JButton btnMiniBar;
    private static JButton btnRecivo;
    
    
   
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public CheckOut() {
        
        
        
        setSize(600,  500);
        
        btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        btnMiniBar = new JButton("Mini Bar");
        btnMiniBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                MiniBar b = new MiniBar();
                b.setVisible(true);
                
            }
        });
        
        btnRecivo = new JButton("Recivo");
        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main m = new Main(null);
                m.setVisible(true);
            }
            
        });
        
        JList list = new JList();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(84)
                            .addComponent(btnCheckOut)
                            .addGap(46)
                            .addComponent(btnMiniBar)
                            .addGap(48)
                            .addComponent(btnRecivo))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(list, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(45)
                    .addComponent(list, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnRecivo)
                        .addComponent(btnCheckOut)
                        .addComponent(btnMiniBar))
                    .addGap(37)
                    .addComponent(btnNewButton)
                    .addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
        
        
        desactivarBotonMiniBar();
        desactivarBotonRecivo();
    }
    
    
    
    public static void desactivarBotonMiniBar() {
        btnMiniBar.setEnabled(false);
 
    }
    public static void desactivarBotonRecivo() {
        btnRecivo.setEnabled(false);
    }
}
