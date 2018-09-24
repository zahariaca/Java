package com.azaharia.abstractfactorypattern.factorypattern.facotry;

import com.azaharia.abstractfactorypattern.factorypattern.facotry.colors.ColorFactory;
import com.azaharia.abstractfactorypattern.factorypattern.facotry.shapes.ShapeFactory;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 10/31/2016.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if ( choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
