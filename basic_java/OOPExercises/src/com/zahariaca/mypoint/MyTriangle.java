package com.zahariaca.mypoint;

/**
 * Created by azaharia on 01.06.2016.
 */
public class MyTriangle {
    private MyPoint v1 = new MyPoint();
    private MyPoint v2 = new MyPoint();
    private MyPoint v3 = new MyPoint();

    public MyPoint getV1() {
        return v1;
    }

    public void setV1(MyPoint v1) {
        this.v1 = v1;
    }

    public MyPoint getV2() {
        return v2;
    }

    public void setV2(MyPoint v2) {
        this.v2 = v2;
    }

    public MyPoint getV3() {
        return v3;
    }

    public void setV3(MyPoint v3) {
        this.v3 = v3;
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        v1.setXY(x1,y1);
        v2.setXY(x2,y2);
        v3.setXY(x3,y3);
    }

    public String toString(){
        return "MyTriangle[ v1=" + v1.toString() +
                ", v2=" +v2.toString() +
                ", v3=" +v3.toString() +
                ", perimeter=" + Math.round(getPerimeter())+
                ", type=" +getType() + " ]";
    }
    public double getPerimeter(){
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }
    public String getType(){
        String str = "";
        if (v1.distance(v2) == v2.distance(v3) && v1.distance(v2) == v1.distance(v3) && v3.distance(v1) == v3.distance(v2)){
            str = "Equilateral";
        }else if (v1.distance(v2) == v2.distance(v3) || v1.distance(v3) == v2.distance(v3)){
            str = "Isosceles";
        }else{
            str = "Scalene";
        }
        return str;
    }

}
