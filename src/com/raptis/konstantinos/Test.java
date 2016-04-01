package com.raptis.konstantinos;

import com.raptis.konstantinos.input.KeyReaderSer;
import com.raptis.konstantinos.util.Key;

/**
 * Created by kwnstantinos on 1/4/2016.
 */
public class Test {

    // main
    public static void main(String[] args) {
        KeyReaderSer krs = new KeyReaderSer();
        Key[] keys = krs.read();

        if(keys == null) {
            System.out.println("keys object is null.");
            System.exit(-1);
        }

        for(Key key : keys) {
            System.out.println(key);
        }
    }

}
