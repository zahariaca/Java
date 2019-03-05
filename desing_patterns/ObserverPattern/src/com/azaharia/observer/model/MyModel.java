package com.azaharia.observer.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModel {
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    private List<Person> persons = new ArrayList<Person>();
    private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

    public class Person{
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName(){
            return firstName;
        }

        public void setFirstName(String firstName){
            notifyListeners(this, FIRST_NAME, this.firstName, firstName);
        }

        public String getLastName(){
            return lastName;
        }

        public void setLastName(String lastName){
            notifyListeners(this, LAST_NAME, this.lastName, lastName);
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public MyModel() {
        // just for testing we hard-code the persons here:
        persons.add(new Person("Lars", "Vogel"));
        persons.add(new Person("Jim", "Knopf"));
    }

    private void notifyListeners(Object object, String property, String oldValue, String newValue) {
        for (PropertyChangeListener name : listeners) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void addChangeListener(PropertyChangeListener listener){
        listeners.add(listener);
    }
}
