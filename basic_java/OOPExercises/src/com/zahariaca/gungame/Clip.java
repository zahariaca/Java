package com.zahariaca.gungame;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/12/2016.
 */
public class Clip {
    static final int MAX_BULLETS = 15;
    private int bullets = MAX_BULLETS;

    public void incBullets(int value){
        bullets += value;
    }
    public int getBullets(){
        return bullets;
    }
    public boolean isEmpty(){
        return bullets==0;
    }
}
