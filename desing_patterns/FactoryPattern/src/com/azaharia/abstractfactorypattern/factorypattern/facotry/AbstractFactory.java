package com.azaharia.abstractfactorypattern.factorypattern.facotry;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.colors.Color;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.Shape;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String colorType);
}
