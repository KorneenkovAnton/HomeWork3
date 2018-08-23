package com.epam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordsFinder {

    static final String FILE_NAME = "text.txt";
    private BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
    private String text;





    private String readFromFile() {
        String text = "";
        String line = "";
        try {
            while ((line = reader.readLine()) != null){
                text+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }





    public ArrayList<String> checkText(){
        String[] splitedText = text.split("[\\p{Punct}\\s]+");
        ArrayList<String> coupleWorkds = new ArrayList();
        int l;
        for (int i = 1;i< splitedText.length; i++){
            l = i - 1;
            if(checkWords(splitedText[l],splitedText[i])){
                coupleWorkds.add(splitedText[l] + "-" + splitedText[i]);
            }
        }
        return coupleWorkds;
    }




    private boolean checkWords(String w1 , String w2){
        if(w1.charAt(w1.length()-1) == w2.charAt(0)){
            return true;
        }else {
            return false;
        }
    }

    public String getFileName() {
        return FILE_NAME;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WordsFinder() throws FileNotFoundException {
        this.text = readFromFile();
    }

}
