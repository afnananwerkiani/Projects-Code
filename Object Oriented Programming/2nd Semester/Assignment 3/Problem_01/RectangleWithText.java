package Problem_01;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectangleWithText extends JPanel {
    public String text;
    public Rectangle rectangle;
    public int fontSize;

    public RectangleWithText(String text, Rectangle rectangle) {
        this.text = text;
        this.rectangle = rectangle;
        fontSize = (int) (rectangle.height * 0.8);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.setFont(g.getFont().deriveFont(fontSize));
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textX = rectangle.x + (rectangle.width - textWidth) / 2;
        int textY = rectangle.y + (rectangle.height + fontSize) / 2;
        g.drawString(text, textX, textY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        RectangleWithText panel = new RectangleWithText("Hello World!", new Rectangle(100, 100, 200, 200));
        panel.setPreferredSize(new Dimension(400, 400));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
