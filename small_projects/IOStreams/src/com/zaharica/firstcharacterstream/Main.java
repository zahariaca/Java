package com.zaharica.firstcharacterstream;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            read();
            readALine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read() throws IOException{
        FileReader in = null;
        FileWriter out = null;

        try{
            in = new FileReader("xanadu.txt");
            out = new FileWriter("output2.txt");
            int c;

            while((c = in.read()) != -1){
                out.write(c);
            }
        }finally {
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
    private static void readALine() throws IOException{
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try{
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("output2.txt"));
            String line;

            while((line = inputStream.readLine()) != null){
                outputStream.println(line);
            }
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
    }
}
