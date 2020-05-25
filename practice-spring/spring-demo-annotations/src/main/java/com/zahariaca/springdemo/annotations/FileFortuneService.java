package com.zahariaca.springdemo.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {
    private List<String> fortuneList = new ArrayList<>();

    @PostConstruct
    public void readFileAfterInit() {


        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

        Path path = Paths.get(".\\src\\main\\resources\\fortune-data.txt");
        File theFile = new File(path.toUri());

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());


        try(BufferedReader reader = new BufferedReader(new FileReader(theFile))) {
            String tempLine;

            while ((tempLine = reader.readLine()) != null) {
                fortuneList.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDailyFortune() {
        return fortuneList.get(new Random().nextInt(fortuneList.size()));
    }
}
