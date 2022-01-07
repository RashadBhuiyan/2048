package src;

import src.GridT;
import src.TileT;
import src.Direction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @file: GameInterface.java
 * @Author: Rashad Ahmed Bhuiyan - bhuiyr2
 * @Date: 2021-04-12
 * @Description: defines the view and controller module that will run 2048.
 */
public class GameInterface extends JPanel implements KeyListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    GridT game = new GridT();
    static GameInterface start = new GameInterface();
    static JFrame frame = new JFrame("2048");
    static Color green;
    String gameString = game.toString();

    /**
     * @brief public static instance method to set up the frame that will contain the GridT object
     */
    public static void setUpGUI()
    {
        frame.addKeyListener(start);
        frame.getContentPane().add(start);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * @brief public instance method overridden to take in specific keyboard input for specific tasks
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
        {
            game.moveUp();
            game.genRandomTile();
            gameString = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            game.moveDown();
            game.genRandomTile();
            gameString = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            game.moveLeft();
            game.genRandomTile();
            gameString = game.toString();
            frame.repaint();
        }
        else if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            game.moveRight();
            game.genRandomTile();
            gameString = game.toString();
            frame.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            game = new GridT();
            game.genRandomTile();
            game.genRandomTile();
            frame.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * @brief public instance method overridden to take in specific keyboard input for specific tasks
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        // Not Used
    }

    /**
     * @brief public instance method overridden to take in specific keyboard input for specific tasks
     */
    @Override
    public void keyTyped(KeyEvent e)
    {
        // Not Used
    }

    /**
     * @brief public instance method used to paint and repaint the frame so that the game functions accordingly
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString("2048", 250, 20);
        g2.drawString("Score: " + game.getScore(),
            200 - 4 * String.valueOf(game.getScore()).length(),
            40);
        g2.drawString("Press 'Enter' to Start, 'Esc' to Leave", 180, 315);
        g2.drawString("Use 'wasd' or Arrow Keys to move", 180, 335);
        if (game.checkRestart())
        {
            g2.drawString("Press 'Enter' to restart", 200, 355);
        }
        g2.setColor(Color.gray);
        g2.fillRect(140, 50, 250, 250);
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                drawTiles(g, game.gridState[i][j], j * 60 + 150, i * 60 + 60);
            }
        }
        if (game.checkGameOver())
        {
            g2.setColor(Color.gray);
            g2.fillRect(140, 50, 250, 250);
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    g2.setColor(Color.RED);
                    g2.fillRoundRect(j * 60 + 150, i * 60 + 60, 50, 50, 5, 5);
                    g2.setColor(Color.black);
                    g.drawString("GAME", j * 60 + 160, i * 60 + 75);
                    g.drawString("OVER", j * 60 + 160, i * 60 + 95);
                }
            }
        }
    }

    /**
     * @brief public instance method used to paint and repaint the TileT objects in the GridT object for the game
     */
    public void drawTiles(Graphics g, TileT tile, int x, int y)
    {
        int tileValue = tile.getValue();
        int length = String.valueOf(tileValue).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.lightGray);
        g2.fillRoundRect(x, y, 50, 50, 5, 5);
        g2.setColor(Color.black);
        if (tileValue > 0)
        {
            g2.setColor(tile.getColour());
            g2.fillRoundRect(x, y, 50, 50, 5, 5);
            g2.setColor(Color.black);
            g.drawString("" + tileValue, x + 25 - 3 * length, y + 25);
        }
    }

    /**
     * @brief public static main method that acts as the driver for the program
     */
    public static void main(String[] args)
    {
        setUpGUI();
    }

}
