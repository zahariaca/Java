package com.zahariaca.mypoint;


/**
 * Created by azaharia on 01.06.2016.
 */
public class MyCircle {
    private MyPoint center = new MyPoint(0,0);
    private double radius = 1;

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCenterX(){
        return center.getX();
    }
    public void setCenterX(double x){
        center.setX(x);
    }
    public double getCenterY(){
        return center.getY();
    }
    public void setCenterY(double y){
        center.setY(y);
    }
    public double[] getCenterXY(){
        return center.getXY();
    }
    public void setCenterXY(double x, double y){
        center.setXY(x,y);
    }


    public MyCircle(double x, double y, double radius){
        center = new MyPoint(x,y);
        this.radius = radius;
    }
    public MyCircle(MyPoint point, double radius){
        this.center= point;
        this.radius = radius;
    }

    public String toString(){
        return "MyCircle [radius r= " + radius +
                ", center=" + center.toString() +
                ", area=" + Math.round(getArea()) +
                ", perimeter=" + Math.round(getPerimeter()) + "]";
    }

    public double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
}
