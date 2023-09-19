import java.awt.*;

public class FilledUnfilledBall extends Ball{

    private boolean isFilled;

    /**
     * Ball constructor initializes the Ball object
     *
     * @param x      x coordinate of center
     * @param y      y coordinate of center
     * @param dx     x velocity
     * @param dy     y velocity
     * @param radius radius
     * @param color  color
     */
    public FilledUnfilledBall(int x, int y, int dx, int dy, int radius, Color color) {
        super(x, y, dx, dy, radius, color);
        isFilled = true;
    }

    @Override
    public void bounce(int xLow, int xHigh, int yLow, int yHigh)
    {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((getX() - getRadius() <= xLow && getDx() < 0) || (getX() + getRadius() >= xHigh && getDx() > 0))
        {
            reverseDx();
            isFilled = !isFilled;
        }

        // Now check for a y bounce.
        if ((getY() - getRadius() <= yLow && getDy() < 0) || (getY() + getRadius() >= yHigh && getDy() > 0))
        {
            reverseDy();
            isFilled = !isFilled;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        if (isFilled) {
            super.draw(g);
        } else {
            g.setColor(getColor());
            g.drawOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
        }

    }
}
