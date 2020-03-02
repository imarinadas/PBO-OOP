/*Tugas 3 : Exception
  Praktikum Pemrograman Berorientasi Objek Plug B
  Nada Salsabila Imari
  123180126
*/

package praktikumpbo;

public class Kerucut {
    double pi = 3.14;

    double vol(double r, double t) {
        return pi*r*r*t/3;
    }
    
    double lp(double r, double s) {
        return pi*r*(r+s);
    }
    
    double alas(double r){
        return 2*pi*r;
    }
}
