/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */

package tugaspbo6;

import java.awt.event.*;
import javax.swing.*;

public class ControllerData{
    ViewData viewData;
    ModelData modelData;
    
    public ControllerData (ViewData viewData, ModelData modelData){
        this.viewData = viewData;
        this.modelData = modelData;
    
        if(modelData.getBanyakData() != 0){
         String filmData[][] = modelData.readData();
         viewData.tabel.setModel((new JTable(filmData, viewData.namaKolom)).getModel());
        }else{
         JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }
        
        viewData.btnCreate.addActionListener((ActionEvent e)->{
           String judul = viewData.getJudul();
           String tipe = viewData.getTipe();
           String episode = viewData.getEpisode();
           String genre = viewData.getGenre();
           String status = viewData.getStatus();
           String rating = viewData.getRating();
           
           modelData.insertData(judul, tipe, episode, genre, status, rating);
           viewData.tfJudul.setText("");
           viewData.tfTipe.setText("");
           viewData.tfEpisode.setText("");
           viewData.tfGenre.setText("");
        });
        
        viewData.btnRefresh.addActionListener((ActionEvent e)->{
           String filmData[][] = modelData.readData();
           viewData.tabel.setModel(new JTable(filmData, viewData.namaKolom).getModel());
        });
        
        viewData.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
            int baris = viewData.tabel.getSelectedRow();
            int kolom = viewData.tabel.getSelectedColumn();
                
            String dataterpilih = viewData.tabel.getValueAt(baris, 1).toString();
            String judulterpilih = viewData.tabel.getValueAt(baris, 2).toString();
            String tipeterpilih = viewData.tabel.getValueAt(baris, 3).toString();
            String episodeterpilih = viewData.tabel.getValueAt(baris, 4).toString();
            String genreterpilih = viewData.tabel.getValueAt(baris, 5).toString();
            String statusterpilih = viewData.tabel.getValueAt(baris, 6).toString();
            String ratingterpilih = viewData.tabel.getValueAt(baris, 7).toString();
            
            viewData.tfJudul.setText(judulterpilih);
            viewData.tfTipe.setText(tipeterpilih);
            viewData.tfEpisode.setText(episodeterpilih);
            viewData.tfGenre.setText(genreterpilih);
            viewData.cmbStatus.setSelectedItem(statusterpilih);
            viewData.tfRating.setText(ratingterpilih);          
            
            viewData.btnUpdate.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent u){
                    String id = dataterpilih;
                    String judul = viewData.getJudul();
                    String tipe = viewData.getTipe();
                    String episode = viewData.getEpisode();
                    String genre = viewData.getGenre();
                    String status = viewData.getStatus();
                    String rating = viewData.getRating();
                    modelData.updateData(id, judul, tipe, episode, genre, status, rating);
                }
            });
            
            viewData.btnDelete.addActionListener((ActionEvent d)-> {
                modelData.deleteData(dataterpilih);
            });
            
        }
        });
        
        viewData.btnSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String search = viewData.getSearch();
                String filmData[][] = modelData.readsearchedData(search);
                viewData.tabel.setModel(new JTable (filmData, viewData.namaKolom).getModel());
            }
        });
    
    viewData.btnExit.addActionListener((ActionEvent e)->{
        GUI g = new GUI();
        this.viewData.dispose();
    });
}
}