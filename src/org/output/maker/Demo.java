package org.output.maker;

import java.io.IOException;

public class Demo{

    public static void main(String args[]) throws IOException {
        final int ITERATION = 1000000000;
        String s = "testredttestredt";
        String a = "";
        // String Concatenation using + operator
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
           a = s;
        }
        long duration = (System.nanoTime() - startTime) / 1000;
        System.out.println(" Strings using  : " + duration);

  
        // StringBuilder example to concate two String in Java
        StringBuilder builder = new StringBuilder("testredttestredt"); //default size for worst case
        StringBuilder buffer = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATION; i++) {
            buffer = builder;
        }
        duration = (System.nanoTime() - startTime) / 1000;
        System.out.println(" StringBuilder : " + duration);
    }
}
 