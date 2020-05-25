package com.azaharia.observer.main;

import com.azaharia.observer.MyObserver;
import com.azaharia.observer.model.MyModel;

public class Main {

    public static void main(String[] args) {
        MyModel model = new MyModel();
        MyObserver observer = new MyObserver(model);
        // we change the last name of the person, observer will get notified
        for (MyModel.Person person : model.getPersons()) {
            person.setLastName(person.getLastName() + "1");
        }
        // we change the name of the person, observer will get notified
        for (MyModel.Person person : model.getPersons()) {
            person.setFirstName(person.getFirstName() + "1");
        }

        for (MyModel.Person person : model.getPersons()) {
            System.out.println(person.getFirstName());
        }
    }
}
