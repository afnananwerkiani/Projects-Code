import java.awt.Color;
import java.awt.Graphics;

public class Window extends Button {
    private final Button topBar;
    private final Button closeButton;
    private boolean visible;

    public Window(int x, int y, int width, int height, String text) {
        super(x, y, width, height,Color.BLACK, Color.GRAY);

        int topBarHeight = 30;
        topBar = new Button(x, y, width, topBarHeight, Color.BLACK, Color.GRAY, text);

        int closeButtonSize = 20;
        closeButton = new Button(x + width - closeButtonSize - 5, y + 5, closeButtonSize, closeButtonSize,  Color.WHITE, Color.RED);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        topBar.paint(g);
        closeButton.paint(g);
    }

    public boolean Clicked(int x, int y){
        return closeButton.Clicked(x,y);
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public boolean getVisible(){
        return visible;
    }
}