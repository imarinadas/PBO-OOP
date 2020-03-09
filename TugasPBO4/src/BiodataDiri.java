import javax.swing.*; 
import java.awt.*;

public class BiodataDiri {
    public static void main(String[] args){
        JFrame frame = new JFrame("Tugas PBO 4");
        Biodata b = new Biodata();
    }
}

class Biodata extends JFrame{
    JLabel lJudul = new JLabel(" BIODATA DIRI ");
    JLabel lGambar;
    JLabel lNama = new JLabel(" NADA SALSABILA IMARI ");
    JLabel lTtl = new JLabel (" Sleman, 22 Juli 1998 ");
    String[] namaAgama =
            {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
    JComboBox cmbAgama = new JComboBox(namaAgama);
    JRadioButton rbL = new JRadioButton(" L ");
    JRadioButton rbP = new JRadioButton(" P ");
    JLabel lAlamat = new JLabel(" Alamat ");
    final JTextArea fAlamat = new JTextArea(10,30);
    JButton btnEdit = new JButton("Edit");
    JButton btnSave = new JButton("Save");

    public Biodata(){
        setTitle("Tugas PBO 4");
        setDefaultCloseOperation(3);
        setSize(300,700);
        setLocation(520,30);
        
        lGambar = new JLabel (new ImageIcon(getClass().getResource(("image.jpg"))));
        
        lJudul.setFont(new Font("Arial", Font.BOLD, 20));
        lNama.setFont(new Font("Arial", Font.BOLD, 16));
        lTtl.setFont(new Font("Arial", Font.PLAIN, 14));
         
        JScrollPane scrollpane = new JScrollPane(fAlamat);
        /*untuk secara otomatis berganti baris
        fAlamat.setLineWrap(true);
        fAlamat.setWrapStyleWord(true);*/
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbL);
        group.add(rbP);
        
        setLayout(null);
        add(lJudul);
        add(lGambar);
        add(lNama);
        add(lTtl);
        add(cmbAgama);
        add(rbL);
        add(rbP);
        add(lAlamat);
        add(scrollpane);
        add(btnEdit);
        add(btnSave);
        
        lJudul.setBounds(70,10,150,20);
        lGambar.setBounds(66,50,150,225);
        lNama.setBounds(42,300,200,20);
        lTtl.setBounds(73,340,150,20);
        cmbAgama.setBounds(42,380,200,20);
        rbL.setBounds(80,420,40,20);
        rbP.setBounds(170,420,40,20);
        lAlamat.setBounds(120,465,90,20);
        scrollpane.setBounds(42,490,200,100);
        btnEdit.setBounds(42,600,80,20);
        btnSave.setBounds(162,600,80,20);
        setVisible(true);
    }
}
