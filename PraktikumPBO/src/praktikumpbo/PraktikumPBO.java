package praktikumpbo;

import java.util.Scanner;

public class PraktikumPBO {

    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        char lanjut = 'y';
        do{
            System.out.println("PILIHAN");
            System.out.println("1. Balok");
            System.out.println("2. Kerucut");
            System.out.println("3. Limas Segitiga");
            
            System.out.print("Masukkan Pilihan : ");
            int pilihan = masukan.nextInt();

            switch(pilihan){
                case 1 :
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
                    break;

                case 2 :
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
                    break;

                case 3 :
                    System.out.println("LIMAS SEGITIGA");
                    System.out.print("Masukkan Tinggi Limas : ");
                    double t_limas = masukan.nextDouble();
                    System.out.print("Masukkan Tinggi Segitiga Alas : ");
                    double t_alas = masukan.nextDouble();
                    System.out.print("Masukkan Alas Segitiga Alas : ");
                    double a_alas = masukan.nextDouble();
                   
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
                    
                    LimasSegitiga limas = new LimasSegitiga();
                            double vol_limas = limas.vol(a_alas, t_alas, t_limas);
                            System.out.println("Volume = " + vol_limas);
                            double lp_limas = limas.lp(a_alas, t_alas, a_sisi1, t_sisi1, a_sisi2, t_sisi2, a_sisi3, t_sisi3);
                            System.out.println("Volume = " + lp_limas);
                    break;

                default :
                    System.out.println("Pilihan Tidak Tersedia");
                    break;
            }System.out.println("Lanjutkan ? (y/n) = ");
            char lagi = masukan.next().charAt(0);
            lanjut = lagi;
        }while(lanjut == 'y');
    }
}
