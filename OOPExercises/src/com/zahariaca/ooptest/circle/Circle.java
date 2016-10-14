package com.zahariaca.ooptest.circle;

/**
 * Created by azaharia on 31.05.2016.
 */
public class Circle {
    private double radius;
    private String color;

    public double getRadius(){ return radius; }
    public void setRadius(double radius){ this.radius = radius;}
    public String getColor(){ return color;}
    public void setColor(String color){ this.color = color;}

    public Circle(){
        radius = 1.0;
        color = "red";
    }
    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString(){
        return "Circle [radius= " + radius + " color= " + color + " area: " + getArea()+ " ]";
    }
}
