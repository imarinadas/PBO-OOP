/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */

package tugaspbo6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelData{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tugaspbo6";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelData(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Terhubung");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Gagal");
        }
    }
    
    public void insertData(String judul, String tipe, String episode, String genre, String status, String rating){
        try{
            String query = "INSERT INTO `data` (`Judul`,`Tipe`,`Episode`, `Genre`, `Status`, `Rating`)"
                    + "VALUES ('"+judul+"', '"+tipe+"', '"+episode+"','"+genre+"', '"+status+"', '"+rating+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            int no = 0;
            String film[][] = new String[getBanyakData()][8];
            String query = "SELECT * FROM `Data`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                no++;
                String str = Integer.toString(no);
                film[jmlData][0] = str;
                film[jmlData][1] = resultSet.getString("ID");
                film[jmlData][2] = resultSet.getString("Judul");
                film[jmlData][3] = resultSet.getString("Tipe");
                film[jmlData][4] = resultSet.getString("Episode");
                film[jmlData][5] = resultSet.getString("Genre");
                film[jmlData][6] = resultSet.getString("Status");
                film[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
            }
            return film;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `Data`";
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
    
    public void deleteData(String id){
        try{
            String query = "DELETE FROM `Data` WHERE `ID` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedData(String search){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `Data` WHERE `Judul` LIKE '%"+search+"%'";
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
        
    public String[][] readsearchedData(String search){
        try{
            int jmlData = 0;
            int no = 0;
            String film[][] = new String[getSearchedData(search)][8];
            String query = "SELECT *  FROM `Data` WHERE `Judul` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                no++;
                String str = Integer.toString(no);
                film[jmlData][0] = str;
                film[jmlData][1] = resultSet.getString("ID");
                film[jmlData][2] = resultSet.getString("Judul");
                film[jmlData][3] = resultSet.getString("Tipe");
                film[jmlData][4] = resultSet.getString("Episode");
                film[jmlData][5] = resultSet.getString("Genre");
                film[jmlData][6] = resultSet.getString("Status");
                film[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
            }return film;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void updateData(String id, String judul, String tipe, String episode, String genre, String status, String rating){
        try{
            String query = "UPDATE `Data` SET `Judul` = '"+judul+"', `Tipe` = '"+tipe+"', `Episode` = '"+episode+"',"
                    + " `Genre` = '"+genre+"', `Status` = '"+status+"', `Rating` = '"+rating+"' WHERE `ID` = '"+id+"'";
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