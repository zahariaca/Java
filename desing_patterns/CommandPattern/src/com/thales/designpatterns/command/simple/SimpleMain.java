package com.thales.designpatterns.command.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleMain {

    public static void main(String[] args) {
        Receiver receiverOne = new Receiver("Receiver:ASA_DEM_345");
        Command commandOne = new Command(receiverOne);

        Invoker switchCommandRunnable = new Invoker(commandOne);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(switchCommandRunnable);

    }

}
