import java.awt.Color;
import java.awt.Graphics;

/*********************************************************************************
 * SpeedingBall class
 A speeding ball accelerates every time it bounces off the wall.  
 Its dx and dy increase by a constant value ACCELERATION with every 
 contact with the wall.
 Current speed is stored and printed on the SpeedingBall object when displayed 
 ***********************************************************************************/
public class SpeedingBall extends Ball
{
    // DATA:

    private static final Color SPEEDING_BALL_COLOR = Color.GREEN;
    private static final int ACCELERATION = 1;

    // METHODS:

    public SpeedingBall (int x, int y, int dx, int dy, int radius)
    {
        super (x, y, dx, dy, radius, SPEEDING_BALL_COLOR);
    }


    /**
     * Check if the ball should bounce off any of the walls.  It will only
     * bounce if it was heading toward the wall and went a bit past it.  If
     * so just change the sign of the corresponding velocity.  Not a very
     * accurate way to handle this, but it is simple and it mostly works.
     *
     * @param xLow  x coord of left wall
     * @param xHigh  x coord of right wall
     * @param yLow  y coord of top wall
     * @param yHigh  y coord of bottom wall
     */
    public void bounce(int xLow, int xHigh, int yLow, int yHigh)
    {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((getX() - getRadius() <= xLow && getX() < 0) || (getX() + getRadius() >= xHigh && getDx()> 0))
        {
            reverseDx();
            accelerate();
        }

        // Now check for a y bounce.
        if ((getY() - getRadius() <= yLow && getDy() < 0) || (getY() + getRadius() >= yHigh && getDy() > 0)) {
            reverseDy();
            accelerate();
        }
    }

    /**
     * Increase speed in both directions
     * by ACCELERATION constant.
     */
    private void accelerate(){
        if (getDx() > 0) {
            setDx(getDx() + ACCELERATION);
        }
        else {
            setDx (getDx() - ACCELERATION);
        }
        if (getDy() > 0){
            setDy (getDy() + ACCELERATION);
        }
        else {
            setDy (getDy() - ACCELERATION);
        }
    }




    /**
     * Draw the ball.
     *
     * @param g   Graphics object in which to draw
     */
    public void draw(Graphics g)
    {
        super.draw(g);

        int speed = (int) Math.round(getSpeed());
        String stringSpeed = "" + speed;
        g.setColor(Color.black);

        if (speed < 10) // keep speed value in center of ball
            g.drawString(stringSpeed, getX() - 4, getY() + 5);
        else
            g.drawString(stringSpeed, getX() - 8, getY() + 5);

    }

    private double getSpeed()
    {
        return Math.sqrt( getDx()* getDx() + getDy() * getDy());
    }

}