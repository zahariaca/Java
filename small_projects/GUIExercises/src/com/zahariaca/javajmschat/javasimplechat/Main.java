//package com.zahariaca.javajmschat.javasimplechat;
//
//import java.net.PasswordAuthentication;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//    InitialContext ctx;
//
//    TextField location = new TextField();
//    TextField subscription = new TextField();
//    TextField message = new TextField();
//    TextArea messageLog = new TextArea();
//
//    JmsConnectionFactory connectionFactory;
//    Connection connection;
//    MessageConsumer consumer;
//    Session session;
//    Topic topic;
//    MessageProducer producer;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        location.setPrefColumnCount(20);
//        location.autosize();
//        location.setText("ws://10.2.56.25:8000/jms");
//
//        subscription.autosize();
//        subscription.setText("/topic/destination");
//
//        message.setPrefColumnCount(20);
//        message.autosize();
//        message.setAlignment(Pos.TOP_LEFT);
//        message.setPromptText("Your message goes here");
//
//        messageLog.setPrefColumnCount(20);
//        messageLog.setPrefHeight(200);
//        messageLog.setMinWidth(350);
//        messageLog.autosize();
//        messageLog.setWrapText(true);
//        messageLog.setEditable(false);
//        messageLog.setPromptText("Your message comes here");
//
//        Button connectBtn = new Button("Connect");
//        connectBtn.setOnAction(event -> {
//
//            if (connectBtn.getText().equals("Connect")) {
//                try {
//                    connect();
//                    logMessage(timestampt() + " - CONNECTED");
//                    connectBtn.setText("Disconnect");
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                    logMessage(timestampt() + " - JMS EXCEPTION: " +e.getMessage());
//                } catch (NamingException e) {
//                    e.printStackTrace();
//                    logMessage(timestampt() + " - NAMING EXCEPTION: " +e.getMessage());
//                } catch (URISyntaxException e) {
//                    e.printStackTrace();
//                    logMessage(timestampt() + " - URISYNTAX EXCEPTION: " +e.getMessage());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    logMessage(timestampt() + " - JMS EXCEPTION: " +e.getMessage());
//                }
//            }else if(connectBtn.getText().equals("Disconnect")){
//                try {
//                    disconnect();
//                    connectBtn.setText("Connect");
//                    logMessage(timestampt() + " - DISCONNECTED");
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                    logMessage(timestampt() + " - EXCEPTION: " +e.getMessage());
//                }
//            }
//        });
///*        Button disconnectBtn = new Button("Disconnect");
//        disconnectBtn.setOnAction(event -> {
//            try {
//                disconnect();
//                logMessage("DISCONNECTED");
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " +e.getMessage());
//            }
//        });*/
//        Button sendBtn = new Button("Send message");
//        sendBtn.setOnAction(event -> {
//            try {
//                sendMessage();
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage(timestampt() + " - EXCEPTION: " + e.getMessage());
//            }
//        });
//
//        Button subscribeBtn = new Button("Subscribe");
//        subscribeBtn.setOnAction(event -> {
//            try {
//                subscription();
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage(timestampt() + " - EXCEPTION: " + e.getMessage());
//            } catch (NamingException e) {
//                e.printStackTrace();
//                logMessage( timestampt() + " - EXCEPTION: " + e.getMessage());
//            }
//        });
//
//        Button clearBtn = new Button("Clear chat");
//        clearBtn.setOnAction(event -> clearChat());
//
//        Button test = new Button("TEST");
//        test.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                LoginDialog test = new LoginDialog();
//                test.display();
//            }
//        });
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
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(5);
//        grid.setHgap(8);
//        grid.add(location, 0, 0);
//        grid.add(connectBtn, 1, 0);
//        //grid.add(disconnectBtn, 1, 1);
//        grid.add(subscription, 0,2);
//        grid.add(subscribeBtn, 1,2);
//        grid.add(message, 0, 3);
//        grid.add(sendBtnGrid, 1, 3);
//        grid.add(messageLog, 0, 4);
//        grid.add(clearBtnGrid, 1, 4);
//        grid.add(test, 1, 5);
//
//        Scene scene = new Scene(grid, 480, 340);
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
//
//    }
//
//    public void connect() throws InterruptedException, JMSException , NamingException, URISyntaxException, ConnectionDroppedException {
//        // Add the initial context using the InitialContext constructor.
//        Properties props = new Properties();
//        props.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.kaazing.gateway.jms.client.JmsInitialContextFactory");
//        ctx = new InitialContext(props);
//
//        // Configure the JMS Client implementation of ConnectionFactory.
//        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
//
//        if (connectionFactory instanceof JmsConnectionFactory) {
//            try {
//                ((JmsConnectionFactory) connectionFactory).setGatewayLocation(new URI(location.getText()));
//                ChallengeHandler challengeHandler = createChallengeHandler(location.getText());
//                WebSocketFactory webSocketFactory = ((JmsConnectionFactory) connectionFactory).getWebSocketFactory();
//                webSocketFactory.setDefaultChallengeHandler(challengeHandler);
//                webSocketFactory.setDefaultRedirectPolicy(HttpRedirectPolicy.SAME_DOMAIN);
//            } catch (Exception e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " + e.getMessage());
//            }
//
//        }
//
//        connection = connectionFactory.createConnection(null, null);
//
//        connection.setExceptionListener(new ExceptionListener() {
//            @Override
//            public void onException(JMSException e) {
//                e.printStackTrace();
//                Main.this.logMessage("EXCEPTION: " + e.getMessage());
//            }
//        });
//
//        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//        connection.start();
//        while(true){
//            if(connection == null){
//                System.out.println("AJBFKAIBGFKAUBNFNAF");
//            }
//        }
//
///*        try {
//            Thread.sleep(2 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }*/
//    }
//
//    public void subscription() throws JMSException, NamingException{
//
//        try {
//            topic = (Topic) ctx.lookup(subscription.getText());
//            logMessage(timestampt() + " - Subscribed to destination: "+ subscription.getText() );
//        } catch (NamingException e) {
//            e.printStackTrace();
//            logMessage(timestampt() + " - EXCEPTION: " +e.getMessage());
//        }
//
//        MessageConsumer consumer = session.createConsumer(topic);
//        consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                try {
//                    logMessage(timestampt() + " - SENT MESSAGE: " + ((TextMessage) message).getText());
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
//                    logMessage(timestampt() + " - RECEIVED MESSAGE: " + msg);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        producer = session.createProducer(topic);
//    }
//
//    private void sendMessage() throws JMSException{
//        try {
//            TextMessage txtMsg = session.createTextMessage(message.getText());
//            producer.send(txtMsg);
//        } catch (JMSException e) {
//            e.printStackTrace();
//            logMessage(timestampt() + " - EXCEPTION: " + e.getMessage());
//        } catch (NullPointerException e){
//            e.printStackTrace();
//            logMessage(timestampt() + " - EXCEPTION: Topic =" + e.getMessage() + ". Subscribe to a topic!");
//        }
//    }
//
//
//    private void logMessage(String message) {
//        if (messageLog.getText().length() > 400) {
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
//
//    private String timestampt(){
//        String timeStamp;
//        Date date= new java.util.Date();
//        return timeStamp = new SimpleDateFormat("HH:mm:ss.ms").format(new Date());
//    }
//
//    private ChallengeHandler createChallengeHandler(String location) {
//        final LoginHandler loginHandler = new LoginHandler() {
//            private String username;
//            private char[] password;
//
//            @Override
//            public PasswordAuthentication getCredentials() {
//                try {
//                    // pop up a login dialog and wait for user input
//                    LoginDialog login = new LoginDialog();
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            //login.display();
//                            //username = login.getUsername();
//                            //password = login.getPassword().toCharArray();
//                            username = "joe";
//                            password = "welcome".toCharArray();
//                        }
//                    });
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    throw e;
//                }
//                return new PasswordAuthentication(username, password);
//            }
//        };
//        BasicChallengeHandler challengeHandler = BasicChallengeHandler.create();
//        challengeHandler.setLoginHandler(loginHandler);
//        return challengeHandler;
//    }
//
//}
