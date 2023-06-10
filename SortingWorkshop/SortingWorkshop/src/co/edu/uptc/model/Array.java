package co.edu.uptc.model;

import java.util.Random;

public class Array {
    private Random random;
    private int[] array;

    public Array() {
        this.random = new Random();
    }

    public void fillArray() {
        array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    }

    public int[] returnArray() {
        int[] arrayCopy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }

        return arrayCopy;
    }
}