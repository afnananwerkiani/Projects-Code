import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EditButton extends Button {
    private final Button redoButton;
    private final Button undoButton;
    private Layers layers;


    public EditButton(int x, int y, int width, int height,Layers layers)
    {
        super(x, y, width, height, Color.BLACK,Color.WHITE,"Edit");

        redoButton = new Button(x, y + height, width, height,Color.BLACK,Color.WHITE,"Redo");

        undoButton = new Button(x, y + 2 * height, width, height, Color.BLACK,Color.WHITE,"Undo");

        this.layers = layers;
    }

    public void handleClick(int x, int y){
        Toggle(x,y);
        if(super.getClicked()) {
            if(redoButton.Clicked(x,y))
            {
                layers.getTopLayer().redo();
            }
            if(undoButton.Clicked(x,y)){
                layers.getTopLayer().undo();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(super.getClicked()){
            redoButton.paint(g);
            undoButton.paint(g);
        }
    }

    public int Key(char key){
        if(key == '-'){
            return 1;
        }
         else if(key == '+'){
            return 2;
        }
         return 0;
    }
}
