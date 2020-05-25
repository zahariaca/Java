package com.thales.designpatterns.command.simple;

public class Receiver {
    String name;
    public boolean state = false;

    public Receiver(String name) {
        this.name = name;
    }

    public void action(){
        System.out.println("[" + Thread.currentThread() + "]" + "executed command on: " + this);
        state = true;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "name='" + name + '\'' +
                '}';
    }
}
