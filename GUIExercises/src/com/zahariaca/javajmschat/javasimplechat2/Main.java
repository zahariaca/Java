//package com.zahariaca.javajmschat.javasimplechat2;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Properties;
//
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.ExceptionListener;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.MessageListener;
//import javax.jms.MessageProducer;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.jms.Topic;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//import com.kaazing.gateway.jms.client.JmsConnectionFactory;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//    TextField location = new TextField();
//    TextField message = new TextField();
//    TextArea messageLog = new TextArea();
//
//    JmsConnectionFactory connectionFactory;
//    Connection connection;
//    MessageConsumer consumer;
//    Session session;
//    MessageProducer producer;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        location.setPrefColumnCount(20);
//        location.autosize();
//        location.setText("ws://localhost:8001/jms");
//
//        message.setPrefColumnCount(20);
//        message.setPrefHeight(50);
//        message.autosize();
//        message.setAlignment(Pos.TOP_LEFT);
//        message.setPromptText("Your message goes here");
//
//        messageLog.setPrefColumnCount(20);
//        messageLog.setPrefHeight(200);
//        messageLog.autosize();
//        messageLog.setPromptText("Your message comes here");
//
//        Button connectBtn = new Button("Connect");
//        connectBtn.setOnAction(event -> {
//            try {
//                connect();
//                logMessage("CONNECTED");
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("JMS EXCEPTION: " +e.getMessage());
//            } catch (NamingException e) {
//                e.printStackTrace();
//                logMessage("NAMING EXCEPTION: " +e.getMessage());
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//                logMessage("URISYNTAX JMSEXCEPTION: " +e.getMessage());
//            }
//        });
//        Button disconnectBtn = new Button("Disconnect");
//        disconnectBtn.setOnAction(event -> {
//            try {
//                disconnect();
//                logMessage("DISCONNECTED");
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " +e.getMessage());
//            }
//        });
//        Button sendBtn = new Button("Send message");
//        sendBtn.setOnAction(event -> {
//            try {
//                sendMessage();
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: ");
//            }
//        });
//
//        Button clearBtn = new Button("Clear chat");
//        clearBtn.setOnAction(event -> clearChat());
//
//        GridPane sendBtnGrid = new GridPane();
//        sendBtnGrid.setVgap(5);
//        sendBtnGrid.setHgap(8);
//        sendBtnGrid.add(sendBtn, 0, 0);
//
//        GridPane clearBtnGrid = new GridPane();
//        clearBtnGrid.setVgap(5);
//        clearBtnGrid.setHgap(8);
//        clearBtnGrid.add(clearBtn, 0, 0);
//
//        GridPane grid = new GridPane();
//        //grid.setGridLinesVisible(true);
//        grid.setPadding(new Insets(5, 5, 5, 5));
//        grid.setVgap(5);
//        grid.setHgap(8);
//        grid.add(location, 0, 0);
//        grid.add(connectBtn, 1, 0);
//        grid.add(disconnectBtn, 1, 1);
//        grid.add(message, 0, 2);
//        grid.add(sendBtnGrid, 1, 2);
//        grid.add(messageLog, 0, 3);
//        grid.add(clearBtnGrid, 1, 3);
//
//        BorderPane pane = new BorderPane();
//        pane.setPadding(new Insets(5, 5, 5, 5));
//        pane.setTop(grid);
//
//
//        Scene scene = new Scene(pane, 390, 340);
//
//        primaryStage.setTitle("SimpleChat");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public void connect() throws JMSException , NamingException, URISyntaxException {
//        // Add the initial context using the InitialContext constructor.
//        Properties props = new Properties();
//        props.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.kaazing.gateway.jms.client.JmsInitialContextFactory");
//        InitialContext ctx = new InitialContext(props);
//
//        // Configure the JMS Client implementation of ConnectionFactory.
//        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
//
//        if (connectionFactory instanceof JmsConnectionFactory) {
//            try {
//                ((JmsConnectionFactory) connectionFactory).setGatewayLocation(new URI("ws://localhost:8001/jms"));
//            } catch (Exception e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " + e.getMessage());
//            }
//
//        }
//
//        connection = connectionFactory.createConnection(null, null);
//        connection.setExceptionListener(new ExceptionListener() {
//            @Override
//            public void onException(JMSException arg0) {
//                arg0.printStackTrace();
//            }
//        });
//
//        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//        Topic topic = (Topic) ctx.lookup("/topic/destination");
//
//        MessageConsumer consumer = session.createConsumer(topic);
//        consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                try {
//                    logMessage("MESSAGE: " + ((TextMessage) message).getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        // Create a MessageConsumer for the specified destination.
//        consumer = session.createConsumer(topic);
//        // Set the session's distinguished message listener.
//        consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                try {
//                    String msg = null;
//                    msg = ((TextMessage) message).getText();
//                    // DEBUG - Print out the message content to console.
//                    System.out.println("The received message: " + msg);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        connection.start();
//
//        try {
//            Thread.sleep(2 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        producer = session.createProducer(topic);
//    }
//
//    public void sendMessage() throws JMSException{
//        TextMessage txtMsg = session.createTextMessage(message.getText());
//        producer.send(txtMsg);
//    }
//
//
//    private void logMessage(String message) {
//        if (messageLog.getPrefColumnCount() > 100) {
//            messageLog.setText(message);
//        } else {
//            messageLog.setText(message + "\n" + messageLog.getText());
//        }
//    }
//
//    private void clearChat(){
//        messageLog.setText("");
//    }
//
//    private void disconnect() throws JMSException{
//        connection.close();
//    }
//}
