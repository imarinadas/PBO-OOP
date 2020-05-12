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

public class ViewUmum extends JFrame {
    JButton btnShow = new JButton("Show");
    
    JButton btnAdmin = new JButton(" Admin ");
    JButton btnHome = new JButton(" Home ");
    JButton btnGaji = new JButton(" Gaji ");
    JButton btnData = new JButton(" Data ");
    JButton btnPetunjuk = new JButton(" Petunjuk ");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "Posisi", "Gaji Pokok", "Jam Lembur", "Tunjangan", "Total Gaji"};
    
    public ViewUmum(){
        ModelResponsi modelresponsi = new ModelResponsi();
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setTitle(" Data Pegawai ");
	setDefaultCloseOperation(3);
	setSize(900, 600);
        setLocation(300,20);
        
        btnAdmin.addActionListener((ActionEvent e)->{
            LoginAdmin la = new LoginAdmin(modelresponsi);    
            dispose();
        });
        
        btnHome.addActionListener(((e)->{
             GUI gui = new GUI();
             dispose();
        })); 
        
        btnGaji.addActionListener(((e)->{
            MVC_Pegawai mvcc = new MVC_Pegawai();    
             dispose();
        })); 
                
        btnData.addActionListener(((e)->{
            MVC_Pegawai mvcd = new MVC_Pegawai();    
             dispose();
        })); 
        
        btnPetunjuk.addActionListener(((e)->{
            PetunjukPegawai mvce = new PetunjukPegawai();    
             dispose();
        })); 
        
        btnShow.addActionListener((ActionEvent e)->{
            String dataPegawai[][] = modelresponsi.readPegawai();
            tabel.setModel(new JTable(dataPegawai, namaKolom).getModel());
        });
        
	setLayout(null);
        add(btnShow);
        add(btnAdmin);
        add(btnHome);
        add(btnGaji);
        add(btnData);
        add(btnPetunjuk);
        
        btnShow.setBounds(750,470,100,50);
        btnAdmin.setBounds(750,50,100,50);
        btnHome.setBounds(50,120,100,50);
        btnGaji.setBounds(50,190,100,50);
        btnData.setBounds(50,260,100,50);
        btnPetunjuk.setBounds(50,330,100,50);
	setVisible(true);
        
        add(scrollPane);
        scrollPane.setBounds(165,120,700,300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}