/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import java.awt.event.*;
import javax.swing.*;

public class ResponsiPBO {
    public static void main(String[] args) {
        GUI g = new GUI();
    } 
}

class GUI extends JFrame {
   JLabel lsatu = new JLabel(" Selamat datang.");
   JLabel ldua = new JLabel("Silakan masuk ke menu gaji untuk hitung gaji.");
   JLabel ltiga = new JLabel("Jika mengalami kesulitan klik menu petunjuk ");
   
   JButton btnAdmin = new JButton(" Admin ");
   JButton btnHome = new JButton(" Home ");
   JButton btnGaji = new JButton(" Gaji ");
   JButton btnData = new JButton(" Data ");
   JButton btnPetunjuk = new JButton(" Petunjuk ");
   

   public GUI() {
	setTitle(" BERANDA RESPONSI PBO ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);
        ModelResponsi modelresponsi = new ModelResponsi();
        
        btnAdmin.addActionListener((ActionEvent e)->{
            LoginAdmin la = new LoginAdmin(modelresponsi);    
            dispose();
        });
        
        btnHome.addActionListener(((e)->{
             GUI gui = new GUI();
             dispose();
        })); 
        
        btnGaji.addActionListener(((e)->{
            MVC_Pegawai mvcc = new MVC_Pegawai();    
             dispose();
        })); 
                
        btnData.addActionListener(((e)->{
            ViewUmum vu = new ViewUmum();    
             dispose();
        })); 
        
        btnPetunjuk.addActionListener(((e)->{
            PetunjukPegawai mvce = new PetunjukPegawai();    
             dispose();
        })); 
        
	setLayout(null);
        add(lsatu);
        add(ldua);
        add(ltiga);
        add(btnAdmin);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnPetunjuk);
        
        lsatu.setBounds(300,120,285,50);
        ldua.setBounds(300,170,285,50);
        ltiga.setBounds(300,220,285,50);
        btnAdmin.setBounds(750,50,100,50);
        btnHome.setBounds(50,120,100,50);
        btnGaji.setBounds(50,190,100,50);
        btnData.setBounds(50,260,100,50);
        btnPetunjuk.setBounds(50,330,100,50);
	setVisible(true);
   }
}