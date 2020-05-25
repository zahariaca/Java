package com.azaharia.factorypattern.main;

import com.azaharia.factorypattern.facotry.Shape;
import com.azaharia.factorypattern.facotry.ShapeFactory;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        shapeFactory.getShape("CIRCLE").draw();
    }
}
