
package tugaspbo2;

public class Rewards extends Identitas{
    double poin;
    private double rewards;
    
    public void identitas(){
        System.out.println("Nama : " + this.nama);
        System.out.println("Jenis : " + this.jenis);
    }
    
    Rewards(){
        poin = 1;
        rewards = 1;
            System.out.println("POIN PERTAMA DAFTAR " + poin + " & REWARDS STANDAR " + rewards);
    }
    
    private double hitungpoin(double poin, double rewards){
        return poin * rewards;
    }
    void poinplus(){
        
    }
    
    void setrewards(double rewards){
        this.rewards = rewards;
    }
    
    double gettotalpoin(){
        return hitungpoin(poin, rewards);
    }
}
