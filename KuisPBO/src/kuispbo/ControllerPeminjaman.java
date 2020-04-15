/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;

public class ControllerPeminjaman {
    ViewPeminjaman viewPeminjaman;
    ModelPerpus modelPerpus;
    
    public ControllerPeminjaman(ViewPeminjaman viewPeminjaman, ModelPerpus modelPerpus){
        this.viewPeminjaman= viewPeminjaman;
        this.modelPerpus = modelPerpus;
    
        if(modelPerpus.getBanyakDataPeminjaman() != 0){
         String dataPeminjaman[][] = modelPerpus.readPeminjaman();
         viewPeminjaman.tabel.setModel((new JTable(dataPeminjaman, viewPeminjaman.namaKolom)).getModel());
        }else{
         JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
        
        viewPeminjaman.btnsimpan.addActionListener((ActionEvent e)->{
           String nopinjam = viewPeminjaman.getnopinjam();
           String nis = viewPeminjaman.getnis();
           String kdbuku = viewPeminjaman.getkdbuku();
           String tglpinjam = viewPeminjaman.gettglpinjam();
           String tglkembali = viewPeminjaman.gettglkembali();
           String nik = viewPeminjaman.getnik();
           
           modelPerpus.insertPeminjaman(nopinjam, nis, kdbuku, tglpinjam, tglkembali, nik);
           viewPeminjaman.tfnopinjam.setText("");
           viewPeminjaman.tfnis.setText("");
           viewPeminjaman.outnmsiswa.setText("");
           viewPeminjaman.outkelas.setText("");
           viewPeminjaman.tfkdbuku.setText("");
           viewPeminjaman.outnmbuku.setText("");
           viewPeminjaman.outnmpenerbit.setText("");
           viewPeminjaman.tftglpinjam.setText("");
           viewPeminjaman.tftglkembali.setText("");
           viewPeminjaman.outlmpinjam.setText("");
           viewPeminjaman.tfnik.setText("");
           viewPeminjaman.outnmkaryawan.setText("");
        });
        
        viewPeminjaman.btnrefresh.addActionListener((ActionEvent e)->{
           String dataPeminjaman[][] = modelPerpus.readPeminjaman();
           viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
           viewPeminjaman.tfnopinjam.setText("");
           viewPeminjaman.tfnis.setText("");
           viewPeminjaman.outnmsiswa.setText("");
           viewPeminjaman.outkelas.setText("");
           viewPeminjaman.tfkdbuku.setText("");
           viewPeminjaman.outnmbuku.setText("");
           viewPeminjaman.outnmpenerbit.setText("");
           viewPeminjaman.tftglpinjam.setText("");
           viewPeminjaman.tftglkembali.setText("");
           viewPeminjaman.outlmpinjam.setText("");
           viewPeminjaman.tfnik.setText("");
           viewPeminjaman.outnmkaryawan.setText("");
        });
        
        viewPeminjaman.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewPeminjaman.tabel.getSelectedRow();
            int kolom = viewPeminjaman.tabel.getSelectedColumn();
                
            String dataterpilih = viewPeminjaman.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
            viewPeminjaman.btnhapus.addActionListener((ActionEvent d)-> {
                modelPerpus.deletePeminjaman(dataterpilih);
            });
        }
        });
    
    viewPeminjaman.btnkeluar.addActionListener((ActionEvent e)->{
        GUI g = new GUI();
        this.viewPeminjaman.dispose();
    });
    
    viewPeminjaman.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String search = viewPeminjaman.getSearchedPeminjaman();
                String dataPeminjaman[][] = modelPerpus.readsearchedPeminjaman(search);
                viewPeminjaman.tabel.setModel(new JTable (dataPeminjaman, viewPeminjaman.namaKolom).getModel());
            }
    });
}
}
