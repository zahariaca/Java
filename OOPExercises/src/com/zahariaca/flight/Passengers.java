package com.zahariaca.flight;

/**
 * Created by azaharia on 05.05.2016.
 */
public class Passengers {
    private int freeBags;
    private int checkedBags;

    public int getFreeBags() {
        return freeBags;
    }

    public void setFreeBags(int freeBags) {
        this.freeBags = freeBags;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public Passengers(int freeBags){
        this.freeBags = freeBags;
    }
    public Passengers(int freeBags, int checkedBags){
        this(freeBags);
        this.checkedBags = checkedBags;
    }
}
