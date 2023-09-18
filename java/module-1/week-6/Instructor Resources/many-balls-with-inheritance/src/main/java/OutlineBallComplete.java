
import java.awt.*;

/*********************************************************************************
 * OutlineBallComplete class
 *
 ***********************************************************************************/
public class OutlineBallComplete extends Ball
{
    // DATA:
    private Color outlineColor; // Color of the outline

    // METHODS:

    public OutlineBallComplete(int x, int y, int dx, int dy, int radius, Color color, Color outlineColor)
    {
        super(x, y, dx, dy, radius, color);
        this.outlineColor = outlineColor;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    @Override
    public void draw(Graphics g)
    {
       super.draw (g);
       g.setColor(outlineColor);
       g.drawOval(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());
    }
}
