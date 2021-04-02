/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-30
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleIcon implements Icon
{
    //region Variables
    private int     x       = 0         ;
    private int     y       = 0         ;
    private int     w       = 0         ;
    private int     h       = 0         ;
    private Shape circle              ;
    private Color   color   = Color.RED ;
    //endregion

    public CircleIcon(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        circle = new Ellipse2D.Double(x,y,w,h);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        Exercise414.applyQualityRenderingHints(g2);
        g2.setColor(color);
        g2.fill(circle);
    }

    @Override
    public int getIconWidth()
    {
        return w;
    }

    @Override
    public int getIconHeight()
    {
        return h;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}