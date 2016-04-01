package com.raptis.konstantinos.output;

import com.raptis.konstantinos.util.Key;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by kwnstantinos on 31/3/2016.
 */
public class KeyWriter {

    // field variables
    public static final String FILE_NAME = "keys.txt";
    private Formatter output;

    // write buffer to keys.txt file
    public void write(Key[] buffer) {
        openFile(FILE_NAME);
        addRecords(buffer);
        closeFile();
    }

    // open file
    private void openFile(String fileName) {
        try {
            File tempFile = new File(fileName);
            output = new Formatter(fileName);
        } catch (SecurityException e) {
            System.err.println("You do not have write access to this file.");
        } catch (FileNotFoundException e) {
            System.err.println("Error opening or creating file");
        }
    }

    // add records
    private void addRecords(Key[] buffer) {
        Scanner input = new Scanner(System.in);

        for(Key key : buffer) {
            if(key.getPrevious() == null) {
                output.format("%s %s %f%n", key.getName(), "null", key.getTimePassed());
                continue;
            }
            output.format("%s %s %f%n", key.getName(), key.getPrevious().getName(), key.getTimePassed());
        }
    }

    // close file
    private void closeFile() {
        if(output != null) {
            output.close();
        }
    }

}
