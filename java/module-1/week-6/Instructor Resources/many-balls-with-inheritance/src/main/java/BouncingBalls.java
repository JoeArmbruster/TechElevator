

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/*********************************************************************************
 * 

 ***********************************************************************************/
public class BouncingBalls extends JFrame
{
	// DATA:
	private static Ball redBall;
	private static OutlineBall outlineBall;

	private static SpeedingBall speedingBall;
	private static FilledUnfilledBall fillBall;
	private static StripedBall stripedBall;

	private static final int MAX_WIDTH = 500;		// Window size
	private static final int MAX_HEIGHT = 500;		// Window size
	private static final int TOP_OF_WINDOW = 22;	// Top of the visible window

	// METHODS:

	/**
	 * main -- Start up the window.
	 *
	 * @param	args
	 */
	public static void main(String args[])
	{
		// Create the window.
		BouncingBalls mb = new BouncingBalls();
	}

	/**
	 * ManyBalls constructor: create the one Ball and simulate the "clock"
	 */
	public BouncingBalls()
	{
		redBall = new Ball(50, 100, 3, -3, 18, Color.red);
		speedingBall = new SpeedingBall(350, 350, 3, -3, 23);
		fillBall = new FilledUnfilledBall(450, 200, 2, -3, 20, Color.MAGENTA);
		stripedBall = new StripedBall(200, 200, 1, 3, 30, Color.black, Color.white);
		outlineBall = new OutlineBall(240, 280, 2, -2, 18, Color.YELLOW, Color.black);
		
		// Show the window with the ball in its initial position.
		//	Note that these are called without the mb. in front.  
		//	We'll discuss why in class.
		setSize(MAX_WIDTH, MAX_HEIGHT);
		setVisible(true);
		
		// Simulate the passing of time by reading console input.
		Scanner console = new Scanner(System.in);
		while (true)
		{
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
	private void actionPerformed()
	{
		// Move the ball.
		redBall.move();
		redBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		outlineBall.move();
		outlineBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);

		speedingBall.move();
		speedingBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		fillBall.move();
		fillBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		stripedBall.move();
		stripedBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);

		// Update the window.
		repaint();
	}
	
	/**
	 * paint 		draw the window
	 * 
	 * @param g		Graphics object to draw on
	 */
	public void paint(Graphics g)
	{
		// Clear the window.
		g.setColor(Color.white);
		g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
		
		// Tell the ball to draw itself.
		redBall.draw(g);
		outlineBall.draw(g);

		// speedingBall.draw(g);
		// fillBall.draw(g);
		// stripedBall.draw(g);

	}
}
