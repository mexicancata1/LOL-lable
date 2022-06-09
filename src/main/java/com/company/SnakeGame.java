package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 20;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    private final Color backgroundColor = Color.pink;
    private final Color borderColor = Color.white;
    private final Color snakeColor = Color.black;
    private final Color appleColor = Color.RED;

    Apple a = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(borderColor);

        for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }

        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }

        for (int d = 0; d < s.length; d++) {
            g.setColor(snakeColor);
            g.fillRect(s.snakeX[d] * SCALE + 1, s.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
        }

        g.setColor(appleColor);
        g.fillRect(a.posX * SCALE + 1, a.posY * SCALE + 1, SCALE - 1, SCALE - 1);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE + 17, HEIGHT * SCALE + 40);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        s.move();

        if ((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
            a.setRandomPosition();
            s.length++;
        }

        for (int k = 1; k < s.length; k++) {
            if ((s.snakeX[k] == a.posX) & (s.snakeY[k] == a.posY)) {
                a.setRandomPosition();
            }
        }

        repaint();
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEve) {
            int key = kEve.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & s.direction != 2) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN) & s.direction != 3) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) & s.direction != 0) s.direction = 2;
            if ((key == KeyEvent.VK_UP) & s.direction != 1) s.direction = 3;
        }
    }
}