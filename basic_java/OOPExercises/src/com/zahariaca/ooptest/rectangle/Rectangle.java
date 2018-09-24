package com.zahariaca.ooptest.rectangle;

/**
 * Created by azaharia on 31.05.2016.
 */
public class Rectangle {
    private float length;
    private float width;

    public float getLength(){return length;}
    public void setLength(float length){this.length = length;}
    public float getWidth(){return width;}
    public void setWidth(float width){this.width = width;}

    public Rectangle(){}
    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*(length+width);
    }

    public String toString(){
        return "Rectangle[ length= " + length + " | width= " + width + " its area = " + getArea() + " its perimeter= " +getPerimeter() + ". ]";
    }
}
