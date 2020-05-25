package com.zahariaca.draw;

/**
 * Created by azaharia on 05.05.2016.
 */
public class Square {
    private int latura;

    public int getLatura(){
        return latura;
    }
    public void setLatura(int latura){
        this.latura = latura;
    }

    public Square(int latura){
        setLatura(latura);
        if (getLatura() < 50){
        }else {
            System.out.printf("THIS IS TOO BIG: %s%n", getLatura());
        }
    }

    public void linieVerticala() {
        System.out.println(getLatura());
        for (int i = 1; i <= getLatura(); i++) {
            System.out.print("__");
        }
        System.out.println();
    }
    public void linieOrizontala(){
        String sp = "";
        for (int i = 1; i <= getLatura(); i++){
            System.out.println("|");
            System.out.printf("%-20s", sp);
        }
    }
}

