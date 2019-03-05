package com.azaharia.observer;

import com.azaharia.observer.model.MyModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyObserver implements PropertyChangeListener {

    public MyObserver(MyModel model) {
        model.addChangeListener(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Changed property: " + evt.getPropertyName() + " [old -> "
                + evt.getOldValue() + "] | [new -> " + evt.getNewValue() +"]");
    }
}
