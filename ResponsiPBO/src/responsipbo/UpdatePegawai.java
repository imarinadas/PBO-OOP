/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UpdatePegawai extends JFrame {
    JLabel lid = new JLabel("id ");
    JTextField tfid = new JTextField();
    JLabel lnama = new JLabel("nama ");
    JTextField tfnama = new JTextField();
    JLabel lalamat = new JLabel("alamat ");
    JTextField tfalamat = new JTextField();
    JLabel lhp = new JLabel("hp ");
    JTextField tfhp = new JTextField();
    JLabel lposisi = new JLabel("posisi ");
    String[] nposisi =
            {"","Direktur","Manager","Programmer","Marketing","Surveyor"};
    JComboBox cmbposisi = new JComboBox(nposisi);
    JLabel lgaji = new JLabel("gaji ");
    JTextField tfgaji = new JTextField();
    JTextField tflembur = new JTextField();
    JTextField tftunjangan = new JTextField();
    JTextField tfpajak = new JTextField();
    JTextField tftotal = new JTextField();
    
    JButton btnKaryawan = new JButton(" Karyawan ");
    JButton btnHome = new JButton(" Home ");
    JButton btnTambah = new JButton(" Tambah ");
    JButton btnData = new JButton(" Data ");
    JButton btnPetunjuk = new JButton(" Petunjuk ");
   
    JButton btnUbah = new JButton("Ubah");
    
    public UpdatePegawai(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(300,20);
        
        add(lid);
        add(tfid);
        add(lnama);
        add(tfnama);
        add(lposisi);
        add(cmbposisi);
        add(lalamat);
        add(tfalamat);
        add(lhp);
        add(tfhp);
        add(lgaji);
        add(tfgaji);
        add(tflembur);
        add(tftunjangan);
        add(tfpajak);
        add(tftotal);
        
        lid.setBounds(200, 120, 100, 20);
        tfid.setBounds(320, 120, 200, 20);
        lnama.setBounds(200, 150, 100, 20);
        tfnama.setBounds(320, 150, 200, 20);
        lalamat.setBounds(200, 180, 100, 20);
        tfalamat.setBounds(320, 180, 200, 20);
        lhp.setBounds(200, 210, 100, 20);
        tfhp.setBounds(320, 210, 200, 20);
        lposisi.setBounds(200, 240, 100, 20);
        cmbposisi.setBounds(320, 240, 200, 20);
        lgaji.setBounds(200, 270, 100, 20);
        tfgaji.setBounds(320, 270, 200, 20);

        add(btnKaryawan);
        add(btnHome);
        add(btnTambah);
        add(btnData);
        add(btnPetunjuk);
        add(btnUbah);
        
        btnKaryawan.setBounds(750,50,100,50);
        btnHome.setBounds(50,120,100,50);
        btnTambah.setBounds(50,190,100,50);
        btnData.setBounds(50,260,100,50);
        btnPetunjuk.setBounds(50,330,100,50);
        btnUbah.setBounds(750,400,100,50); 
    }
    
    public String getid(){
        return tfid.getText();
    }
    public String getnama(){
        return tfnama.getText();
    }
    public String getposisi(){
        return (String) cmbposisi.getSelectedItem();
    }
    public String getalamat(){
        return tfalamat.getText();
    }
    public String gethp(){
        return tfhp.getText();
    }
    public String getgaji(){
        return tfgaji.getText();
    }
    public String getlembur(){
        return tflembur.getText();
    }
    public String gettunjangan(){
        return tftunjangan.getText();
    }
    public String getpajak(){
        return tfpajak.getText();
    }
    public String gettotal(){
        return tftotal.getText();
    }
}