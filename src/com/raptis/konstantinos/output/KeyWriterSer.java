package com.raptis.konstantinos.output;

import com.raptis.konstantinos.util.Key;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by kwnstantinos on 1/4/2016.
 */
public class KeyWriterSer {

    // field variables
    public static final String FILE_NAME = "keys.ser";
    private ObjectOutputStream output;

    // write
    public void write(Key[] buffer) {
        openFile(FILE_NAME);
        addRecords(buffer);
        closeFile();
    }

    // open file
    private void openFile(String fileName) {
        try {
            output = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (IOException e) {
            System.err.println("Error opening file.");
        }
    }

    // add records
    private void addRecords(Key[] buffer) {
        try {
            for (Key key : buffer) {
                output.writeObject(key);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file.");
        }
    }

    // close file
    private void closeFile() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }

}
