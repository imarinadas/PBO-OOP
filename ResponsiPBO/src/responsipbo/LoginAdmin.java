/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class LoginAdmin extends JFrame {
    final JTextField fusername = new JTextField(10);
    final JTextField fpassword = new JPasswordField(10);
    JLabel lusername = new JLabel(" Username ");
    JLabel lpassword = new JLabel(" Password ");
     //JCheckBox showPassword = new JCheckBox(" Show Password ");
    JButton btnlogin = new JButton(" Login ");
    JButton btnback = new JButton(" Back ");
    
    ModelResponsi modelresponsi;
    public LoginAdmin(ModelResponsi modelresponsi){
        this.modelresponsi = modelresponsi;
        
        setTitle(" Login Admin ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);

        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String username = fusername.getText();
                String dataAdmin[][] = modelresponsi.bacaloginAdmin(username);
                HomeAdmin ha = new HomeAdmin();
                dispose();
            }
        });
        
        btnback.addActionListener(((e)->{
            GUI gui = new GUI();
            dispose();
        })); 
        
        /*showPassword.addActionListener(((e)->{
           if (showPassword.isSelected()) {
                fpassword.setEchoChar((char)0);
            } else {
                fpassword.setEchoChar('*');
            }
        }));*/
        
	setLayout(null);
	add(lusername);
	add(fusername);
        add(lpassword);
	add(fpassword);
        //add(showPassword);
        add(btnlogin);
        add(btnback);
        
	lusername.setBounds(10,30,120,30);
	fusername.setBounds(130,30,150,30);
        lpassword.setBounds(10,75,120,30);
	fpassword.setBounds(130,75,150,30);
        //showPassword.setBounds(130,120,150,30);
        btnlogin.setBounds(50,165,100,30);
        btnback.setBounds(200,165,100,30);
	setVisible(true);
    }
}
