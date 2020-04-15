/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBuku extends JFrame{
    JLabel ljudul = new JLabel (" DATA BUKU ");
    JLabel lkdbuku = new JLabel("Kode Buku ");
    JTextField tfkdbuku = new JTextField();
    JLabel lnmbuku = new JLabel("Nama Buku ");
    JTextField tfnmbuku = new JTextField();
    JLabel lnmpengarang = new JLabel("Nama Pengarang ");
    JTextField tfnmpengarang = new JTextField();
    JLabel lnmpenerbit = new JLabel("Nama Penerbit ");
    JTextField tfnmpenerbit = new JTextField();
    JLabel lthnterbit = new JLabel("Tahun Terbit ");
    JTextField tfthnterbit = new JTextField();

    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btncari = new JButton("Cari");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableBuku;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Kode Buku", "Nama Buku", "Nama Pengarang", "Nama Penerbir", "Tahun Terbit"};
    
    public ViewBuku(){
        tableBuku = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableBuku);
        scrollPane = new JScrollPane(tabel);
        
        ljudul.setFont(new Font("Arial", Font.BOLD, 20));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 700);
        setLocation(300,20);
        
        add(ljudul);
        add(lkdbuku);
        add(tfkdbuku);
        add(lnmbuku);
        add(tfnmbuku);
        add(lnmpengarang);
        add(tfnmpengarang);
        add(lnmpenerbit);
        add(tfnmpenerbit);
        add(lthnterbit);
        add(tfthnterbit);
        add(btnsimpan);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(btnkeluar);        
        add(scrollPane);
        
        ljudul.setBounds(350, 50, 200, 20);
        lkdbuku.setBounds(50, 85, 90, 20);
        tfkdbuku.setBounds(50, 105, 200, 20);
        lnmbuku.setBounds(50, 140, 90, 20);
        tfnmbuku.setBounds(50, 160, 200, 20);
        lnmpengarang.setBounds(50, 195, 150, 20);
        tfnmpengarang.setBounds(50, 215, 200, 20);
        lnmpenerbit.setBounds(50, 250, 90, 20);
        tfnmpenerbit.setBounds(50, 270, 200, 20);
        lthnterbit.setBounds(50, 305, 90, 20);
        tfthnterbit.setBounds(50, 325, 200, 20);
        btnsimpan.setBounds(300, 105, 90, 20);
        btnhapus.setBounds(300, 160, 90, 20);
        btnrefresh.setBounds(300, 215, 90, 20);
        btncari.setBounds(300, 270, 90, 20);
        btnkeluar.setBounds(300, 325, 90, 20);
                
        scrollPane.setBounds(50, 400, 800, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getkdbuku(){
        return tfkdbuku.getText();
    }
    public String getSearchedBuku(){
        return tfkdbuku.getText();
    }
    public String getnmbuku(){
        return tfnmbuku.getText();
    }
    public String getnmpengarang(){
        return tfnmpengarang.getText();
    }
    public String getnmpenerbit(){
        return tfnmpenerbit.getText();
    }
    public String getthnterbit(){
        return tfthnterbit.getText();
    }
}
