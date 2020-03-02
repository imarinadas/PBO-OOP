/*Tugas 3 : Exception
  Praktikum Pemrograman Berorientasi Objek Plug B
  Nada Salsabila Imari
  123180126
*/

package praktikumpbo;

public class LimasSegitiga {
    double vol(double a_alas, double t_alas, double t_limas) {
        return a_alas*t_alas*t_limas/6;
    }
    
    double lp(double a_alas, double t_alas, double a_sisi1, double t_sisi1, double a_sisi2, double t_sisi2, double a_sisi3, double t_sisi3) {
        return (a_alas*t_alas/2)+(a_sisi1*t_sisi1/2)+(a_sisi2*t_sisi2/2)+(a_sisi3*t_sisi3/2);
    }
}
