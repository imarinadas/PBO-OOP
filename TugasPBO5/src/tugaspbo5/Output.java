/*
 * Tugas PBO 5 - Plug B
 * Nada Salsabila Imari
 * 123180126
 */

//HALAMAN KETIGA

package tugaspbo5;

import javax.swing.*;

public class Output extends JFrame {
    String inNama, inJk, inAgama, inHobi;
    
    JLabel lnama = new JLabel(" Nama Lengkap ");
    JLabel ljeniskelamin = new JLabel(" Jenis Kelamin ");
    JLabel lagama = new JLabel(" Agama ");
    JLabel lhobi = new JLabel(" Hobi ");
    JLabel outNama = new JLabel();
    JLabel outJk = new JLabel();
    JLabel outAgama = new JLabel();
    JLabel outHobi = new JLabel();
    
    public Output(String inNama, String inJk, String inAgama, String inHobi){
        setTitle(" Output Form Biodata TugasPBO5 ");
	setDefaultCloseOperation(3);
	setSize(350,600);
        setLocation(500, 50);

        this.inNama = inNama;
        this.inJk = inJk;
        this.inAgama = inAgama;
        this.inHobi = inHobi;
        outNama.setText(inNama);
        outJk.setText(inJk);    
        outAgama.setText(inAgama); 
        outHobi.setText(inHobi);
        
        setLayout(null);
        add(lnama);
        add(outNama);
        add(ljeniskelamin);
        add(outJk);
        add(lagama);
        add(outAgama);
        add(lhobi);
        add(outHobi);
       

        lnama.setBounds(10,30,120,30);
	outNama.setBounds(150,30,120,30);
        ljeniskelamin.setBounds(10,75,120,30);
        outJk.setBounds(150,75,120,30);
        lagama.setBounds(10,120,120,30);
        outAgama.setBounds(150,120,120,30);
        lhobi.setBounds(10,165,150,30);
        outHobi.setBounds(150,165,150,30);
        
        setVisible(true);
    }
}