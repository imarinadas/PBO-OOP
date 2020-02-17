package praktikumpbo;

public class Balok {
    double vol(double p, double l, double t) {
        return p * l * t;
    }
    
    double lp(double p, double l, double t) {
        return 2 * ((p*l)+(p*t)+(l*t));
    }
}
