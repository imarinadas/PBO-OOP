/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.awt.Font;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewPeminjaman extends JFrame{
    String innmsiswa, inkelas, innmbuku, innmpenerbit, lmpinjam, indenda, innmkaryawan;
    
    JLabel ljudul = new JLabel (" DATA PEMINJAMAN ");
    JLabel lnopinjam = new JLabel("No Pinjam ");
    JTextField tfnopinjam = new JTextField();
    JLabel lnis = new JLabel("NIS ");
    JTextField tfnis = new JTextField();
    JLabel lnmsiswa = new JLabel("Nama Siswa ");
    JLabel outnmsiswa = new JLabel();
    JLabel lkelas = new JLabel("Kelas ");
    JLabel outkelas = new JLabel();
    JLabel lkdbuku = new JLabel("Kode Buku ");
    JTextField tfkdbuku = new JTextField();
    JLabel lnmbuku = new JLabel("Nama Buku ");
    JLabel outnmbuku = new JLabel();
    JLabel lnmpenerbit = new JLabel("Penerbit ");
    JLabel outnmpenerbit = new JLabel();
    JLabel ltglpinjam = new JLabel("Tgl Pinjam ");
    JTextField tftglpinjam = new JTextField();
    JLabel ltglkembali = new JLabel("Tgl Kembali ");
    JTextField tftglkembali = new JTextField();
    JLabel llmpinjam = new JLabel("Lama Pinjam ");
    JLabel outlmpinjam = new JLabel();
    JLabel ldenda = new JLabel("Denda ");
    JLabel outdenda = new JLabel();
    JLabel lnik = new JLabel("NIK ");
    JTextField tfnik = new JTextField();
    JLabel lnmkaryawan = new JLabel("Petugas ");
    JLabel outnmkaryawan = new JLabel();


    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btncari = new JButton("Cari");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableKaryawan;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No Pinjam", "NIS", "Nama Siswa", "Kelas", "Kode Buku", "Nama Buku", "Penerbit", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Denda", "Petugas", "NIK"};
    
    public ViewPeminjaman(){
        tableKaryawan = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableKaryawan);
        scrollPane = new JScrollPane(tabel);
        
        ljudul.setFont(new Font("Arial", Font.BOLD, 20));
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 700);
        setLocation(300,20);
        
        add(ljudul);
        add(lnopinjam);
        add(tfnopinjam);
        add(lnis);
        add(tfnis);
        add(lnmsiswa);
        add(outnmsiswa);
        add(lkelas);
        add(outkelas);
        add(lkdbuku);
        add(tfkdbuku);
        add(lnmbuku);
        add(outnmbuku);
        add(lnmpenerbit);
        add(outnmpenerbit);
        add(ltglpinjam);
        add(tftglpinjam);
        add(ltglkembali);
        add(tftglkembali);
        add(llmpinjam);
        add(outlmpinjam);
        add(ldenda);
        add(outdenda);
        add(lnik);
        add(tfnik);
        add(lnmkaryawan);
        add(outnmkaryawan);
        add(btnsimpan);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(btnkeluar);        
        add(scrollPane);
        
        ljudul.setBounds(350, 50, 200, 20);
        lnopinjam.setBounds(50, 85, 90, 20);
        tfnopinjam.setBounds(160, 85, 200, 20);
        lnis.setBounds(50, 105, 90, 20);
        tfnis.setBounds(160, 105, 200, 20);
        lnmsiswa.setBounds(50, 140, 90, 20);
        outnmsiswa.setBounds(160, 140, 200, 20);
        lkelas.setBounds(50, 175, 90, 20);
        outkelas.setBounds(160, 175, 200, 20);
        lkdbuku.setBounds(50, 210, 90, 20);
        tfkdbuku.setBounds(50, 230, 200, 20);
        lnmbuku.setBounds(50, 265, 90, 20);
        outnmbuku.setBounds(160, 265, 200, 20);
        lnmpenerbit.setBounds(50, 300, 90, 20);
        outnmpenerbit.setBounds(160, 300, 200, 20);
        
        ltglpinjam.setBounds(400, 85, 90, 20);
        tftglpinjam.setBounds(400, 105, 200, 20);
        ltglkembali.setBounds(400, 140, 90, 20);
        tftglkembali.setBounds(400, 160, 200, 20);
        llmpinjam.setBounds(400, 195, 90, 20);
        outlmpinjam.setBounds(500, 195, 100, 20);
        ldenda.setBounds(400, 230, 90, 20);
        outdenda.setBounds(500, 230, 100, 20);
        lnik.setBounds(400, 265, 90, 20);
        tfnik.setBounds(400, 285, 200, 20);
        lnmkaryawan.setBounds(400, 320, 90, 20);
        outnmkaryawan.setBounds(500, 320, 200, 20);
        
        btnsimpan.setBounds(700, 105, 90, 20);
        btnhapus.setBounds(700, 160, 90, 20);
        btnrefresh.setBounds(700, 215, 90, 20);
        btncari.setBounds(700, 270, 90, 20);
        btnkeluar.setBounds(700, 325, 90, 20);
                
        scrollPane.setBounds(50, 400, 800, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getSearchedPeminjaman(){
        return tfnopinjam.getText();
    }
    public String getnopinjam(){
        return tfnopinjam.getText();
    }
    public String getnis(){
        return tfnis.getText();
    }
    public String getkdbuku(){
        return tfkdbuku.getText();
    }
    public String gettglpinjam(){
        return tftglpinjam.getText();
    }
    public String gettglkembali(){
        return tftglkembali.getText();
    }
    public String getnik(){
        return tfnik.getText();
    }
}
