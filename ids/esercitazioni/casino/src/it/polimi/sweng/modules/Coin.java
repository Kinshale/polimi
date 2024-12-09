package it.polimi.sweng.modules;
import java.util.Random;

public class Coin {
    private Side showingSide;
    final private Random generator;
    final private double pHead; 

    public Coin () {
        this.showingSide = null;
        this.generator = new Random();
        this.pHead = 0.5;
    }

    public Coin (double pHead) {
        this.showingSide = null;
        this.generator = new Random();
        this.pHead = pHead;
    }

    public Side toss() {
        if (this.generator.nextDouble() <= pHead){
            this.showingSide = Side.HEAD;
        } else {
            this.showingSide = Side.TAIL;
        }

        return this.showingSide;
    }

    public Side getShowingSide() {
        return this.showingSide;
    }
}