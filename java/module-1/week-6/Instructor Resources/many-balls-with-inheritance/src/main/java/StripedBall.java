import java.awt.*;

public class StripedBall extends Ball{

    private static final int STRIPE_SIZE = 3;

    private Color stripeColor;
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
    public StripedBall(int x, int y, int dx, int dy, int radius, Color color, Color stripeColor) {
        super(x, y, dx, dy, radius, color);
        this.stripeColor = stripeColor;
    }

    @Override
    public void draw(Graphics g)
    {
        int currentRadius = getRadius();
        boolean setToMainColor = true;

        while (currentRadius > STRIPE_SIZE) {
            // draw main color
            g.setColor(setToMainColor ? getColor() : stripeColor);
            g.fillOval(getX() - currentRadius, getY() - currentRadius, 2 * currentRadius, 2 * currentRadius);
            currentRadius -= STRIPE_SIZE;
            setToMainColor = !setToMainColor;
        }
    }

}
