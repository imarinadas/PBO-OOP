/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class PetunjukAdmin extends JFrame {
    JLabel lgaji = new JLabel(" - klik tombol TAMBAH untuk menambah data pegawai ");
    JLabel ldata = new JLabel(" - klik tombol DATA untuk melihat data sudah masuk atau belum ");
    JButton btnhome = new JButton(" Home ");
    
    public PetunjukAdmin(){
        setTitle(" Petunjuk Pegawai ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);
        
        btnhome.addActionListener((ActionEvent e)->{
            HomeAdmin ha = new HomeAdmin();
            dispose();
        });
        
        setLayout(null);
        add(lgaji);
        add(ldata);
        add(btnhome);       

        lgaji.setBounds(50,30,600,30);
	ldata.setBounds(50,75,600,30);
        btnhome.setBounds(50,120,100,50);
        
        setVisible(true);
    }
}