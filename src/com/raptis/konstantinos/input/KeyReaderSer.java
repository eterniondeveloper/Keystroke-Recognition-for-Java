package com.raptis.konstantinos.input;

import com.raptis.konstantinos.output.KeyWriterSer;
import com.raptis.konstantinos.util.Key;
import org.jetbrains.annotations.Nullable;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwnstantinos on 1/4/2016.
 */
public class KeyReaderSer {

    // field variables
    public static final String FILE_NAME = "keys.ser";
    private ObjectInputStream input;

    // read
    public Key[] read() {
        openFile(FILE_NAME);
        Key[] keys = readRecords();
        closeFile();
        return keys;
    }

    // open file
    private void openFile(String fileName) {
        try {
            input = new ObjectInputStream(new FileInputStream(fileName));
        } catch (IOException e) {
            System.err.println("Error opening file.");
        }
    }

    // read records
    @Nullable
    private Key[] readRecords() {
        List<Key> keys = new ArrayList<>();
        try {
            while(true) {
                keys.add((Key) input.readObject());
            }
        } catch (EOFException e) {
            return keys.toArray(new Key[keys.size()]);
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to create object.");
        } catch (IOException e) {
            System.err.println("Error during read from file");
        }
        return null;
    }

    // close file
    private void closeFile() {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
}
