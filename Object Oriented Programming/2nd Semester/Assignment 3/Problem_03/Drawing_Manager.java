package Problem_03;

import javax.swing.*;

public class Drawing_Manager {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Drawing_Canvas_from_txt canvas = new Drawing_Canvas_from_txt();
        frame.setBounds(0,0,800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);
    }
}