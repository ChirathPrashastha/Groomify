/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

/**
 *
 * @author Chirath
 */
public class RoundedToggleButton extends JToggleButton{
    private static final Color NORMAL   = new Color(0x3E2723);
    private static final Color HOVER    = new Color(0x4E342E);
    private static final Color SELECTED = new Color(0x8D5B3A);
    private static final Color TEXT     = new Color(0xE6DEDA);
    private static final int ARC = 16;          // corner roundness (diameter)

    private boolean hovering = false;

    public RoundedToggleButton() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setForeground(TEXT);
        setHorizontalAlignment(LEFT);
        setIconTextGap(12);
        setMargin(new Insets(0, 14, 0, 0));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { hovering = true;  repaint(); }
            @Override public void mouseExited(MouseEvent e)  { hovering = false; repaint(); }
        });
        addItemListener(e -> setForeground(isSelected() ? Color.WHITE : TEXT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(isSelected() ? SELECTED : (hovering ? HOVER : NORMAL));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC, ARC);
        g2.dispose();
        super.paintComponent(g);
    }
}
