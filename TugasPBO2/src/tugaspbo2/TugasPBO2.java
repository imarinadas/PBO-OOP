/*
 *  Nada Salsabila Imari
 *  123180126
 *  Praktikum Pemrograman Berorientasi Objek
 *  Plug B
 */
package tugaspbo2;

import java.util.Scanner;

public class TugasPBO2 {

    public static void main(String[] args) {
        char lanjut = 'n';
        do{
            int i = 0;
            Rewards R[] = new Rewards[2];
            Scanner input = new Scanner(System.in);

            System.out.println("POIN KEANGGOTAAN PERPUSTAKAAN");
            System.out.println("Input Data");
            System.out.print("Nama        : ");
            String nama = input.nextLine();
            System.out.print("Jenis Keanggotaan (a/b): ");
            char jenis = input.next().charAt(0);

            if (jenis == 'A' || jenis == 'a') {
                    i=0;
                    R[0] = new SetA();
                }
            else if (jenis == 'B' || jenis == 'b') {
                    i=1;
                    R[1] = new SetB();
                }
            else System.out.println("Jenis Keanggotaan tidak valid");
            
            R[i].setJenis(jenis);
            R[i].setNama(nama);
                    
            System.out.println("Output Data");
                System.out.println("Anggota " + R[i].getNama() + ", Jenis Keanggotaan " + R[i].getJenis());
                System.out.println("Poin awal : " + R[i].gettotalpoin());
                R[i].poinplus();
                System.out.println("Poin akhir : " + R[i].gettotalpoin());
            
            System.out.print("Lanjutkan ? (y/n) = ");
                char lagi = input.next().charAt(0);
                lanjut = lagi;
        }while(lanjut == 'y' || lanjut == 'Y');
    }
    
}
