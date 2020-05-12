/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */
package responsipbo;

import java.awt.event.*;
import javax.swing.*;
import static java.lang.Double.parseDouble;
import static java.lang.Math.*;

public class ControllerPegawai{
    ViewPegawai viewPegawai;
    ModelResponsi modelResponsi;
    double hitungTunjangan, hitungPajak, hitungTotal, hitungGaji, hitungLembur;
    String strTunjangan, strPajak, strTotal, nilaiGaji, nilaiLembur;
    
    public ControllerPegawai (ViewPegawai viewPegawai, ModelResponsi modelResponsi){
        this.viewPegawai = viewPegawai;
        this.modelResponsi = modelResponsi;
    
        viewPegawai.btnSimpan.addActionListener((ActionEvent e)->{
           String id = viewPegawai.getid();
           String nama = viewPegawai.getnama();
           String posisi = viewPegawai.getposisi();
           String alamat = viewPegawai.getalamat();
           String hp = viewPegawai.gethp();
           String gaji = viewPegawai.getgaji();
           String lembur = viewPegawai.getlembur();
           String tunjangan = viewPegawai.gettunjangan();
           String pajak = viewPegawai.getpajak();
           String total = viewPegawai.gettotal();
           
           modelResponsi.insertPegawai(id, nama, posisi, alamat, hp, gaji, lembur, tunjangan, pajak, total);
           
           viewPegawai.tfid.setText("");
           viewPegawai.tfnama.setText("");
           viewPegawai.cmbposisi.setSelectedItem("");
           viewPegawai.tfalamat.setText("");
           viewPegawai.tfhp.setText("");
           viewPegawai.tfgaji.setText("");
           viewPegawai.tflembur.setText("");
           viewPegawai.tftunjangan.setText("");
           viewPegawai.tfpajak.setText("");
           viewPegawai.tftotal.setText("");
        });
        
    viewPegawai.btnHitung.addActionListener((ActionEvent e)->{
        String gaji = viewPegawai.getgaji();
        String lembur = viewPegawai.getlembur();
        
        hitungGaji = Double.parseDouble(gaji);
        hitungLembur = Double.parseDouble(lembur);

        hitungTunjangan = hitungLembur * 15000;
        hitungPajak = hitungGaji / 100 * 1;
        hitungTotal = hitungGaji - hitungPajak + hitungTunjangan;

        strTunjangan = Double.toString(hitungTunjangan);
        strPajak = Double.toString(hitungPajak);
        strTotal = Double.toString(hitungTotal);

        viewPegawai.tftunjangan.setText(strTunjangan);
        viewPegawai.tfpajak.setText(strPajak);
        viewPegawai.tftotal.setText(strTotal);
    });    
    
    viewPegawai.btnAdmin.addActionListener((ActionEvent e)->{
        LoginAdmin la = new LoginAdmin(modelResponsi);    
        this.viewPegawai.dispose();
    });

    viewPegawai.btnHome.addActionListener(((e)->{
         GUI gui = new GUI();
         this.viewPegawai.dispose();
    })); 

    viewPegawai.btnGaji.addActionListener(((e)->{
        MVC_Pegawai mvcc = new MVC_Pegawai();    
         this.viewPegawai.dispose();
    })); 

    viewPegawai.btnData.addActionListener(((e)->{
        ViewUmum vu = new ViewUmum();    
         this.viewPegawai.dispose();
    })); 

    viewPegawai.btnPetunjuk.addActionListener(((e)->{
        PetunjukPegawai mvce = new PetunjukPegawai();    
         this.viewPegawai.dispose();
    })); 
}
}