package com.raptis.konstantinos.core;

import com.raptis.konstantinos.output.KeyWriter;
import com.raptis.konstantinos.output.KeyWriterSer;
import com.raptis.konstantinos.util.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwnstantinos on 31/3/2016.
 */
public class KeyHandler {

    // variables
    public static final int BUFFER_SIZE = 10;
    private int index = 0;
    private Key[] buffer = new Key[BUFFER_SIZE];

    public void add(Key key) {
        if(index >= BUFFER_SIZE) {
            KeyWriterSer kws = new KeyWriterSer();
            kws.write(buffer);
            buffer = new Key[BUFFER_SIZE];
            index = 0;
        }
        buffer[index] = key;
        index ++;
    }

    // index always point to the first available position in buffer
    public int getIndex() {
        return index;
    }
}
