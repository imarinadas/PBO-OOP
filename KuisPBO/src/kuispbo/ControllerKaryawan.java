/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.event.*;
import javax.swing.*;

public class ControllerKaryawan {
    ViewKaryawan viewKaryawan;
    ModelPerpus modelPerpus;
    
    public ControllerKaryawan(ViewKaryawan viewKaryawan, ModelPerpus modelPerpus){
        this.viewKaryawan= viewKaryawan;
        this.modelPerpus = modelPerpus;
    
        if(modelPerpus.getBanyakDataKaryawan() != 0){
         String dataKaryawan[][] = modelPerpus.readKaryawan();
         viewKaryawan.tabel.setModel((new JTable(dataKaryawan, viewKaryawan.namaKolom)).getModel());
        }else{
         JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
        
        viewKaryawan.btnsimpan.addActionListener((ActionEvent e)->{
           String nik = viewKaryawan.getnik();
           String nmkaryawan = viewKaryawan.getnmkaryawan();
           String jk = viewKaryawan.getjk();
           String golongan = viewKaryawan.getgolongan();
           String jabatan = viewKaryawan.getjabatan();
           String tunjangan = viewKaryawan.gettunjangan();
           String jmlgaji = viewKaryawan.getjmlgaji();
           
           modelPerpus.insertKaryawan(nik, nmkaryawan, jk, golongan, jabatan, tunjangan, jmlgaji);
           viewKaryawan.tfnik.setText("");
           viewKaryawan.tfgolongan.setText("");
           viewKaryawan.outjabatan.setText("");
           viewKaryawan.outtunjangan.setText("");
           viewKaryawan.outjmlgaji.setText("");
        });
        
        viewKaryawan.btnrefresh.addActionListener((ActionEvent e)->{
           String dataKaryawan[][] = modelPerpus.readKaryawan();
           viewKaryawan.tabel.setModel(new JTable(dataKaryawan, viewKaryawan.namaKolom).getModel());
           viewKaryawan.tfnik.setText("");
           viewKaryawan.tfnmkaryawan.setText("");
           viewKaryawan.tfgolongan.setText("");
           viewKaryawan.outjabatan.setText("");
           viewKaryawan.outtunjangan.setText("");
           viewKaryawan.outjmlgaji.setText("");
        });
        
        viewKaryawan.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewKaryawan.tabel.getSelectedRow();
            int kolom = viewKaryawan.tabel.getSelectedColumn();
                
            String dataterpilih = viewKaryawan.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
            viewKaryawan.btnhapus.addActionListener((ActionEvent d)-> {
                modelPerpus.deleteKaryawan(dataterpilih);
            });
        }
        });
        
    viewKaryawan.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String search = viewKaryawan.getSearchedKaryawan();
                String dataKaryawan[][] = modelPerpus.readsearchedKaryawan(search);
                viewKaryawan.tabel.setModel(new JTable (dataKaryawan, viewKaryawan.namaKolom).getModel());
            }
        });
    
    viewKaryawan.btnkeluar.addActionListener((ActionEvent e)->{
        GUI g = new GUI();
        this.viewKaryawan.dispose();
    });
}
}
