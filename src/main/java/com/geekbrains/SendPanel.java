package com.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendPanel extends JPanel{
    private JTextField text;
    private JTextArea area;
    private String br;
    private Date date;
    private final SimpleDateFormat dateFormat;

    SendPanel(JTextArea area) {
        this.area = area;

        text = new JTextField(){
            @Override
            public void addNotify () {
            super.addNotify();
            requestFocus();
            }
        };

        br = "";
        dateFormat = new SimpleDateFormat("HH:mm");
        setup();
    }

    private void setup(){
        setLayout(new BorderLayout());
        JButton button = new JButton("Send");

        button.addActionListener(new SendBtnListener());
        text.addActionListener(new SendBtnListener());

        add(text, BorderLayout.CENTER);
        add(button, BorderLayout.EAST);
    }

    private String getTime(){
        date = new Date();
        return dateFormat.format(date);
    }

    private void append(){
        String txt = text.getText();

        if(!txt.isEmpty()){
            area.setText(String.format("%s%s[%s] %s", area.getText(), br, getTime(), txt));
            text.setText("");
            br = "\n";
        }
    }

    private class SendBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
                append();
            }
            if(e.getSource() instanceof JTextField){
                append();
            }
        }
    }

}
