package com.zahariaca;

import com.pi4j.io.gpio.*;

import java.util.Scanner;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Robert Savage
 */
public class Main {

    private static volatile boolean continueCondition = true;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        final GpioController gpio = GpioFactory.getInstance();


        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "Pin_17", PinState.LOW);
        final GpioPinDigitalOutput pin18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "Pin_18", PinState.LOW);
        final GpioPinDigitalOutput pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Pin_22", PinState.LOW);
        final GpioPinDigitalOutput ping23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "Pin_23", PinState.LOW);


        // set shutdown state for this pin
        pin17.setShutdownOptions(true, PinState.LOW);
        pin18.setShutdownOptions(true, PinState.LOW);
        pin22.setShutdownOptions(true, PinState.LOW);
        ping23.setShutdownOptions(true, PinState.LOW);


        System.out.println("--> GPIO state should be: off");

//        pin17.low();


        Scanner scanner = new Scanner(System.in);

        while(continueCondition) {
            System.out.println("Please input (forward/backward/quit): ");
            String userInput = scanner.nextLine();

            if ("quit".equals(userInput)) {
                continueCondition = false;
                continue;
            }

            if ("forward".equals(userInput)) {
                System.out.println("GOING FORWARD!");
                pin17.toggle();
                pin18.low();
                pin22.toggle();
                ping23.low();
            } else if ("backward".equals(userInput)) {
                System.out.println("GOING BACKWARD!");
                pin17.low();
                pin18.toggle();
                pin22.low();
                ping23.toggle();
            }

            Thread.sleep(2000);
            pin17.low();
            pin18.low();
            pin22.low();
            ping23.low();
        }

        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }
}