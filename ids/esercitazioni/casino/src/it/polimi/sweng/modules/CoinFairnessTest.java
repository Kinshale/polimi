package it.polimi.sweng.modules;

public class CoinFairnessTest {
    private final static int trials = 1000;
    
    public static boolean isFair (Coin c, double tolerance){
        
        int nHeads = 0;

        for (int i = 0; i < trials; i++){
            c.toss();
            if (c.getShowingSide() == Side.HEAD)
                nHeads++;
        }

        
        double p = (double) nHeads / trials;
        return ( p <= (0.5 + tolerance / 2) && p >= (0.5 - tolerance / 2));

    }
}
