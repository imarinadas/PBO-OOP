/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.event.*;
import javax.swing.*;

public class ControllerAnggota {
    ViewAnggota viewAnggota;
    ModelPerpus modelPerpus;
    
    public ControllerAnggota (ViewAnggota viewAnggota, ModelPerpus modelPerpus){
        this.viewAnggota = viewAnggota;
        this.modelPerpus = modelPerpus;
    
        if(modelPerpus.getBanyakDataAnggota() != 0){
         String dataAnggota[][] = modelPerpus.readAnggota();
         viewAnggota.tabel.setModel((new JTable(dataAnggota, viewAnggota.namaKolom)).getModel());
        }else{
         JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
        
        viewAnggota.btnsimpan.addActionListener((ActionEvent e)->{
           String nis = viewAnggota.getnis();
           String nmsiswa = viewAnggota.getnmsiswa();
           String ttl = viewAnggota.getttl();
           String jk = viewAnggota.getjk();
           String agama = viewAnggota.getagama();
           String tdaftar = viewAnggota.gettdaftar();
           String berlaku = viewAnggota.getberlaku();
           String kelas = viewAnggota.getkelas();
           
           modelPerpus.insertAnggota(nis, nmsiswa, ttl, jk, agama, tdaftar, berlaku, kelas);
           viewAnggota.tfnis.setText("");
           viewAnggota.tfnmsiswa.setText("");
           viewAnggota.tfttl.setText("");
           viewAnggota.tftdaftar.setText("");
           viewAnggota.tfberlaku.setText("");
           viewAnggota.tfkelas.setText("");
        });
        
        viewAnggota.btnrefresh.addActionListener((ActionEvent e)->{
            String dataAnggota[][] = modelPerpus.readAnggota();
            viewAnggota.tabel.setModel(new JTable(dataAnggota, viewAnggota.namaKolom).getModel());
            viewAnggota.tfnis.setText("");
            viewAnggota.tfnmsiswa.setText("");
            viewAnggota.tfttl.setText("");
            viewAnggota.tftdaftar.setText("");
            viewAnggota.tfberlaku.setText("");
            viewAnggota.tfkelas.setText("");
        });
        
        viewAnggota.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewAnggota.tabel.getSelectedRow();
            int kolom = viewAnggota.tabel.getSelectedColumn();
                
            String dataterpilih = viewAnggota.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
            viewAnggota.btnhapus.addActionListener((ActionEvent d)-> {
                modelPerpus.deleteAnggota(dataterpilih);
            });
        }
        });
    
    viewAnggota.btnkeluar.addActionListener((ActionEvent e)->{
        GUI g = new GUI();
        this.viewAnggota.dispose();
    });
}
}
