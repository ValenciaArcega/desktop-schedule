package logic;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.*;

public class ScrollBar extends BasicScrollBarUI {

    // Delete the increase n decrease buttons
    Dimension a = new Dimension();

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {                      
            @Override
            public Dimension getPreferredSize() { return new Dimension(); }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override
            public Dimension getPreferredSize() { return a; }
        };
    }


    // Paint the background
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) { }



    // Paint the ScrollBar
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {

        Graphics2D obj = (Graphics2D) g.create();
        JScrollBar sb = (JScrollBar) c;
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color color = null;
        
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = Color.DARK_GRAY; // when is draggin'
        } else if (isThumbRollover()) {
            color = Color.LIGHT_GRAY; // hover
        } else {
            color = Color.GRAY;
        }

        obj.setPaint(color);
        obj.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        
        obj.setPaint(Color.white);
        obj.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}