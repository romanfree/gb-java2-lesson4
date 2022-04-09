package com.geekbrains;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    MyWindow(){
        setTitle("Char");
        setSize(new Dimension(400,400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TextPanel textPanel = new TextPanel();
        SendPanel sendPanel = new SendPanel(textPanel.getArea());

        add(textPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
