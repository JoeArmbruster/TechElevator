import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/*********************************************************************************
 * 

 ***********************************************************************************/
public class ThreeBalls extends JFrame
{
	// DATA:
	private static Ball greenBall;
	private static Ball redBall;
	private static Ball blueBall;
	private static Ball otherBall;

	private static final int MAX_WIDTH = 400;		// Window size
	private static final int MAX_HEIGHT = 400;		// Window size
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
		ThreeBalls mb = new ThreeBalls();
	}

	/**
	 * ManyBalls constructor: create the one Ball and simulate the "clock"
	 */
	public ThreeBalls()
	{
		Color mccOlive = new Color (128, 128, 0);
		redBall = new Ball(50, 100, 3, -3, 22, Color.red);
		greenBall = new Ball (300, 300, 3, -4, 20, Color.green);
		blueBall = new Ball (100, 300, -1, -2, 30, Color.blue);
		otherBall = new Ball (200, 250, 3, 4, 30, mccOlive);


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
		greenBall.move();
		greenBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		blueBall.move();
		blueBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
		otherBall.move();
		otherBall.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);

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
		greenBall.draw(g);
		blueBall.draw(g);
		otherBall.draw(g);

		g.setColor (Color.black);
		g.drawString("# of balls: " + Ball.getNumberOfBalls(), MAX_WIDTH / 2 - 30, TOP_OF_WINDOW + 50);

	}
}
