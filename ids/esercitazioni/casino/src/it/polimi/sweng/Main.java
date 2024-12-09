package it.polimi.sweng;
import it.polimi.sweng.modules.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Coin c1 = new Coin();    
        Coin c2 = new Coin(0.3);    

        int nHeads = 0;

        for (int i = 0; i < 50; i++){
            c1.toss();
            Side side = c1.getShowingSide();

            if (side == Side.HEAD){
                nHeads++;
            }
        }
        
        System.out.println(CoinFairnessTest.isFair(c1, 0.1));
        System.out.println(CoinFairnessTest.isFair(c2, 0.1));

        System.out.println("We got " + nHeads + " heads, out of 50 throws!");
    }
}
