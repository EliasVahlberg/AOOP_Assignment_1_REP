/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-30
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Exercise414 extends JFrame implements ActionListener
{

    //region Constants
    private static final int FRAME_WIDTH    = 455   ;
    private static final int FRAME_HEIGHT   = 305   ;
    private static final int BUTTON_WIDTH   = 150   ;
    private static final int BUTTON_HEIGHT  = 75    ;
    private static final int CIRCLE_RADIUS  = 100   ;
    private static final int CIRCLE_X_POS   = 0     ;
    private static final int CIRCLE_Y_POS   = 0     ;
    //endregion

    //region Variables
    private         JButton     greenButton;
    private         JButton     blueButton;
    private         JButton     redButton;
    private static  Rectangle   greenButtonLayout   = new Rectangle(0               ,CIRCLE_RADIUS*2,BUTTON_WIDTH,BUTTON_HEIGHT);
    private static  Rectangle   blueButtonLayout    = new Rectangle(1*BUTTON_WIDTH  ,CIRCLE_RADIUS*2,BUTTON_WIDTH,BUTTON_HEIGHT);
    private static  Rectangle   redButtonLayout     = new Rectangle(2*BUTTON_WIDTH  ,CIRCLE_RADIUS*2,BUTTON_WIDTH,BUTTON_HEIGHT);
    private         JLabel      label;
    private         CircleIcon  icon;
    //endregion

    public static void main(String[] args)
    {
        new Exercise414();
    }

    public Exercise414()
    {

        //region INIT Frame
        setTitle("Exercise414_2");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //endregion

        //region INIT Components
        icon        = new CircleIcon(CIRCLE_X_POS,CIRCLE_Y_POS,CIRCLE_RADIUS*2,CIRCLE_RADIUS*2);
        label       = new JLabel(icon);
        greenButton = addButton(greenButton ,greenButtonLayout  ,"Green"    ,this,Color.GREEN   );
        blueButton  = addButton(blueButton  ,blueButtonLayout   ,"Blue"     ,this,Color.BLUE    );
        redButton   = addButton(redButton   ,redButtonLayout    ,"Red"      ,this,Color.RED     );
        add(label);
        //endregion

        validate();
        repaint();
    }

    public void setTitle(String title)
    {
        System.out.println("HEy");
    }

    private JButton addButton(JButton button, Rectangle layout, String text, JFrame frame, Color color)
    {
        button = new JButton();
        button.setBounds(layout);
        button.setText(text);
        button.setFont(new Font("Comic Sans",Font.ITALIC,20));
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.GRAY,2));
        frame.add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==greenButton)
            icon.setColor(Color.GREEN);
        else if(e.getSource()==blueButton)
            icon.setColor(Color.BLUE);
        else if(e.getSource()==redButton)
            icon.setColor(Color.RED);
        else
            return;
        validate();
        repaint();
    }

    public static void applyQualityRenderingHints(Graphics2D g2d)
    {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING        , RenderingHints.VALUE_ANTIALIAS_ON                 );
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING     , RenderingHints.VALUE_COLOR_RENDER_QUALITY         );
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING           , RenderingHints.VALUE_DITHER_ENABLE                );
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS   , RenderingHints.VALUE_FRACTIONALMETRICS_ON         );
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING           , RenderingHints.VALUE_RENDER_QUALITY               );
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL      , RenderingHints.VALUE_STROKE_PURE                  );

    }


}
