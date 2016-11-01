package com.azaharia.abstractfactorypattern.factorypattern.facotry.colors;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.AbstractFactory;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.Shape;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
    @Override
    public Color getColor(String colorType){
        if (colorType == null){
            return null;
        }
        if (colorType.equalsIgnoreCase("RED")){
            return new Red();
        }else if (colorType.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        return null;
    }
}
