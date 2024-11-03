package code;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {
    public Snake() {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setResizable(false);
        pack();

        setTitle("Minimalistic Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        System.out.println("Game started");
        JFrame win = new Snake();
        win.setVisible(true);
    }
}