package com.zahariaca.gungame;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/12/2016.
 */
public class Gun {
    private Clip clip = new Clip();
    private FireMode mode = FireMode.SINGLE;

    public void fireSingleShot(){
        if (!clip.isEmpty()){
            clip.incBullets(-1);
        }
    }

    public void setMode(FireMode mode){this.mode=mode;}
    public FireMode getMode(){return mode;}

    public void fire(){
        switch (mode){
            case SINGLE:
                fireSingleShot();
                break;
            case TRIPLE:
                for(int i=0; i < 3; i++){
                    fireSingleShot();
                }
                break;
            case AUTOMATIC:
                while(!clip.isEmpty()){
                    fireSingleShot();
                }
                break;
        }
    }

    public void printStatus(){
        System.out.println("The mode is: " + mode.toString());
        System.out.println("The gun has: " + clip.getBullets() + " bullets");
    }

    public void reload(){
        clip = new Clip();
    }
    public Clip getClip(){
        return clip;
    }
}
