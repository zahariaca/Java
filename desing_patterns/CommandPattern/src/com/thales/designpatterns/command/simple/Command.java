package com.thales.designpatterns.command.simple;

public class Command {
    Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

    public void execute(){
        receiver.action();
    }
}
