package com.zahariaca.springannotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alex on 02.07.2017.
 */
@Component
public class FileRandomFortuneService implements FortuneService {
    private List<String> data = new ArrayList<String>();
    private Random random = new Random();

    public FileRandomFortuneService(){
        System.out.println(">> Inside of the FileRandomFortuneService constructor");
        try {
            Scanner in = new Scanner(new File("F:\\GitRepositories\\Java\\practice-spring\\springdemoannotations\\src\\main\\resources\\fortunesFile"));
            while(in.hasNext()) {
                data.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        return data.get(random.nextInt(data.size()));
    }

    @PostConstruct
    private void doMyInitStuff(){
        System.out.println(">> Inside the doMyInitStuff function of the FileRandomFortuneService");
        try {
            Scanner in = new Scanner(new File("F:\\GitRepositories\\Java\\practice-spring\\springdemoannotations\\src\\main\\resources\\fortunesFile"));
            while(in.hasNext()) {
                data.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void doMyCleanupStuff(){
        System.out.println(">> Inside the doMyCleanup function of the FileRandomFortuneService");
    }
}
