package com.raptis.konstantinos;

import com.raptis.konstantinos.core.KeyHandler;
import com.raptis.konstantinos.util.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by kwnstantinos on 31/3/2016.
 */
public class KeystrokeFactoryTest {

    private static long currentTimeReleased, previousTimeReleased,
                        currentTimePressed, previousTimePressed;
    private static Key currentKey, previousKey;

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

        KeyHandler kh = new KeyHandler();

        field.addKeyListener(new KeyListener() {

            // key typed
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // key pressed
            @Override
            public void keyPressed(KeyEvent e) {
                if(currentTimePressed == 0 && previousTimePressed == 0) {
                    currentTimePressed = System.nanoTime();
                    previousTimePressed = System.nanoTime();
                } else {
                    currentTimePressed = System.nanoTime();
                    previousTimePressed = currentTimePressed;
                }
            }

            // key released
            @Override
            public void keyReleased(KeyEvent e) {
                if(currentTimeReleased == 0 && previousTimeReleased == 0) {
                    currentTimeReleased = System.nanoTime();
                    previousTimeReleased = System.nanoTime();
                    currentKey = new Key(String.format("%c", e.getKeyChar()), null, -1, currentTimePressed, currentTimeReleased);    // negative time in order to show
                    previousKey = new Key(String.format("%c", e.getKeyChar()), null, -1, previousTimePressed, previousTimeReleased);   // that there is no previous key typed
                } else {
                    currentTimeReleased = System.nanoTime();
                    double timePassed = (double) ((currentTimeReleased - previousTimePressed) / 1000000);  // milliseconds
                    currentKey = new Key(String.format("%c", e.getKeyChar()), previousKey, timePassed, currentTimePressed, currentTimeReleased);
                    logArea.append("Time passed : " + timePassed + " ms" + "\n");
                    previousTimeReleased = currentTimeReleased;
                    previousKey = currentKey;
                }
                kh.add(currentKey);
            }
        });
    }
}
