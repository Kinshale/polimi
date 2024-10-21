package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    // 20 x 20 grid
    private static final int B_WIDTH = 600;
    private static final int B_HEIGHT = 600;
    private static final int DOT_SIZE = 30;
    private static final int GRID_DIM = 20;
    private static final int PACE = 400;

    private boolean[][] grid = new boolean[GRID_DIM][GRID_DIM];
    private SnakeQueue mySnake = new SnakeQueue();

    private boolean isGameOver = false;
    private String direction = "";

    private int[] anan_pos = { 15, 15 };
    private boolean isStomachEmpty = true;

    private Image head_img;
    private Image body_img;
    private Image ananas_img;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new ArrowAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImages();
        initGame();
    }

    private void loadImages() {
        ImageIcon ii_rs = new ImageIcon("src/resources/redsquare.png");
        head_img = ii_rs.getImage();

        ImageIcon ii_gs = new ImageIcon("src/resources/greensquare.png");
        body_img = ii_gs.getImage();

        ImageIcon ii_an = new ImageIcon("src/resources/ananas.png");
        ananas_img = ii_an.getImage();
    }

    private void initGame() {
        for (int i = 0; i < 3; i++) {
            mySnake.enqueue(5 + i, 15);
            grid[5 + i][15] = true;
        }

        direction = "right";

        Timer timer = new Timer(PACE, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move(); // Also check if Game is ended.
        if (!isGameOver)
            checkAnanas();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isGameOver) {
            gameOver(g);
        } else {
            gameRunning(g);
        }
    }

    // Should iterate over the SnakeQueue, however I'm not able to.
    private void gameRunning(Graphics g) {
        g.drawImage(ananas_img, anan_pos[0] * DOT_SIZE, anan_pos[1] * DOT_SIZE, DOT_SIZE, DOT_SIZE, this);

        Node<int[]> head = mySnake.head();  // Start at the head
        g.drawImage(head_img, head.x * DOT_SIZE, head.y * DOT_SIZE, DOT_SIZE, DOT_SIZE, this);
       
        Node<int[]> temp = mySnake.tail();

        while (temp != head) {
            g.drawImage(body_img, temp.x * DOT_SIZE, temp.y * DOT_SIZE, DOT_SIZE, DOT_SIZE, this);
            temp = temp.next;            
        }       

        Toolkit.getDefaultToolkit().sync();
    }

    private void gameOver(Graphics g) {
        String message = "Game Over";
        g.setColor(Color.CYAN);
        g.drawString(message, 100, 100);
    }

    private void move() {
        Node<int[]> head = mySnake.head();

        switch (direction) {
            case "left":
                mySnake.enqueue(head.x - 1, head.y);
                break;
            case "right":
                mySnake.enqueue(head.x + 1, head.y);
                break;
            case "down":
                mySnake.enqueue(head.x, head.y + 1);
                break;
            case "up":
                mySnake.enqueue(head.x, head.y - 1);
                break;
        }

        if (checkCollision()) {
            isGameOver = true;
            return;
        }

        grid[mySnake.head().x][mySnake.head().y] = true;

        if (isStomachEmpty) {
            grid[mySnake.tail().x][mySnake.tail().y] = false;
            mySnake.dequeue();
        } else {
            isStomachEmpty = true;
        }
    }

    private boolean checkCollision() {
        Node<int[]> head = mySnake.head();

        return grid[head.x][head.y] || (head.x < 0 || head.x >= GRID_DIM || head.y < 0 || head.y >= GRID_DIM);
    }

    private void locateAnanas() {
        do {
            anan_pos[0] = (int) (Math.random() * GRID_DIM);
            anan_pos[1] = (int) (Math.random() * GRID_DIM);
        } while (grid[anan_pos[0]][anan_pos[1]]);
    }

    private void checkAnanas() {
        if (anan_pos[0] == mySnake.head().x && anan_pos[1] == mySnake.head().y) {
            isStomachEmpty = false;
            locateAnanas();
        }
    }

    private class ArrowAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT && direction != "right") {
                direction = "left";
            } else if (keyCode == KeyEvent.VK_RIGHT && direction != "left") {
                direction = "right";
            } else if (keyCode == KeyEvent.VK_DOWN && direction != "up") {
                direction = "down";
            } else if (keyCode == KeyEvent.VK_UP && direction != "down") {
                direction = "up";
            }

        }
    }
}
