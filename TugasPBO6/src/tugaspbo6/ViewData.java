/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */

package tugaspbo6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {
    JLabel lJudul = new JLabel("Judul ");
    JTextField tfJudul = new JTextField();
    JLabel lTipe = new JLabel("Tipe ");
    JTextField tfTipe = new JTextField();
    JLabel lEpisode = new JLabel("Episode ");
    JTextField tfEpisode = new JTextField();
    JLabel lGenre = new JLabel("Genre ");
    JTextField tfGenre = new JTextField();
    JLabel lStatus = new JLabel("Status ");
    String[] nStatus =
            {"Selesai","Belum"};
    JComboBox cmbStatus = new JComboBox(nStatus);
    JLabel lRating = new JLabel("Rating ");
    JTextField tfRating = new JTextField();
    JTextField tfSearch = new JTextField();
    JButton btnSearch = new JButton("Search");
    JButton btnRefresh = new JButton("Refresh");
    JButton btnCreate = new JButton("Create");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnExit = new JButton("Exit");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"#", "ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};
    
    public ViewData(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(300,20);
        
        add(lJudul);
        lJudul.setBounds(50, 230, 310, 20);
        add(tfJudul);
        tfJudul.setBounds(50, 250, 310, 20);
        add(lTipe);
        lTipe.setBounds(50, 285, 90, 20);
        add(tfTipe);
        tfTipe.setBounds(50, 305, 120, 20);
        add(lEpisode);
        lEpisode.setBounds(50, 340, 90, 20);
        add(tfEpisode);
        tfEpisode.setBounds(50, 360, 120, 20);
        add(lGenre);
        lGenre.setBounds(50, 395, 310, 20);
        add(tfGenre);
        tfGenre.setBounds(50, 415, 310, 20);
        add(lStatus);
        lStatus.setBounds(190, 285, 90, 20);
        add(cmbStatus);
        cmbStatus.setBounds(190, 305, 120, 20);
        add(lRating);
        lRating.setBounds(190, 340, 90, 20);
        add(tfRating);
        tfRating.setBounds(190, 360, 120, 20);
        add(tfSearch);
        tfSearch.setBounds(390, 250, 280, 20);
        add(btnSearch);
        btnSearch.setBounds(690, 250, 80, 20);
        add(btnRefresh);
        btnRefresh.setBounds(400, 415, 80, 20);
        add(btnCreate);
        btnCreate.setBounds(495, 415, 80, 20); 
        add(btnUpdate);
        btnUpdate.setBounds(590, 415, 80, 20); 
        add(btnDelete);
        btnDelete.setBounds(685, 415, 80, 20); 
        add(btnExit);
        btnExit.setBounds(780, 415, 80, 20); 
        
        add(scrollPane);
        scrollPane.setBounds(50, 10, 800, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getJudul(){
        return tfJudul.getText();
    }
    public String getTipe(){
        return tfTipe.getText();
    }
    public String getEpisode(){
        return tfEpisode.getText();
    }
    public String getGenre(){
        return tfGenre.getText();
    }
    public String getStatus(){
        return (String) cmbStatus.getSelectedItem();
    }
    public String getRating(){
        return tfRating.getText();
    }
    public String getSearch(){
        return tfSearch.getText();
    }
}

