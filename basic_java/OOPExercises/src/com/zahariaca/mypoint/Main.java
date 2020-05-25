package com.zahariaca.mypoint;

public class Main {

    public static void main(String[] args) {
        //useMyPoint();
        //useMyCircle();
        useMyTriangle();
        //useMyRectangle();

    }

    private static void useMyRectangle() {
        MyPoint topLeft = new MyPoint(2,4);
        MyPoint bottomRight = new MyPoint(5,2);
        MyRectangle r1 = new MyRectangle(topLeft, bottomRight);
        MyRectangle r2 = new MyRectangle(2,4,5,2);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
    }

    private static void useMyTriangle() {
        MyPoint v1 = new MyPoint(2,3);
        MyPoint v2 = new MyPoint(0,0);
        MyPoint v3 = new MyPoint(4, 0);
        MyTriangle tr1 = new MyTriangle(v1,v2,v3);
        MyTriangle tr2 = new MyTriangle(10,10,20,20,30,30);
        System.out.println(tr1.toString());
        System.out.println(tr2.toString());
        System.out.println(v1.distance(v2));
        System.out.println(v1.distance(v3));
        System.out.println(v3.distance(v2));
    }

    private static void useMyCircle() {
        MyPoint point = new MyPoint(20,20);
        MyCircle circle = new MyCircle(10, 10, 1);
        MyCircle circle2 = new MyCircle(point, 2);
        System.out.println(circle.toString());
        System.out.println(circle2.toString());
    }

    static void useMyPoint(){
        MyPoint point = new MyPoint(10,10);
        System.out.println(point.toString());
        System.out.println(point.distance());
        System.out.println(point.distance(0,0));
        MyPoint point2 = new MyPoint(0,0);
        System.out.println(point.distance(point2));

        MyPoint[] points = new MyPoint[10];
        for(int i=0; i<points.length; i++){
            points[i] = new MyPoint(i+1,i+1);
            System.out.println(points[i].toString());
        }
    }
}
