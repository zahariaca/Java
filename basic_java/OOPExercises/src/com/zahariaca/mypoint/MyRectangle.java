package com.zahariaca.mypoint;

/**
 * Created by azaharia on 01.06.2016.
 */
public class MyRectangle {
    private MyPoint topLeft = new MyPoint();
    private MyPoint bottomRight = new MyPoint();
    private MyPoint topRight = new MyPoint();
    private MyPoint bottomLeft = new MyPoint();

    public MyPoint getTopLeft() {
        return topLeft;
    }
    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }
    public MyPoint getBottomRight() {
        return bottomRight;
    }
    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }
    public MyPoint getTopRight() {
        return topRight;
    }
    public void setTopRight(MyPoint topRight) {
        this.topRight = topRight;
    }
    public MyPoint getBottomLeft() {
        return bottomLeft;
    }
    public void setBottomLeft(MyPoint bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public MyRectangle(){}
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight){
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
        setTopRight();
        setBottomLeft();
    }
    public MyRectangle(double x1, double y1, double x2, double y2){
        topLeft.setXY(x1,y1);
        bottomRight.setXY(x2,y2);
        setTopRight();
        setBottomLeft();
    }

    public void setTopRight(){
        topRight.setXY(bottomRight.getX(),topLeft.getY());
    }
    public void setBottomLeft(){
        bottomLeft.setXY(topLeft.getX(), bottomRight.getY());
    }

    public String toString(){
        return "MyRectangle[ topLeft=" +getTopLeft() +
                ", topRight=" + getTopRight() +
                ", bottomLeft="+getBottomLeft()+
                ", bottomRight="+getBottomRight()+
                ", perimeter="+getPerimeter()+
                ", area="+getArea() +" ]";
    }

    public double getPerimeter(){
        return 2*(topLeft.distance(topRight) + topLeft.distance(bottomLeft));
    }
    public double getArea(){
        return topLeft.distance(topRight) * topLeft.distance(bottomLeft);
    }
}
