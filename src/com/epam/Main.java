package com.epam;


import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WordsFinder wordsFinder = new WordsFinder();
        for (String s:wordsFinder.checkText()){
            System.out.println(s);
        }
    }
}
