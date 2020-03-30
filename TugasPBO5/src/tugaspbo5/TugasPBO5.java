/*
 * Tugas PBO 5 - Plug B
 * Nada Salsabila Imari
 * 123180126
 */

//HALAMAN PERTAMA

package tugaspbo5;

import java.awt.event.*;
import javax.swing.*;

public class TugasPBO5 {
    public static void main(String[] args) {
        GUI g = new GUI();
    }
}

class GUI extends JFrame {
   final JTextField fusername = new JTextField(10);
   final JTextField fpassword = new JPasswordField(10);

   JLabel lusername = new JLabel(" Username ");
   JLabel lpassword = new JLabel(" Password ");
   //JCheckBox showPassword = new JCheckBox(" Show Password ");

   JButton btnLogin = new JButton(" Login ");
   JButton btnCancel = new JButton(" Cancel ");

   public GUI() {
	setTitle(" Login TugasPBO5 ");
	setDefaultCloseOperation(3);
	setSize(350,600);
        setLocation(500, 50);
        
        btnLogin.addActionListener((ActionEvent e)->{
            String usernametxt;
            String passwordtxt;
            usernametxt = fusername.getText();
            passwordtxt = fpassword.getText();
            if(usernametxt.length() == 0 || passwordtxt.length() == 0){
                JOptionPane.showMessageDialog(null, "Username dan/atau Password tidak boleh kosong");
            }else if(usernametxt.equalsIgnoreCase("admin") && passwordtxt.equalsIgnoreCase("123")){ 
                Input in = new Input();
                in.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Login Gagal! Username dan/atau Password salah");
            }
        });
        
        btnCancel.addActionListener(((e)->{
            fusername.setText("");
            fpassword.setText("");
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
        add(btnCancel);
        add(btnLogin);
        
	lusername.setBounds(10,30,120,30);
	fusername.setBounds(130,30,150,30);
        lpassword.setBounds(10,75,120,30);
	fpassword.setBounds(130,75,150,30);
        //showPassword.setBounds(130,120,150,30);
        btnCancel.setBounds(50,165,100,30);
        btnLogin.setBounds(200,165,100,30);
	setVisible(true);
   }
}
