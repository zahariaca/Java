package com.zahariaca.lists.maptester;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/28/2016.
 */
public class MapTester {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        fillData(map);

        map.forEach((s, s2) -> System.out.printf("%s,  %s%n", s,s2));

        map.put("Iphone", "Created by Apple");
        map.remove("Android");

        System.out.println("******************************************");
        map.forEach((s, s2) -> System.out.printf("%s,  %s%n", s,s2));
    }
    private static void fillData(Map<String, String> map){
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");
    }
}
