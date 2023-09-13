package com.company;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;

/*********************************************************************************


 ***********************************************************************************/
public class ManyBallsComplete extends JFrame {
    // DATA:
    private static Ball[] bouncingBalls;                            // Our moving ball

    private static final int MAX_WIDTH = 1000;        // Window size
    private static final int MAX_HEIGHT = 800;        // Window size
    private static final int TOP_OF_WINDOW = 22;    // Top of the visible window
    private static final int NUM_BALLS = 100;
    private static final Color BACKGROUND_COLOR = Color.white;

    // METHODS:

    /**
     * main -- Start up the window.
     *
     * @param    args
     */
    public static void main(String args[]) {
        // Create the window.
        ManyBallsComplete mbc = new ManyBallsComplete();
    }

    /**
     * ManyBalls constructor: create the one Ball and simulate the "clock"
     */
    public ManyBallsComplete() {
        Random gen = new Random();
        bouncingBalls = new Ball[NUM_BALLS];

        for (int i = 0; i < NUM_BALLS; i++) {
            int radius = gen.nextInt(16) + 5; // radius = 5 to 20
            int xPos = gen.nextInt(MAX_WIDTH);
            int yPos = gen.nextInt(MAX_HEIGHT);
            int deltaX = gen.nextInt(11) - 5; // -5 to +5
            int deltaY = gen.nextInt(11) - 5;

            Color randomColor = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));

            bouncingBalls[i] = new Ball(xPos, yPos, deltaX, deltaY, radius, randomColor);

        }


        // Show the window with the ball in its initial position.
        //	Note that these are called without the mb. in front.
        //	We'll discuss why in class.
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setVisible(true);

        // Simulate the passing of time by reading console input.
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println("Hit return to move.");
            String timeTick = console.nextLine();

            // Perform whatever actions are needed at each time tick.
            actionPerformed();
        }
    }

    /**
     * actionPerformed -- Move the ball every time the "timer" goes off.
     * Note that all of the action that we want to happen every time the timer
     * goes off goes in this method.
     */
    private void actionPerformed() {
        // Move the ballS.
        for (int j = 0; j < NUM_BALLS; j++) {
            bouncingBalls[j].move();
            bouncingBalls[j].bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
        }
        // Update the window.
        repaint();
    }

    /**
     * paint 		draw the window
     *
     * @param g Graphics object to draw on
     */
    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);

        // Draw each ball.
        for (int j = 0; j < NUM_BALLS; j++) {
            bouncingBalls[j].draw(g);
        }


    }
}
