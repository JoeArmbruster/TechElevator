import java.awt.*;
import javax.swing.*;

/*********************************************************************************
 * Ball class
 * Stores all of the information about a single ball including:
 * 		center, velocity, radius and color
 * It provides methods to move the ball, handle bouncing within a rectangle
 * 		and draw itself.
 ***********************************************************************************/
class Ball
{

	private static int numberOfBalls = 0;
	private static final Font ID_FONT = new Font("Roboto", Font.PLAIN, 18);


	// Instance data:

	private int id;
	private int x, y;		// Center of the ball
	private int dx, dy;		// Velocity - how much to move the ball in one time unit
	private int radius;		// Radius of the ball
	private Color color;	// Color of the ball
	
	// METHODS:
	
	/**
	 * Ball constructor initializes the Ball object
	 * 
	 * @param x		x coordinate of center
	 * @param y		y coordinate of center
	 * @param dx		x velocity
	 * @param dy		y velocity
	 * @param radius	radius
	 * @param color	color
	 */
	public Ball (int x, int y, int dx, int dy, int radius, Color color)
	{
		// Nothing to do but save the data in the object's data fields.
		increaseNumberOfBalls();
		this.id = getNumberOfBalls();

		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
		this.color = color;


	}

	public static int getNumberOfBalls() {
		return numberOfBalls;
	}

	private static void increaseNumberOfBalls() {
		numberOfBalls++;
	}


	/**
	 * Move the ball.  Add the velocity to its center.
	 */
	public void move()
	{
		x = x + dx;
		y = y + dy;
	}
	
	/**
	 * Check if the ball should bounce off any of the walls.  It will only
	 * bounce if it was heading toward the wall and went a bit past it.  If
	 * so just change the sign of the corresponding velocity.  Not a very
	 * accurate way to handle this, but it is simple and it mostly works.
	 * 
	 * @param xLow		x coord of left wall
	 * @param xHigh		x coord of right wall
	 * @param yLow		y coord of top wall
	 * @param yHigh		y coord of bottom wall
	 */
	public void bounce(int xLow, int xHigh, int yLow, int yHigh)
	{
		// Check for an x bounce.  Note that we bounce if the x is too
		//  low or too high AND IS HEADING IN THE WRONG DIRECTION.
		if ((x - radius <= xLow && dx < 0) || (x + radius >= xHigh && dx > 0))
		{
			dx = -dx;
		}
			
		// Now check for a y bounce.
		if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0))
		{
			dy = -dy;
		}
	}

	/**
	 * Draw the ball.
	 * 
	 * @param g			Graphics object in which to draw
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

		g.setFont(ID_FONT);
		g.setColor(Color.WHITE);
		g.drawString("" + id, x - 5, y + 5);
	}
}
			