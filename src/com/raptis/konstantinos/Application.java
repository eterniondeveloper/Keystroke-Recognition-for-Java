package com.raptis.konstantinos;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by kwnstantinos on 27/3/2016.
 */
public class Application {

    static long current, previous;

    // main
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key handling demo");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 5, 0));

        JTextField field = new JTextField(15);
        field.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        panel.add(field);

        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        panel.add(new JScrollPane(logArea));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        field.addKeyListener(new KeyListener() {

            // key typed
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // key pressed
            @Override
            public void keyPressed(KeyEvent e) {
                //logArea.append("key Pressed" + "\n");
            }

            // key released
            @Override
            public void keyReleased(KeyEvent e) {
                if(current == 0 && previous == 0) {
                    current = System.nanoTime();
                    previous = System.nanoTime();
                } else {
                    current = System.nanoTime();
                    double timePassed = (double) ((current - previous) / 1000000);  // milliseconds
                    logArea.append("Time passed : " + timePassed + " ms" + "\n");
                    previous = current;
                }
                //logArea.append("key Released" + "\n");
            }
        });
    }

}
