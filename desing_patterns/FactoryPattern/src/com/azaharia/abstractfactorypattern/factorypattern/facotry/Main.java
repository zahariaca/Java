package com.azaharia.abstractfactorypattern.factorypattern.facotry;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.colors.Color;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.Shape;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = FactoryProducer.getFactory("SHAPE").getShape("CIRCLE");
        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color1 = colorFactory.getColor("RED");
        color1.fill();
        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();
        Color color3 = FactoryProducer.getFactory("COLOR").getColor("RED");
        color3.fill();
        FactoryProducer.getFactory("COLOR").getColor("GREEN").fill();

    }
}
