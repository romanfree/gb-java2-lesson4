package com.geekbrains;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextPanel extends JPanel{
    private JTextArea area;

    TextPanel(){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        area = new JTextArea();
        area.setLineWrap(true);
        area.setEditable(false);

        Border line = BorderFactory.createLineBorder(Color.WHITE);
        Border empty = new EmptyBorder(10,10,10,10);
        CompoundBorder border = new CompoundBorder(line, empty);
        area.setBorder(border);

        JScrollPane jScrollPane = new JScrollPane(area);
        add(jScrollPane, BorderLayout.CENTER);
    }

    JTextArea getArea(){
        return area;
    }
}
