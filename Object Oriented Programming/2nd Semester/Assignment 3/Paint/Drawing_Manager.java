package Paint;

//import Problem_03.Drawing_Canvas_from_txt;

import javax.swing.*;

public class Drawing_Manager
{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Drawing_Canvas text = new Drawing_Canvas();
        frame.setBounds(0,0,800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(text);
        frame.setVisible(true);
    }
}
