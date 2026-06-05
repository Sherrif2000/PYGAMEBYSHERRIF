import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel implements KeyListener {
    private int px = 5;
    private int py = 5;
    private final int block = 32;
    private final int[][] world = new int[20][15];

    public Main() {
        setPreferredSize(new Dimension(640, 480));
        setFocusable(true);
        addKeyListener(this);

        for (int x = 0; x < world.length; x++) {
            world[x][14] = 1;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[0].length; y++) {
                if (world[x][y] == 1) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * block, y * block, block, block);
                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillRect(px * block, py * block, block, block);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> px--;
            case KeyEvent.VK_D -> px++;
            case KeyEvent.VK_W -> py--;
            case KeyEvent.VK_S -> py++;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Minecraft Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}