package com.zahariaca.simplequestiongame;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Questions> questions = new ArrayList<Questions>();

    public static void main(String[] args) {
        init();
        loop();
    }

    private static void init(){
        try {
            Path filePath = new File("data.txt").toPath();
            Charset charset = Charset.defaultCharset();
            List<String> list = Files.readAllLines(filePath,charset);
            for(int i = 0; i < list.size(); i +=5){
                Questions q = new Questions(list.get(i), list.get(i+1), list.get(i+2), list.get(i+3), list.get(i+4));
                questions.add(q);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void loop(){
        Scanner scan = new Scanner(System.in);

        while(questions.size() > 0){
            Questions q = questions.remove(0);
            System.out.println(q.getText());
            for(int i =0; i < q.getAnswers().length; i++){
                System.out.println(i + " "+ q.getAnswers()[i]);
            }
            int input = scan.nextInt();
            if(q.getRightAnswer().equals(q.getAnswers()[input])){
                System.out.println("RIGH!");
            }else{
                System.out.println("WRONG!");
            }
        }
    }
}
