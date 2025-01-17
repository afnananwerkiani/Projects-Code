import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class File_Button extends Button {
    private final Button newButton;
    private final Button saveButton;
    private final Button openButton;
    private final Window openWindow;
    private final ArrayList<Button> file_names = new ArrayList<>();

    private ArrayList<Layer> layers;

    private boolean open;
    private boolean new_file;



    public File_Button(int x, int y, int length, int height,ArrayList<Layer> layers) {
        super(x, y, length, height, Color.BLACK, Color.WHITE, "File");

        this.layers = layers;
        Color stroke_col = Color.BLACK;
        Color button_col = Color.WHITE;

        newButton = new Button(x, y + height, length, height, stroke_col, button_col, "New");

        saveButton = new Button(x, y + 2 * height, length, height, stroke_col, button_col, "Save");

        openButton = new Button(x, y + 3 * height, length, height, stroke_col, button_col, "Open");

        openWindow = new Window(100,250,400,400,"Files");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (super.getClicked()) {
            newButton.paint(g);
            saveButton.paint(g);
            openButton.paint(g);
        }
        if(openWindow.getVisible()){
            openWindow.paint(g);
            for(Button b:file_names){
                b.paint(g);
            }
        }
    }

    public void handleClick(int inputX, int inputY) {
        if (!openWindow.getVisible()) {
            Toggle(inputX, inputY);
            if (super.getClicked()) {
                if (saveButton.Clicked(inputX, inputY)) {
                    createNewFile();
                }
                if (openButton.Clicked(inputX, inputY)) {
                    openWindow.setVisible(true);
                    openFiles();
                }
                if (newButton.Clicked(inputX, inputY)) {
                    new_file = true;
                }
            }
        }
        else if (openWindow.getVisible()) {
            for(Button b : file_names){
                if(b.Clicked(inputX,inputY))
                {
                    String fileName = b.getText();
                    System.out.println(fileName);
                    openWindow.setVisible(false);
                    break;
                }
            }
                if (openWindow.Clicked(inputX, inputY)) {
                    openWindow.setVisible(false);
                }
            }
        }


    public void createNewFile() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
        String fileName = LocalDateTime.now().format(formatter) + ".ser";

        try {
            File save_file = new File("src/Files", fileName);
            if (save_file.createNewFile()) {
                System.out.println("File created: " + save_file.getName());
            } else {
                System.out.println("File already exists.");
            }

            System.out.println("Successfully created the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void openFiles(){
        File file = new File("src/Files");
        String[] names = file.list();
        int y = 300;
        for (String name : names)
        {
            Button button = new Button(150, y, 300, 50, Color.BLACK, Color.GRAY, name);
            file_names.add(button);
            y += 50;
        }
    }

    public void Key(char key){
        if(key == 's'){
            createNewFile();
        }
        else if(key == 'o'){
            openWindow.setVisible(true);
            openFiles();
        }
        else if(key == 'n'){
            System.out.println("New Project Open");
        }
    }

    public ArrayList<Layer> getLayers()
    {
            open = false;
            return layers;
    }
    public void setOpen(boolean open)
    {
        this.open = open;
    }
    public boolean getOpen()
    {
        return open;
    }
    public boolean getNewFile()
    {
        return new_file;
    }
    public Layers newFile()
    {
        new_file = false;
        return new Layers();
    }
}