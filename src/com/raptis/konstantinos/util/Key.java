package com.raptis.konstantinos.util;

import java.io.Serializable;

/**
 * Created by kwnstantinos on 31/3/2016.
 */
public class Key implements Serializable {

    // field variables
    private Key previous;
    private String name;
    private double timePassed;
    private long keyPressedTime;
    private long keyReleasedTime;

    // constructor
    public Key(String name, Key previous, double timePassed, long keyPressedTime, long keyReleasedTime) {
        this.name = name;
        this.previous = previous;
        this.timePassed = timePassed;
        this.keyPressedTime = keyPressedTime;
        this.keyReleasedTime = keyReleasedTime;
    }

    public Key getPrevious() {
        return previous;
    }

    public String getName() {
        return name;
    }

    // time passed from previous (if exist) key pressing
    public double getTimePassed() {
        return timePassed;
    }

    // get key hold time
    public double getHoldTime() {
        return (keyReleasedTime - keyPressedTime) / 1000000;
    }

    // to String
    @Override
    public String toString() {
        if (previous == null) {
            return String.format("Current: %-5s; Previous: %-5s; Time Passed: %-10s ms; Hold Time: %-10f ms", name, "-", "-", getHoldTime());
        } else {
            return String.format("Current: %-5s; Previous: %-5s; Time Passed: %-10f ms; Hold Time: %-10f ms", name, previous.getName(), timePassed, getHoldTime());
        }
    }
}
