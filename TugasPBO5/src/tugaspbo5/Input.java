/*
 * Tugas PBO 5 - Plug B
 * Nada Salsabila Imari
 * 123180126
 */

//HALAMAN KEDUA

package tugaspbo5;

import java.awt.event.*;
import javax.swing.*;

public class Input extends JFrame {
   String inNama, inJk, inAgama, inHobi;
    
   final JTextField fnama = new JTextField(20);

   JLabel lnama = new JLabel(" Nama Lengkap ");
   JLabel ljeniskelamin = new JLabel(" Jenis Kelamin ");

   JRadioButton rbPria = new JRadioButton("Laki-Laki");
   JRadioButton rbWanita = new JRadioButton("Perempuan");

   JLabel lagama = new JLabel(" Agama ");
   String[] namaAgama =
            {"Islam","Kristen","Katolik","Hindu","Budha"};
   JComboBox cmbAgama = new JComboBox(namaAgama);

   JLabel lhobi = new JLabel(" Hobi ");

   JCheckBox cbSepakbola = new JCheckBox("Sepakbola");
   JCheckBox cbBasket = new JCheckBox("Basket");

   JButton btnSave = new JButton("OK");

    public Input() {
        setTitle(" Input Form Biodata TugasPBO5 ");
	setDefaultCloseOperation(3);
	setSize(350,600);
        setLocation(500, 50);
        
         btnSave.addActionListener((ActionEvent e) -> {
            if(fnama.getText().length() == 0){
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
            } else{
                inNama = fnama.getText();

                if(rbPria.isSelected()){
                    inJk = rbPria.getText();
                } else if(rbWanita.isSelected()){
                    inJk = rbWanita.getText();
                }
                    inAgama = (String) cmbAgama.getSelectedItem();

                if(cbSepakbola.isSelected()&&cbBasket.isSelected())
                {
                    inHobi = cbSepakbola.getText() + " dan " +cbBasket.getText();
                } else if(cbSepakbola.isSelected()){
                    inHobi = cbSepakbola.getText();
                } else if(cbBasket.isSelected()){
                    inHobi = cbBasket.getText();
                } 

            Output out = new Output(inNama, inJk, inAgama, inHobi);
            out.setVisible(true);
            } dispose();
        });
        
	ButtonGroup group = new ButtonGroup();
	group.add(rbPria);
	group.add(rbWanita);

	setLayout(null);
	add(lnama);
	add(fnama);
	add(ljeniskelamin);
	add(rbPria);
	add(rbWanita);
	add(lagama);
	add(cmbAgama);
	add(lhobi);
	add(cbSepakbola);
	add(cbBasket);
	add(btnSave);      
	
        lnama.setBounds(10,30,120,30);
	fnama.setBounds(130,30,150,30);
	ljeniskelamin.setBounds(10,75,120,30);
	rbPria.setBounds(130,75,100,30);
	rbWanita.setBounds(230,75,100,30);
	lagama.setBounds(10,120,150,30);
	cmbAgama.setBounds(130,120,150,30);
	lhobi.setBounds(10,165,120,30);
	cbSepakbola.setBounds(130,165,100,30);
	cbBasket.setBounds(230,165,150,30);
	btnSave.setBounds(100,210,120,30);
    
        setVisible(true);
   }


}