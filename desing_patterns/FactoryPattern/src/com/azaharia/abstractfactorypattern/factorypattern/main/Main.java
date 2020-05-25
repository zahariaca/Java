package com.azaharia.abstractfactorypattern.factorypattern.main;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.Shape;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.ShapeFactory;

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
