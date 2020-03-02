/*Tugas 3 : Exception
  Praktikum Pemrograman Berorientasi Objek Plug B
  Nada Salsabila Imari
  123180126
*/

package praktikumpbo;

import java.util.Scanner;
import java.util.InputMismatchException;
//import java.util.

public class PraktikumPBO extends Exception{
    
    PraktikumPBO(){ }
    PraktikumPBO(String str){ super(str);}
    
    public static void main(String[] args) throws PraktikumPBO {
        Scanner masukan = new Scanner(System.in);
        char lanjut = 'y';
         
        do{
            System.out.println("PILIHAN");
            System.out.println("1. Balok");
            System.out.println("2. Kerucut");
            System.out.println("3. Limas Segitiga");
            
            System.out.print("Masukkan Pilihan : ");
            int pilihan = masukan.nextInt();
            System.out.println(" ");

            switch(pilihan){
                case 1 :
                    try{
                        System.out.println("BALOK");
                        System.out.print("Masukkan Panjang : ");
                        double p = masukan.nextDouble();
                        System.out.print("Masukkan Lebar : ");
                        double l = masukan.nextDouble();
                        System.out.print("Masukkan Tinggi : ");
                        double t_balok = masukan.nextDouble();
                        Balok balok = new Balok();
                                double vol_balok = balok.vol(p, l, t_balok);
                                System.out.println("Volume = " + vol_balok);
                                double lp_balok = balok.lp(p, l, t_balok);
                                System.out.println("Luas Permukaan = " + lp_balok);
                                             
                    }catch(InputMismatchException ime){
                        ime.printStackTrace();
                        System.out.println(ime + " // Error! Input Harus Angka");
                        masukan.next();
                    }finally{
                        System.out.println("Semoga Harimu Menyenangkan <3");
                    }
                    break;

                case 2 :
                    try{
                        System.out.println("KERUCUT");
                        System.out.print("Masukkan Jari-jari Alas : ");
                        double r = masukan.nextDouble();
                        System.out.print("Masukkan Tinggi : ");
                        double t_kerucut = masukan.nextDouble();
                        System.out.print("Masukkan Sisi Miring : ");
                        double s = masukan.nextDouble();
                        Kerucut kerucut = new Kerucut();
                                double vol_kerucut = kerucut.vol(r, t_kerucut);
                                System.out.println("Volume = " + vol_kerucut);
                                double lp_kerucut = kerucut.lp(r, s);
                                System.out.println("Luas Permukaan = " + lp_kerucut);
                                double kel_alas = kerucut.alas(r);
                        
                        if(kel_alas < 30){
                            PraktikumPBO e = new PraktikumPBO("Kerucutnya lumayan kecil");
                            throw e;
                        }
                        else{
                            System.out.println("Kerucutnya bisa dipakai menjadi topi");
                        }
                    }catch(PraktikumPBO p){
                        p.printStackTrace();
                    }catch(Exception ee){
                        ee.printStackTrace();
                        System.out.println(ee.toString() + " // Error! Pastikan Input Angka");
                        masukan.next();
                    }finally{
                        System.out.println("Selalu semangat!!");
                    }
                    break;

                case 3 :
                    try{
                        System.out.println("LIMAS SEGITIGA");
                        System.out.print("Masukkan Tinggi Limas : ");
                        double t_limas = masukan.nextDouble();
                        System.out.print("Masukkan Tinggi Segitiga Alas : ");
                        double t_alas = masukan.nextDouble();
                        System.out.print("Masukkan Alas Segitiga Alas : ");
                        double a_alas = masukan.nextDouble();
                        LimasSegitiga limas = new LimasSegitiga();
                        double vol_limas = limas.vol(a_alas, t_alas, t_limas);
                        double lp_limas = 0;
                        
                        System.out.println(" ");
                        System.out.println("Syarat Limas dapat dihitung luas permukaannya perlu diketahui");
                        System.out.println("a. Bentuk alasnya");
                        System.out.println("b. Panjang sisi-sisi alas yang diperlukan, dan");
                        System.out.println("c. Tinggi segitiga pada selimut limas / panjang sisi tegak.");
                        System.out.print("Segitiga Diketahui Memenuhi Syarat? (y/n) = ");
                        char lagilimas = masukan.next().charAt(0);
                        
                        System.out.println(" ");
                        if(lagilimas == 'y' || lagilimas == 'Y'){
                            /*ukuran semua sisi limas diinput
                              agar mempermudah menghitung luas permukaan limas segitiga
                              dengan alas segitiga sembarang*/
                            System.out.print("Masukkan Tinggi Segitiga Sisi 1 : ");
                            double t_sisi1 = masukan.nextDouble();
                            System.out.print("Masukkan Alas Segitiga Sisi 1 : ");
                            double a_sisi1 = masukan.nextDouble();
                            System.out.print("Masukkan Tinggi Segitiga Sisi 2 : ");
                            double t_sisi2 = masukan.nextDouble();
                            System.out.print("Masukkan Alas Segitiga Sisi 2 : ");
                            double a_sisi2 = masukan.nextDouble();
                            System.out.print("Masukkan Tinggi Segitiga Sisi 3 : ");
                            double t_sisi3 = masukan.nextDouble();
                            System.out.print("Masukkan Alas Segitiga Sisi 3 : ");
                            double a_sisi3 = masukan.nextDouble();
                            lp_limas = limas.lp(a_alas, t_alas, a_sisi1, t_sisi1, a_sisi2, t_sisi2, a_sisi3, t_sisi3);
                            System.out.println("Volume = " + vol_limas);
                            System.out.println("Volume = " + lp_limas);
                        }
                        
                        else{
                            System.out.println("Volume = " + vol_limas);
                            System.out.println("Volume = " + lp_limas);
                            PraktikumPBO me = new PraktikumPBO("Limas Segitiga tidak memenuhi syarat");
                            throw me;
                        }
                    }catch(PraktikumPBO pp){
                        pp.printStackTrace();
                    }catch(InputMismatchException ime){
                        ime.printStackTrace();
                        System.out.println(ime + " // Error! Input Harus Angka");
                        masukan.next();
                    }finally{
                        System.out.println("Semoga Selalu Bahagia :)");
                    }
                    break;

                default :
                    System.out.println("Pilihan Tidak Tersedia");
                    break;
            }System.out.print("Ulangi ? (y/n) = ");
            char lagi = masukan.next().charAt(0);
            lanjut = lagi;
            System.out.println(" ");
        }while(lanjut == 'y');
    }
}
