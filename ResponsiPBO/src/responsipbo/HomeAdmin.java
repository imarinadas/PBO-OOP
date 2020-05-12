/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeAdmin extends JFrame{
   JLabel lsatu = new JLabel(" Selamat datang ADMIN.");
   JLabel ldua = new JLabel("Silakan masuk ke menu tambah untuk tambah data.");
   JLabel ltiga = new JLabel("Jika mengalami kesulitan klik menu petunjuk ");
   
   JButton btnKaryawan = new JButton(" Karyawan ");
   JButton btnHome = new JButton(" Home ");
   JButton btnTambah = new JButton(" Tambah ");
   JButton btnData = new JButton(" Data ");
   JButton btnPetunjuk = new JButton(" Petunjuk ");
   

   public HomeAdmin() {
	setTitle(" BERANDA ADMIN RESPONSI PBO ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);
        
        btnKaryawan.addActionListener((ActionEvent e)->{
            GUI gui = new GUI();    
            dispose();
        });
        
        btnHome.addActionListener(((e)->{
             HomeAdmin ha = new HomeAdmin();
             dispose();
        })); 
        
        btnTambah.addActionListener(((e)->{
            MVC_Admin mvcc = new MVC_Admin();    
             dispose();
        })); 
                
        btnData.addActionListener(((e)->{
            ViewUmumAdmin vua = new ViewUmumAdmin();    
             dispose();
        })); 
        
        btnPetunjuk.addActionListener(((e)->{
            PetunjukAdmin mvce = new PetunjukAdmin();    
             dispose();
        })); 
        
	setLayout(null);
        add(lsatu);
        add(ldua);
        add(ltiga);
        add(btnKaryawan);
        add(btnHome);
        add(btnTambah);
        add(btnData);
        add(btnPetunjuk);
        
        lsatu.setBounds(300,120,285,50);
        ldua.setBounds(300,170,285,50);
        ltiga.setBounds(300,220,285,50);
        btnKaryawan.setBounds(750,50,100,50);
        btnHome.setBounds(50,120,100,50);
        btnTambah.setBounds(50,190,100,50);
        btnData.setBounds(50,260,100,50);
        btnPetunjuk.setBounds(50,330,100,50);
	setVisible(true);
   }
}