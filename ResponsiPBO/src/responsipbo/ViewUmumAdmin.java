/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */

package responsipbo;

import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewUmumAdmin extends JFrame {
    JButton btnShow = new JButton("Show");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    
    JButton btnKaryawan = new JButton(" Karyawan ");
    JButton btnHome = new JButton(" Home ");
    JButton btnTambah = new JButton(" Tambah ");
    JButton btnData = new JButton(" Data ");
    JButton btnPetunjuk = new JButton(" Petunjuk ");
    
    JLabel lcari = new JLabel(" ID Pegawai ");
    JTextField tfcari = new JTextField();
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "Alamat", "No HP", "Posisi", "Gaji Pokok"};
    
    public ViewUmumAdmin(){
        ModelResponsi modelresponsi = new ModelResponsi();
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setTitle(" Data Pegawai ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);
        
        btnKaryawan.addActionListener((ActionEvent e)->{
            GUI gui = new GUI();    
            dispose();
        });
        
        btnHome.addActionListener(((e)->{
             HomeAdmin ha = new HomeAdmin();
             dispose();
        })); 
        
        btnTambah.addActionListener(((e)->{
            MVC_Admin mvcc = new MVC_Admin();    
             dispose();
        })); 
                
        btnData.addActionListener(((e)->{
            ViewUmum vu = new ViewUmum();    
             dispose();
        })); 
        
        btnPetunjuk.addActionListener(((e)->{
            PetunjukAdmin mvce = new PetunjukAdmin();    
             dispose();
        })); 
        
        btnShow.addActionListener((ActionEvent e)->{
            String dataPegawai[][] = modelresponsi.readPegawai();
            tabel.setModel(new JTable(dataPegawai, namaKolom).getModel());
        });
        
        btnUpdate.addActionListener((ActionEvent e)->{
            UpdatePegawai up = new UpdatePegawai();    
             dispose();
        });
        
        btnDelete.addActionListener((ActionEvent e)->{
            modelresponsi.deletePegawai(tfcari.getText());
            String dataPegawai[][] = modelresponsi.readPegawai();
            tabel.setModel(new JTable(dataPegawai, namaKolom).getModel());
            tfcari.setText("");
        });
        
	setLayout(null);
        add(btnShow);
        add(btnUpdate);
        add(btnDelete);
        add(btnKaryawan);
        add(btnHome);
        add(btnTambah);
        add(btnData);
        add(btnPetunjuk);
        add(lcari);
        add(tfcari);
        
        btnShow.setBounds(450,470,100,50);
        btnUpdate.setBounds(600,470,100,50);
        btnDelete.setBounds(750,470,100,50);
        btnKaryawan.setBounds(750,50,100,50);
        btnHome.setBounds(50,120,100,50);
        btnTambah.setBounds(50,190,100,50);
        btnData.setBounds(50,260,100,50);
        btnPetunjuk.setBounds(50,330,100,50);
        
        lcari.setBounds(150,470,100,50);
        tfcari.setBounds(300,470,100,50);
        
	setVisible(true);
        
        add(scrollPane);
        scrollPane.setBounds(165,120,700,300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
}