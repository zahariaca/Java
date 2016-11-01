package com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.AbstractFactory;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.colors.Color;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
