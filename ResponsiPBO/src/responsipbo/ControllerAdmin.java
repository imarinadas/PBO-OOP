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

public class ControllerAdmin{
    ViewAdmin viewAdmin;
    ModelResponsi modelResponsi;
    double hitungTunjangan, hitungPajak, hitungTotal, hitungGaji, hitungLembur;
    String strTunjangan, strPajak, strTotal, nilaiGaji, nilaiLembur;
    
    public ControllerAdmin (ViewAdmin viewAdmin, ModelResponsi modelResponsi){
        this.viewAdmin = viewAdmin;
        this.modelResponsi = modelResponsi;
    
        viewAdmin.btnSimpan.addActionListener((ActionEvent e)->{
           String id = viewAdmin.getid();
           String nama = viewAdmin.getnama();
           String posisi = viewAdmin.getposisi();
           String alamat = viewAdmin.getalamat();
           String hp = viewAdmin.gethp();
           String gaji = viewAdmin.getgaji();
           String lembur = viewAdmin.getlembur();

           
            hitungGaji = Double.parseDouble(gaji);
            hitungLembur = Double.parseDouble(lembur);

            hitungTunjangan = hitungLembur * 15000;
            hitungPajak = hitungGaji / 100 * 1;
            hitungTotal = hitungGaji - hitungPajak + hitungTunjangan;

            strTunjangan = Double.toString(hitungTunjangan);
            strPajak = Double.toString(hitungPajak);
            strTotal = Double.toString(hitungTotal);

            viewAdmin.tftunjangan.setText(strTunjangan);
            viewAdmin.tfpajak.setText(strPajak);
            viewAdmin.tftotal.setText(strTotal);
            
           String tunjangan = viewAdmin.gettunjangan();
           String pajak = viewAdmin.getpajak();
           String total = viewAdmin.gettotal();
        
           modelResponsi.insertPegawai(id, nama, posisi, alamat, hp, gaji, lembur, tunjangan, pajak, total);
           
           viewAdmin.tfid.setText("");
           viewAdmin.tfnama.setText("");
           viewAdmin.cmbposisi.setSelectedItem("");
           viewAdmin.tfalamat.setText("");
           viewAdmin.tfhp.setText("");
           viewAdmin.tfgaji.setText("");
           viewAdmin.tflembur.setText("");
           viewAdmin.tftunjangan.setText("");
           viewAdmin.tfpajak.setText("");
           viewAdmin.tftotal.setText("");
        });
    
        viewAdmin.btnKaryawan.addActionListener((ActionEvent e)->{
            GUI gui = new GUI();    
            this.viewAdmin.dispose();
        });
        
        viewAdmin.btnHome.addActionListener(((e)->{
            HomeAdmin ha = new HomeAdmin();
            this.viewAdmin.dispose();
        })); 
        
        viewAdmin.btnTambah.addActionListener(((e)->{
            MVC_Admin mvcc = new MVC_Admin();    
            this.viewAdmin.dispose();
        })); 
                
        viewAdmin.btnData.addActionListener(((e)->{
            ViewUmum vu = new ViewUmum();    
            this.viewAdmin.dispose();
        })); 
        
        viewAdmin.btnPetunjuk.addActionListener(((e)->{
            PetunjukAdmin mvce = new PetunjukAdmin();    
            this.viewAdmin.dispose();
        })); 
}
}