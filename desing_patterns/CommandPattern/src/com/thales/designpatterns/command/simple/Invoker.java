package com.thales.designpatterns.command.simple;

public class Invoker implements Runnable {
    Command command;

    public Invoker(Command command){
        this.command = command;
    }


    @Override
    public void run() {
        command.execute();
    }
}
