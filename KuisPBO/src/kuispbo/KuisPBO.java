/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.event.*;
import javax.swing.*;

public class KuisPBO {
    public static void main(String[] args) {
        GUI g = new GUI();
    } 
}

class GUI extends JFrame {
   JButton btnAnggota = new JButton(" Input Anggota ");
   JButton btnBuku = new JButton(" Input Data Buku ");
   JButton btnKaryawan = new JButton(" Input Karyawan ");
   JButton btnPeminjaman = new JButton(" Peminjaman ");
   

   public GUI() {
	setTitle(" BERANDA KUIS PBO ");
	setDefaultCloseOperation(3);
	setSize(550,300);
        setLocation(500, 50);
        
        btnAnggota.addActionListener((ActionEvent e)->{
            MVC_Anggota mvca = new MVC_Anggota();    
            dispose();
        });
        
        btnBuku.addActionListener(((e)->{
             MVC_Buku mvcb = new MVC_Buku();    
             dispose();
        })); 
        
        btnKaryawan.addActionListener(((e)->{
            MVC_Karyawan mvck = new MVC_Karyawan();    
             dispose();
        })); 
                
        btnPeminjaman.addActionListener(((e)->{
            MVC_Peminjaman mvcp = new MVC_Peminjaman();    
             dispose();
        })); 
        
	setLayout(null);
        add(btnAnggota);
        add(btnBuku);
        add(btnKaryawan);
        add(btnPeminjaman);
        
        btnAnggota.setBounds(50,50,200,50);
        btnBuku.setBounds(280,50,200,50);
        btnKaryawan.setBounds(50,165,200,50);
        btnPeminjaman.setBounds(280,165,200,50);
	setVisible(true);
   }
}