package praktikumpbo;

public class Kerucut {
    double pi = 3.14;

    double vol(double r, double t) {
        return pi*r*r*t/3;
    }
    
    double lp(double r, double s) {
        return pi*r*(r+s);
    }
}
