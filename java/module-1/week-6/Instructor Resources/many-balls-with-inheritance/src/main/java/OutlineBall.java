
import java.awt.*;

/*********************************************************************************
 * OutlineBall class
 *
 ***********************************************************************************/
public class OutlineBall
{
    // DATA:
    private int x, y;		// Center of the ball
    private int dx, dy;		// Velocity - how much to move the ball in one time unit
    private int radius;		// Radius of the ball
    private Color color;	// Color of the ball
    private Color outlineColor; // Color of the outline

    // METHODS:

    public OutlineBall(int x, int y, int dx, int dy, int radius, Color color, Color outlineColor)
    {
        // Nothing to do but save the data in the object's data fields.
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    // setters

    public void reverseDx () {
        dx = -dx;
    }

    public void reverseDy() {
        dy = -dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
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
            reverseDx();
        }

        // Now check for a y bounce.
        if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0))
        {
            reverseDy();
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
        g.setColor(outlineColor);
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
