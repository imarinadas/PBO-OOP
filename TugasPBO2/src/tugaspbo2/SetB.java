
package tugaspbo2;

public class SetB extends Rewards{
    SetB(){
        poin += 6;
        setrewards(3);
    }
    
    @Override
    void poinplus(){
        poin += 3;
        System.out.println("Poin tambah tiap kunjungan");
    }
}
