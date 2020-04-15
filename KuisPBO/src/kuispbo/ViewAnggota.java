/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewAnggota extends JFrame{

    JLabel ljudul = new JLabel (" DATA ANGGOTA ");
    JLabel lnis = new JLabel("NIS ");
    JTextField tfnis = new JTextField();
    JLabel lnmsiswa = new JLabel("Nama Siswa ");
    JTextField tfnmsiswa = new JTextField();
    JLabel lttl = new JLabel("TTL ");
    JTextField tfttl = new JTextField();
    JLabel ljk = new JLabel("Jenis Kelamin ");
       JRadioButton rbl = new JRadioButton("Laki-Laki");
       JRadioButton rbp = new JRadioButton("Perempuan");
    JLabel lagama = new JLabel("Agama ");
    String[] nagama =
            {"Islam","Kristen","Katolik","Hindu","Budha"};
    JComboBox cmbagama = new JComboBox(nagama);
    JLabel ltdaftar = new JLabel("Tgl Daftar ");
    JTextField tftdaftar = new JTextField();
    JLabel lberlaku = new JLabel("Berlaku S/D ");
    JTextField tfberlaku = new JTextField();
    JLabel lkelas = new JLabel("Kelas ");
    JTextField tfkelas = new JTextField();
    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tableAnggota;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIS", "Nama Siswa", "TTL", "Jenis Kelamin", "Agama", "Tgl Daftar", "Berlaku S/D", "Kelas"};
    
    public ViewAnggota(){
        tableAnggota = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableAnggota);
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
        add(lnis);
        add(tfnis);
        add(lnmsiswa);
        add(tfnmsiswa);
        add(lttl);
        add(tfttl);
        add(ljk);
        add(rbl);
        add(rbp);
        add(lagama);
        add(cmbagama);
        add(ltdaftar);
        add(tftdaftar);
        add(lberlaku);
        add(tfberlaku);
        add(lkelas);
        add(tfkelas);
        add(btnsimpan);
        add(btnhapus);
        add(btnkeluar);
        add(btnrefresh);
        add(scrollPane);
        
        ljudul.setBounds(350, 50, 200, 20);
        lnis.setBounds(50, 85, 90, 20);
        tfnis.setBounds(50, 105, 200, 20);
        lnmsiswa.setBounds(50, 140, 90, 20);
        tfnmsiswa.setBounds(50, 160, 200, 20);
        lttl.setBounds(50, 195, 90, 20);
        tfttl.setBounds(50, 215, 200, 20);
        ljk.setBounds(50, 250, 90, 20);
        rbl.setBounds(50, 270, 90, 20);
        rbp.setBounds(160, 270, 100, 20);
        lagama.setBounds(300, 85, 90, 20);
        cmbagama.setBounds(300, 105, 120, 20);
        ltdaftar.setBounds(300, 140, 90, 20);
        tftdaftar.setBounds(300, 160, 120, 20);
        lberlaku.setBounds(300, 195, 280, 20);
        tfberlaku.setBounds(300, 215, 120, 20);
        lkelas.setBounds(300, 250, 280, 20);
        tfkelas.setBounds(300, 270, 120, 20);
        btnsimpan.setBounds(550, 105, 80, 20);
        btnhapus.setBounds(550, 160, 80, 20);
        btnrefresh.setBounds(550, 215, 80, 20);
        btnkeluar.setBounds(550, 270, 80, 20); 
                
        scrollPane.setBounds(50, 400, 800, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getnis(){
        return tfnis.getText();
    }
    public String getnmsiswa(){
        return tfnmsiswa.getText();
    }
    public String getttl(){
        return tfttl.getText();
    }
    public String getjk(){
        if(rbl.isSelected()){
          return rbl.getText();
        } else if(rbp.isSelected()){
          return rbp.getText();
        } return null;
    }
    public String getagama(){
        return (String) cmbagama.getSelectedItem();
    }
    public String gettdaftar(){
        return tftdaftar.getText();
    }
    public String getberlaku(){
        return tfberlaku.getText();
    }
    public String getkelas(){
        return tfkelas.getText();
    }
}
