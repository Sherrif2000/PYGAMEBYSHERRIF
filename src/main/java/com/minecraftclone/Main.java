package com.minecraftclone;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel implements Runnable {

    private boolean running = true;
    private int x = 100;

    public Main() {
        setPreferredSize(new Dimension(1280, 720));
        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Minecraft Clone - Phase 1", 20, 20);
        g.fillRect(x, 200, 50, 50);
    }

    @Override
    public void run() {
        while (running) {
            x++;
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minecraft Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}