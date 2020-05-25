package com.zahariaca.mypoint;

/**
 * Created by azaharia on 01.06.2016.
 */
public class MyPoint {
    private double x = 0;
    private double y = 0;

    public double getX(){return x;}
    public void setX(double x){ this.x = x;}
    public double getY(){return y;}
    public void setY(double y){ this.y = y;}

    public MyPoint(){}
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double[] getXY(){
        double[] xY = {getX(),getY()};
        return xY;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x + ","+y+")";
    }

    public double distance(){
        double diffX = 0 - x;
        double diffY = 0 - y;
        return Math.sqrt(Math.pow(diffX,2)+Math.pow(diffY,2));
    }

    public double distance(double x, double y){
        double diffX = x - this.x;
        double diffY = y - this.y;
        return Math.sqrt(Math.pow(diffX,2)+Math.pow(diffY,2));
    }

    public double distance(MyPoint point){
        double diffX = point.getX() - x;
        double diffY = point.getY() - y;
        return Math.sqrt(Math.pow(diffX,2)+Math.pow(diffY,2));
    }
}
