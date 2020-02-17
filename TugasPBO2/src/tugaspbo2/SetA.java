
package tugaspbo2;

public class SetA extends Rewards{
    SetA(){
        poin += 4;
        setrewards(2);
    }
   
    @Override
    void poinplus(){
        poin += 2;
        System.out.println("Poin tambah tiap kunjungan");
    }
}
