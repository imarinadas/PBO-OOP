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

public final class ViewKaryawan extends JFrame{
    
    JLabel ljudul = new JLabel (" DATA KARYAWAN ");
    JLabel lnik = new JLabel("NIK ");
    JTextField tfnik = new JTextField();
    JLabel lnmkaryawan = new JLabel("Nama Karyawan ");
    JTextField tfnmkaryawan = new JTextField();
    JLabel ljk = new JLabel("Jenis Kelamin ");
       JRadioButton rbl = new JRadioButton("Laki-Laki");
       JRadioButton rbp = new JRadioButton("Perempuan");
    JLabel lgolongan = new JLabel("Golongan ");
    JTextField tfgolongan = new JTextField();
    JLabel ljabatan = new JLabel("Jabatan ");
    JLabel outjabatan = new JLabel();
    JLabel ltunjangan = new JLabel("Tunjangan ");
    JLabel outtunjangan = new JLabel();
    JLabel ljmlgaji = new JLabel("Jumlah Gaji ");
    JLabel outjmlgaji = new JLabel();

    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btncari = new JButton("Cari");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableKaryawan;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIK", "Nama Karyawan", "Jenis Kelamin", "Golongan", "Jabatan", "Tunjangan", "Jumlah Gaji"};
    
    public ViewKaryawan(){
        tableKaryawan = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableKaryawan);
        scrollPane = new JScrollPane(tabel);
        
        ljudul.setFont(new Font("Arial", Font.BOLD, 20));
        ButtonGroup group = new ButtonGroup();
        group.add(rbl);
        group.add(rbp);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 700);
        setLocation(300,20);
        
        add(ljudul);
        add(lnik);
        add(tfnik);
        add(lnmkaryawan);
        add(tfnmkaryawan);
        add(ljk);
        add(rbl);
        add(rbp);
        add(lgolongan);
        add(tfgolongan);
        add(ljabatan);
        add(outjabatan);
        add(ltunjangan);
        add(outtunjangan);
        add(ljmlgaji);
        add(outjmlgaji);
        add(btnsimpan);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(btnkeluar);        
        add(scrollPane);
        
        ljudul.setBounds(350, 30, 200, 20);
        lnik.setBounds(50, 85, 90, 20);
        tfnik.setBounds(50, 105, 200, 20);
        lnmkaryawan.setBounds(50, 140, 150, 20);
        tfnmkaryawan.setBounds(50, 160, 200, 20);
        ljk.setBounds(50, 195, 150, 20);
        rbl.setBounds(50, 215, 90, 20);
        rbp.setBounds(160, 215, 100, 20);
        lgolongan.setBounds(50, 250, 90, 20);
        tfgolongan.setBounds(50, 270, 200, 20);
        ljabatan.setBounds(300, 85, 90, 20);
        outjabatan.setBounds(300, 105, 200, 20);
        ltunjangan.setBounds(300, 140, 90, 20);
        outtunjangan.setBounds(300, 160, 200, 20);
        ljmlgaji.setBounds(300, 195, 90, 20);
        outjmlgaji.setBounds(300, 215, 200, 20);
        btnsimpan.setBounds(550, 105, 90, 20);
        btnhapus.setBounds(550, 160, 90, 20);
        btnrefresh.setBounds(550, 215, 90, 20);
        btncari.setBounds(550, 270, 90, 20);
        btnkeluar.setBounds(550, 325, 90, 20);
                
        scrollPane.setBounds(50, 400, 800, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getnik(){
        return tfnik.getText();
    }
    public String getSearchedKaryawan(){
        return tfnik.getText();
    }
    public String getnmkaryawan(){
        return tfnmkaryawan.getText();
    }
    public String getjk(){
        if(rbl.isSelected()){
          return rbl.getText();
        } else if(rbp.isSelected()){
          return rbp.getText();
        } return null;
    }
    public String getgolongan(){
        return tfgolongan.getText();
    }
    public String getjabatan(){
        switch (tfgolongan.getText()) {
            case "1":
                return "manager";
            case "2":
                return "supervisor";
            case "3":
                return "staff";
            case "4":
                return "ass staff";
            case "5":
                return "honorer";
        }return null;
    }
    public String gettunjangan(){
        switch (tfgolongan.getText()) {
            case "1":
                return "700000";
            case "2":
                return "500000";
            case "3":
                return "300000";
            case "4":
                return "250000";
            case "5":
                return "200000";
        }return null;
    }
    public String getjmlgaji(){
        switch (tfgolongan.getText()) {
            case "1":
                return "1000000";
            case "2":
                return "900000";
            case "3":
                return "800000";
            case "4":
                return "750000";
            case "5":
                return "650000";
        }return null;
    }
}
