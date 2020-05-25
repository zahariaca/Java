import com.kaazing.net.ws.*;

import java.io.IOException;
import java.net.InterfaceAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 6/28/2016.
 */

public class WSClient {


    public static void main(String[] args) {

        ValidatingArgs validate;
        if(args.length ==3) {
            validate = new ValidatingArgs(args[0], args[1], args[2]);
        } else{
            throw new IllegalArgumentException("Invalid number of arguments: correct usage of program is : [nr. of connections]  [gateway URI]  [\"message to be sent\"]");
        }

        if(validate.isValid()) {
            // Create a new WebSocket object
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Initializing thread: " + Thread.currentThread());
                        connectAndSend(args[1], args[2]);
                    }
                }).start();
            }
        }
    }

    private static void connectAndSend(String gwUri, String gwMessage) {
        WebSocket ws = null;
        try {
            WebSocketFactory wsFactory = WebSocketFactory.createWebSocketFactory();
            ws = wsFactory.createWebSocket(URI.create(gwUri));
            System.out.println("Before connect");
            ws.connect(); // This will block or throw an exception if failed.
            System.out.println("After connect");


            WebSocketMessageWriter writer = ws.getMessageWriter();

            // Send messages using a for loop to alternate between text and binary messages
            while(true) {
                Thread.sleep(100); //only used to delay the sending of messages
                String text = gwMessage + " ->  " + timestampt() ;
                writer.writeText(text);   // Send text message
                System.out.println("Message sent " + gwMessage +  " -> " +timestampt());

                /*
                // For even numbered loops, send text
                if ((j % 2) == 0) {
                    writer.writeText(text);   // Send text message
                } else {
                    // For odd numbered loops, send binary
                    ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
                    writer.writeBinary(buffer);   // Send binary message
                }
                */

                // Use the getMessageReader() method
/*                WebSocketMessageReader reader = ws.getMessageReader();

                WebSocketMessageType type = null; // Block until a message arrives
                while ((type = reader.next()) != WebSocketMessageType.EOS) { // Loop until the connection is closed
                    switch (type) {
                        // Run if type is TEXT
                        case TEXT:
                            CharSequence text2 = reader.getText();
                            System.out.println("RECEIVED TEXT MESSAGE: " + text2.toString());
                            break;

                        // Run if type is BINARY
                        case BINARY:
                            ByteBuffer buffer = reader.getBinary();
                            System.out.println("RECEIVED BINARY MESSAGE: " + getHexDump(buffer)); // see getHexDump() below
                            break;
                    }
                }*/
            }
        } catch (WebSocketException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION 1: " + e.getMessage()); //when connections is dropped this throws an exception
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("EXCEPTION 2: " + ex.getMessage()); //only used for testing, won't throw anything because it is a super of WebSocketException
        } finally {
            try {
                ws.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getHexDump(ByteBuffer buf) {
        if (buf.position() == buf.limit()) {
            return "empty";
        }

        StringBuilder hexDump = new StringBuilder();
        for (int i = buf.position(); i < buf.limit(); i++) {
            hexDump.append(Integer.toHexString(buf.get(i) & 0xFF)).append(' ');
        }
        return hexDump.toString();
    }

    private static String timestampt(){
        String timeStamp;
        Date date= new java.util.Date();
        return timeStamp = new SimpleDateFormat("HH:mm:ss.ms").format(new Date());
    }

}
