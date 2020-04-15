/*
 * Praktikum PBO Plug B
 * Nada Salsabila Imari
 * 123180126
 */
package kuispbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

public class ModelPerpus {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kuisperpus";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelPerpus(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Terhubung");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Gagal");
        }
    }
    
    public void insertAnggota(String nis, String nmsiswa, String ttl, String jk, String agama, String tdaftar, String berlaku, String kelas){
        String tanggalLahir = ttl;
        String tanggalDaftar = tdaftar;
        String berlakuHingga = berlaku;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(tanggalLahir, formatter);
        LocalDate date2 = LocalDate.parse(tanggalDaftar, formatter);
        LocalDate date3 = LocalDate.parse(berlakuHingga, formatter);
        
        try{
            String query = "INSERT INTO `anggota` (`nis`, `nmsiswa`, `ttl`, `jk`, `agama`, `tdaftar`, `berlaku`, `kelas`)"
                    + "VALUES ('"+nis+"', '"+nmsiswa+"', '"+date1+"','"+jk+"', '"+agama+"', '"+date2+"', '"+date3+"', '"+kelas+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Anggota Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Anggota Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void insertBuku(String kdbuku, String nmbuku, String nmpengarang, String nmpenerbit, String thnterbit){
        try{
            String query = "INSERT INTO `buku` (`kdbuku`,`nmbuku`,`nmpengarang`, `nmpenerbit`, `thnterbit`)"
                    + "VALUES ('"+kdbuku+"', '"+nmbuku+"', '"+nmpengarang+"','"+nmpenerbit+"', '"+thnterbit+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Buku Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Buku Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void insertKaryawan(String nik, String nmkaryawan, String jk, String golongan, String jabatan, String tunjangan, String jmlgaji){
        try{
            String query = "INSERT INTO `karyawan` (`nik`,`nmkaryawan`,`jk`, `golongan`, `jabatan`, `tunjangan`, `jmlgaji`)"
                    + "VALUES ('"+nik+"', '"+nmkaryawan+"', '"+jk+"','"+golongan+"', '"+jabatan+"', '"+tunjangan+"', '"+jmlgaji+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Karyawan Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Karyawan Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void insertPeminjaman(String nopinjam, String nis, String kdbuku, String tglpinjam, String tglkembali, String nik){
            String tanggalpinjam = tglpinjam;
            String tanggalkembali = tglkembali;
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
            LocalDate date1 = LocalDate.parse(tanggalpinjam, formatter);
            LocalDate date2 = LocalDate.parse(tanggalkembali, formatter);
            Period diff = Period.between(date1, date2);
            
            int denda;
            int lmpinjam = diff.getDays();
            if(lmpinjam>7){
                denda = (lmpinjam-7)*1000;
            }else{
                denda = 0;
            }
        try{      
            String query = "INSERT INTO `peminjaman` (`nopinjam`, `nis`, `kdbuku`, `tglpinjam`, `tglkembali`, `lmpinjam`, `denda`, `nik`)"
                    + "VALUES ('"+nopinjam+"', '"+nis+"', '"+kdbuku+"', '"+date1+"', '"+date2+"', '"+lmpinjam+"', '"+denda+"', '"+nik+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Peminjaman Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Peminjaman Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readAnggota(){
        try{
            int jmlData = 0;
            String anggota[][] = new String[getBanyakDataAnggota()][8];
            String query = "SELECT * FROM `anggota`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                anggota[jmlData][0] = resultSet.getString("nis");
                anggota[jmlData][1] = resultSet.getString("nmsiswa");
                anggota[jmlData][2] = resultSet.getString("ttl");
                anggota[jmlData][3] = resultSet.getString("jk");
                anggota[jmlData][4] = resultSet.getString("agama");
                anggota[jmlData][5] = resultSet.getString("tdaftar");
                anggota[jmlData][6] = resultSet.getString("berlaku");
                anggota[jmlData][7] = resultSet.getString("kelas");
                jmlData++;
            }
            return anggota;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] readBuku(){
        try{
            int jmlData = 0;
            String buku[][] = new String[getBanyakDataBuku()][5];
            String query = "SELECT * FROM `buku`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                buku[jmlData][0] = resultSet.getString("kdbuku");
                buku[jmlData][1] = resultSet.getString("nmbuku");
                buku[jmlData][2] = resultSet.getString("nmpengarang");
                buku[jmlData][3] = resultSet.getString("nmpenerbit");
                buku[jmlData][4] = resultSet.getString("thnterbit");
                jmlData++;
            }
            return buku;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] readKaryawan(){
        try{
            int jmlData = 0;
            String karyawan[][] = new String[getBanyakDataKaryawan()][7];
            String query = "SELECT * FROM `karyawan`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                karyawan[jmlData][0] = resultSet.getString("nik");
                karyawan[jmlData][1] = resultSet.getString("nmkaryawan");
                karyawan[jmlData][2] = resultSet.getString("jk");
                karyawan[jmlData][3] = resultSet.getString("golongan");
                karyawan[jmlData][4] = resultSet.getString("jabatan");
                karyawan[jmlData][5] = resultSet.getString("tunjangan");
                karyawan[jmlData][6] = resultSet.getString("jmlgaji");
                jmlData++;
            }
            return karyawan;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] readPeminjaman(){
        try{
            int jmlData = 0;
            String peminjaman[][] = new String[getBanyakDataPeminjaman()][13];
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`nis` = `anggota`.`nis` JOIN `buku` ON `peminjaman`.`kdbuku` = `buku`.`kdbuku` JOIN `karyawan` ON `peminjaman`.`nik` = `karyawan`.`nik`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                peminjaman[jmlData][0] = resultSet.getString("nopoinjam");
                peminjaman[jmlData][1] = resultSet.getString("nis");
                peminjaman[jmlData][2] = resultSet.getString("nmsiswa");
                peminjaman[jmlData][3] = resultSet.getString("kelas");
                peminjaman[jmlData][4] = resultSet.getString("kdbuku");
                peminjaman[jmlData][5] = resultSet.getString("nmbuku");
                peminjaman[jmlData][6] = resultSet.getString("nmpenerbit");
                peminjaman[jmlData][7] = resultSet.getString("tglpinjam");
                peminjaman[jmlData][8] = resultSet.getString("tglkembali");
                peminjaman[jmlData][9] = resultSet.getString("lmpinjam");
                peminjaman[jmlData][10] = resultSet.getString("denda");
                peminjaman[jmlData][11] = resultSet.getString("nik");
                peminjaman[jmlData][12] = resultSet.getString("nmkaryawan");
                jmlData++;
            }
            return peminjaman;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakDataAnggota(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `anggota`";
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
    
     public int getBanyakDataBuku(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `buku`";
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
     
     public int getBanyakDataKaryawan(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `karyawan`";
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
     
    public int getBanyakDataPeminjaman(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `peminjaman`";
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
    
    public void deleteAnggota(String nis){
        try{
            String query = "DELETE FROM `anggota` WHERE `nis` = '"+nis+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Anggota Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
     public void deleteBuku(String kdbuku){
        try{
            String query = "DELETE FROM `buku` WHERE `kdbuku` = '"+kdbuku+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Buku Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public void deleteKaryawan(String nik){
        try{
            String query = "DELETE FROM `karyawan` WHERE `nik` = '"+nik+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Karyawan Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public void deletePeminjaman(String nopinjam){
        try{
            String query = "DELETE FROM `peminjaman` WHERE `nopinjam` = '"+nopinjam+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Peminjaman Terhapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

        public int getSearchedBuku(String search){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `buku` WHERE `kdbuku` LIKE '%"+search+"%'";
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
        
    public String[][] readsearchedBuku(String search){
        try{
            int jmlData = 0;
            String buku[][] = new String[getSearchedBuku(search)][5];
            String query = "SELECT *  FROM `buku` WHERE `kdbuku` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                buku[jmlData][0] = resultSet.getString("kdbuku");
                buku[jmlData][1] = resultSet.getString("nmbuku");
                buku[jmlData][2] = resultSet.getString("nmpengarang");
                buku[jmlData][3] = resultSet.getString("nmpenerbit");
                buku[jmlData][4] = resultSet.getString("thnterbit");
                jmlData++;
            }
            return buku;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getSearchedKaryawan(String search){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `karyawan` WHERE `nik` LIKE '%"+search+"%'";
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
        
    public String[][] readsearchedKaryawan(String search){
        try{
            int jmlData = 0;
            String karyawan[][] = new String[getSearchedKaryawan(search)][8];
            String query = "SELECT *  FROM `karyawan` WHERE `nik` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                karyawan[jmlData][0] = resultSet.getString("nik");
                karyawan[jmlData][1] = resultSet.getString("nmkaryawan");
                karyawan[jmlData][2] = resultSet.getString("jk");
                karyawan[jmlData][3] = resultSet.getString("golongan");
                karyawan[jmlData][4] = resultSet.getString("jabatan");
                karyawan[jmlData][5] = resultSet.getString("tunjangan");
                karyawan[jmlData][6] = resultSet.getString("jmlgaji");
                jmlData++;
            }
            return karyawan;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getSearchedPeminjaman(String search){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT *  FROM `peminjaman` WHERE `nopinjam` LIKE '%"+search+"%'";
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
        
    public String[][] readsearchedPeminjaman(String search){
        try{
            int jmlData = 0;
            String peminjaman[][] = new String[getSearchedKaryawan(search)][13];
            String query = "SELECT *  FROM `peminjaman` WHERE `nopinjam` LIKE '%"+search+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                peminjaman[jmlData][0] = resultSet.getString("nopoinjam");
                peminjaman[jmlData][1] = resultSet.getString("nis");
                peminjaman[jmlData][2] = resultSet.getString("nmsiswa");
                peminjaman[jmlData][3] = resultSet.getString("kelas");
                peminjaman[jmlData][4] = resultSet.getString("kdbuku");
                peminjaman[jmlData][5] = resultSet.getString("nmbuku");
                peminjaman[jmlData][6] = resultSet.getString("nmpenerbit");
                peminjaman[jmlData][7] = resultSet.getString("tglpinjam");
                peminjaman[jmlData][8] = resultSet.getString("tglkembali");
                peminjaman[jmlData][9] = resultSet.getString("lmpinjam");
                peminjaman[jmlData][10] = resultSet.getString("denda");
                peminjaman[jmlData][11] = resultSet.getString("nik");
                peminjaman[jmlData][12] = resultSet.getString("nmkaryawan");
                jmlData++;
            }
            return peminjaman;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
