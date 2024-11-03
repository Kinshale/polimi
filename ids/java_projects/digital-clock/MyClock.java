package MyDigitalClock;

import javax.swing.*;

public class MyClock extends JFrame {

    public MyClock(){
        this.setTitle("Beautiful Clock");
        this.setSize(400, 300);
		super.setLocation(700,10);          

		this.setVisible(true);

        double r = Math.pow(3, 5);
        System.out.println(r);

    }
}