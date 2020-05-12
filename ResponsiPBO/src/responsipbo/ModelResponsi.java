/*
 * Praktikum PBO plug B
 * 123180126
 * Nada Salsabila Imari
 */

package responsipbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelResponsi {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsipbo";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelResponsi(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Terhubung");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Gagal");
        }
    }
    
    public void insertPegawai(String id, String nama, String posisi, String alamat, String hp, String gaji, String lembur, String tunjangan, String pajak, String total){
        try{
            String query = "INSERT INTO `pegawai` (`id`, `nama`, `posisi`, `alamat`, `hp`, `gaji`, `lembur`, `tunjangan`, `pajak`, `total`)"
                    + "VALUES ('"+id+"', '"+nama+"', '"+posisi+"','"+alamat+"', '"+hp+"', '"+gaji+"', '"+lembur+"', '"+tunjangan+"', '"+pajak+"', '"+total+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Anggota Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Pegawai Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readPegawai(){
        try{
            int jmlData = 0;
            String pegawai[][] = new String[getBanyakDataPegawai()][10];
            String query = "SELECT * FROM `pegawai`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                pegawai[jmlData][0] = resultSet.getString("id");
                pegawai[jmlData][1] = resultSet.getString("nama");
                pegawai[jmlData][2] = resultSet.getString("posisi");
                pegawai[jmlData][3] = resultSet.getString("alamat");
                pegawai[jmlData][4] = resultSet.getString("hp");
                pegawai[jmlData][5] = resultSet.getString("gaji");
                pegawai[jmlData][6] = resultSet.getString("lembur");
                pegawai[jmlData][7] = resultSet.getString("tunjangan");
                pegawai[jmlData][8] = resultSet.getString("pajak");
                pegawai[jmlData][9] = resultSet.getString("total");
                jmlData++;
            }
            return pegawai;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakDataPegawai(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `pegawai`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deletePegawai(String id){
        try{
            String query = "DELETE FROM `pegawai` WHERE `id` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Pegawai Terhapus");
            JOptionPane.showMessageDialog(null, "Data Pegawai Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedPegawai(String cari){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `pegawai` WHERE `id` LIKE '%"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] readsearchedPegawai(String cari){
        try{
            int jmlData = 0;
            String pegawai[][] = new String[getSearchedPegawai(cari)][10];
            String query = "SELECT *  FROM `pegawai` WHERE `id` LIKE '%"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                pegawai[jmlData][0] = resultSet.getString("id");
                pegawai[jmlData][1] = resultSet.getString("nama");
                pegawai[jmlData][2] = resultSet.getString("posisi");
                pegawai[jmlData][3] = resultSet.getString("alamat");
                pegawai[jmlData][4] = resultSet.getString("hp");
                pegawai[jmlData][5] = resultSet.getString("gaji");
                pegawai[jmlData][6] = resultSet.getString("lembur");
                pegawai[jmlData][7] = resultSet.getString("tunjangan");
                pegawai[jmlData][8] = resultSet.getString("pajak");
                pegawai[jmlData][9] = resultSet.getString("total");
                jmlData++;
            }
            return pegawai;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int cariAdmin(String username){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `admin` WHERE `username` LIKE '%"+username+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
        public String[][] bacaloginAdmin(String username){
        try{
            int jmlData = 0;
            String admin[][] = new String[cariAdmin(username)][2];
            String query = "SELECT *  FROM `admin` WHERE `username` LIKE '%"+username+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                admin[jmlData][0] = resultSet.getString("username");
                admin[jmlData][1] = resultSet.getString("password");
                jmlData++;
            }
            return admin;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
        
    public void updatePegawai(String id, String nama, String posisi, String alamat, String hp, String gaji, String lembur, String tunjangan, String pajak, String total){
        try{
            String query = "UPDATE `pegawai` SET `id` = '"+id+"', `nama` = '"+nama+"', `posisi` = '"+posisi+"',"
                    + " `alamat` = '"+alamat+"', `hp` = '"+hp+"', `gaji` = '"+gaji+"', `lembur` = '"+lembur+"',"
                    + " `tunjangan` = '"+tunjangan+"', `pajak` = '"+pajak+"', `total` = '"+total+"' WHERE `id` = '"+id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Terupdate");
            JOptionPane.showMessageDialog(null, "Data Terupdate");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
