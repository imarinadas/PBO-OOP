/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.event.*;
import javax.swing.*;

public class ControllerBuku {
    ViewBuku viewBuku;
    ModelPerpus modelPerpus;
    
    public ControllerBuku(ViewBuku viewBuku, ModelPerpus modelPerpus){
        this.viewBuku= viewBuku;
        this.modelPerpus = modelPerpus;
    
        if(modelPerpus.getBanyakDataBuku() != 0){
         String dataBuku[][] = modelPerpus.readBuku();
         viewBuku.tabel.setModel((new JTable(dataBuku, viewBuku.namaKolom)).getModel());
        }else{
         JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
        
        viewBuku.btnsimpan.addActionListener((ActionEvent e)->{
           String kdbuku = viewBuku.getkdbuku();
           String nmbuku = viewBuku.getnmbuku();
           String nmpengarang = viewBuku.getnmpengarang();
           String nmpenerbit = viewBuku.getnmpenerbit();
           String thnterbit = viewBuku.getthnterbit();
           
           modelPerpus.insertBuku(kdbuku, nmbuku, nmpengarang, nmpenerbit, thnterbit);
           viewBuku.tfkdbuku.setText("");
           viewBuku.tfnmbuku.setText("");
           viewBuku.tfnmpengarang.setText("");
           viewBuku.tfnmpenerbit.setText("");
           viewBuku.tfthnterbit.setText("");
        });
        
        viewBuku.btnrefresh.addActionListener((ActionEvent e)->{
            String dataBuku[][] = modelPerpus.readBuku();
            viewBuku.tabel.setModel(new JTable(dataBuku, viewBuku.namaKolom).getModel());
            viewBuku.tfkdbuku.setText("");
            viewBuku.tfnmbuku.setText("");
            viewBuku.tfnmpengarang.setText("");
            viewBuku.tfnmpenerbit.setText("");
            viewBuku.tfthnterbit.setText("");
        });
        
        viewBuku.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewBuku.tabel.getSelectedRow();
            int kolom = viewBuku.tabel.getSelectedColumn();
                
            String dataterpilih = viewBuku.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
            viewBuku.btnhapus.addActionListener((ActionEvent d)-> {
                modelPerpus.deleteBuku(dataterpilih);
            });
        }
        });
    
    viewBuku.btnkeluar.addActionListener((ActionEvent e)->{
        GUI g = new GUI();
        this.viewBuku.dispose();
    });
    
     viewBuku.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String search = viewBuku.getSearchedBuku();
                String dataBuku[][] = modelPerpus.readsearchedBuku(search);
                viewBuku.tabel.setModel(new JTable (dataBuku, viewBuku.namaKolom).getModel());
            }
        });
}
}
