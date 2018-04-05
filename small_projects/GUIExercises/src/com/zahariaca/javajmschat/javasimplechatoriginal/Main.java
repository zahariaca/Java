//package com.zahariaca.javajmschat.javasimplechatoriginal;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Properties;
//
////Importam librariile javax si Kaazing Websocket necesare realizarii conexiunii
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
//import com.kaazing.gateway.jms.client.JmsConnectionFactory;
//
////Importam librariile JavaFX pentru GUI
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
//    //Declaram variabilele pentru casutele de text GUI
//    TextField location = new TextField();
//    TextField message = new TextField();
//    TextArea messageLog = new TextArea();
//
//    //Declaram variabile pentru realizarea conexiunii si pentru schimbul de mesaje
//    JmsConnectionFactory connectionFactory;
//    Connection connection;
//    MessageConsumer consumer;
//    Session session;
//    MessageProducer producer;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        //Primul text field cu proprietatile lui
//        location.setPrefColumnCount(1);
//        location.autosize();
//        location.setText("ws://localhost:8001/jms");
//
//        //Al 2-lea text field cu propritetatile lui
//        message.setPrefColumnCount(20);
//        message.setPrefHeight(50);
//        message.autosize();
//        message.setAlignment(Pos.TOP_LEFT);
//        message.setPromptText("Your message goes here");
//
//        //Zona unde apare outputul de text
//        messageLog.setPrefColumnCount(20);
//        messageLog.setPrefHeight(200);
//        messageLog.autosize();
//        messageLog.setPromptText("Your message comes here");
//
//        //Buton de conectare cu functionalitatea lui, foloseste o lambda expression si metoda connect() si metoda logMessage pentru a printa in messageLog "CONNECTED" in momentul in care se realizeaza conexiunea
//        //Inconjuram in try-catch pentru a prinde eventualel exceptii cand conexiunea nu poate fi realizata,folosim logMessage sa printam acele exceptii in casuta de mesaje
//        Button connectBtn = new Button("Connect");
//        connectBtn.setOnAction(event -> {
//            try {
//                connect();
//                logMessage("CONNECTED");
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("JMS EXCEPTION: " + e.getMessage());
//            } catch (NamingException e) {
//                e.printStackTrace();
//                logMessage("NAMING EXCEPTION: " + e.getMessage());
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//                logMessage("URISYNTAX JMSEXCEPTION: " +e.getMessage());
//            }
//        });
//
//        //Buton de deconectare cu functionalitatea lui, foloseste o lambda expression si metoda disconnect() si metoda logMessage pentru a printa in messageLog "DISCONNECTED" in momentul in care se inchide conexiunea
//        //Inconjuram in try-catch pentru a prinde eventualel exceptii cand conexiunea nu poate fi inchisa corect,folosim logMessage sa printam acele exceptii in casuta de mesaje
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
//
//        //Buton de trimis mesaje, foloseste o lambda expression si metoda sendMessage()
//        //Inconjuram in try-catch pentru a prinde eventualele exceptii cand mesajul nu poate fi trimis,folosim logMessage sa printam acele exceptii in casuta de mesaje
//        Button sendBtn = new Button("Send message");
//        sendBtn.setOnAction(event -> {
//            try {
//                sendMessage();
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " + e.getMessage());
//            }
//        });
//
//        //Butonul de sters mesaje din casuta de mesaje, foloseste o lambda expression si metoda clearChat()
//        //Nu este necesar try-catch deoarece metoda clearChat atribuie unei variabile String un string gol si atribuie acea variabila String casutei de mesaje messageLog
//        Button clearBtn = new Button("Clear chat");
//        clearBtn.setOnAction(event -> clearChat());
//
//
//        //GUI cu JavaFX
//
//        //declaram un GridPane pentru sendBtn
//        GridPane sendBtnGrid = new GridPane();
//        sendBtnGrid.setVgap(5); //setam distanta verticala
//        sendBtnGrid.setHgap(8); //setam distanta orizontala
//        sendBtnGrid.add(sendBtn, 0, 0); //pozitionam butonul de send in GridPane, la pozita (0,0)
//
//        //declaram un GridPane pentru clearBtn
//        GridPane clearBtnGrid = new GridPane();
//        clearBtnGrid.setVgap(5); //setam distanta verticala
//        clearBtnGrid.setHgap(8); //setam distanta orizontala
//        clearBtnGrid.add(clearBtn, 0, 0); //pozitionam butonul de clear in GridPane, la pozita (0,0)
//
//        //declaram un GridPane principal pentru elementele GUI
//        GridPane grid = new GridPane();
//        //grid.setGridLinesVisible(true); //Pentru debuggin facem vizibile liniile grid-ului
//        grid.setPadding(new Insets(5, 5, 5, 5));    //setam padding de 5 de jur imprejur
//        grid.setVgap(5); //setam distanta verticala
//        grid.setHgap(8); //setam distanta orizontala
//        grid.add(location, 0, 0); //pozitionam casuta de location in GridPane, la pozita (0,0)
//        grid.add(connectBtn, 1, 0); //pozitionam butonul de conect in GridPane, la pozita (1,0)
//        grid.add(disconnectBtn, 1, 1); //pozitionam butonul de disconect in GridPane, la pozita (1,1)
//        grid.add(message, 0, 2); //pozitionam casuta de message in GridPane, la pozita (0,2)
//        grid.add(sendBtnGrid, 1, 2); //pozitionam GridPane-ul declarat mai sus pentru sendBtn, in acest GridPane la pozitia (1,2)
//        grid.add(messageLog, 0, 3); //pozitionam casuta de messageLog in GridPane, la pozita (0,3)
//        grid.add(clearBtnGrid, 1, 3); //pozitionam GridPane-ul declarat mai sus pentru sendBtn, in acest GridPane la pozitia (1,3)
//
//        //declaram un BorderPane pentru centrarea corecta a GridPane-ului principal declarat mai sus
//        BorderPane pane = new BorderPane();
//        pane.setPadding(new Insets(5, 5, 5, 5)); //setam padding de 5 de jur imprejur
//        pane.setTop(grid); //pozitionam in BorderPane, GridPane-ul(grid) in pozitia Top a BorderPane-ului
//
//        //declaaram un Scene nou pentru GUI, ii atribuim BorderPane-ul mai sus declarat (pane) si setam marimea ferestrei la 390 si 340 pixeli
//        Scene scene = new Scene(pane, 390, 340);
//
//        //( Stage declarat in atributele acestei metode start(Stage primaryStage) )
//        primaryStage.setTitle("SimpleChat"); //setam titlul pentru primaryStage
//        primaryStage.setScene(scene); //setam Scene-ul principal pentru primaryStage, scene declarat mai sus ca scene
//        primaryStage.show(); //facem vizibil acest Stage in momentul in care rula aplicatia
//
//    }
//
//    //functia main, care foloseste o singura metoda - launch(args) -- necesara GUI JavaFX
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    //functia connect, care realizeaza conexiunea la gateway-ul Kaazing
//    public void connect() throws JMSException , NamingException, URISyntaxException {
//
//        //  Declaram conetextul initial folosind INITIAL_CONTEXT_FACTORY
//        Properties props = new Properties();
//        props.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.kaazing.gateway.jms.client.JmsInitialContextFactory");
//        InitialContext ctx = new InitialContext(props);
//        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
//
//        //verificam daca variabila membru declarata mai sus este o instanta a JmsConnectionFactory, daca este intr-am in block-ul try-catch
//        if (connectionFactory instanceof JmsConnectionFactory) {
//            try {
//                ((JmsConnectionFactory) connectionFactory).setGatewayLocation(new URI(location.getText())); //Facem un typecast variabilei connectionFactory ca JmsConnectionFactor
//                                                                                                            // si setam URI-ul conexiunii ca fiind cel declarat de noi in casuta de text location
//            } catch (Exception e) {      //prindem exceptiile in cazul in care nu putem sa atribuim URI conexiunii si printam exceptia cu metoda logMessage() in casuta de messageLog
//                e.printStackTrace();
//                logMessage("EXCEPTION: " + e.getMessage());
//            }
//
//        }
//
//        //creem conexiunea
//        connection = connectionFactory.createConnection(null, null);
//        //setam un exception listener pentru variabila membru connection, printam StackTrace - ul in consola in cazul in care ceva nu merge bine
//        connection.setExceptionListener(new ExceptionListener() {
//            @Override
//            public void onException(JMSException arg0) {
//                arg0.printStackTrace();
//            }
//        });
//
//        //creem o sesiune pentru conexiunea mai sus realizata si atribuim aceasta sesiune variabilei membru session mai sus declarata
//        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//        //declaram o variabila de tip Topic si ii atribuim ctx.lookup tot de tip Topic cu topicul si destinatia
//        //(in cazul nostru declarata static ca fiind "/topic/destination" ) la care vrem sa aderam pentru trimiterea si primirea mesajelor
//        //Pentru a trimite/priomi mesajele 2 clienti trebuie sa fie aderati la acelasi topic
//        Topic topic = (Topic) ctx.lookup("/topic/destination");
//
//        //atribuim variabile membru producer sesiunea si topicul mai sus declarate
//        producer = session.createProducer(topic);
//
//        //creem un consumer de tip MessageConsumer caruia ii atribuim sesiunea si topicul mai sus declarate.
//        MessageConsumer consumer = session.createConsumer(topic);
//
//        //obiectul consumer foloseste metoda setMessageListener, care la randul ei foloseste un lambda expression pentru a primi/trimite mesaje
//        consumer.setMessageListener(message1 -> {
//            try {
//                logMessage("MESSAGE: " + ((TextMessage) message1).getText()); //folosim metoda logMessage pentru a printa mesaje in casuta messageLog din GUI
//            } catch (JMSException e) {
//                e.printStackTrace();
//                logMessage("EXCEPTION: " + e.getMessage());  //prindem exceptiile in cazul in care nu putem sa trimitem mesaje, si printam exceptia in casuta messageLog
//            }
//        });
//
//        //pornim conexiunea efectiva
//        connection.start();
//
//        try {
//            Thread.sleep(2 * 1000); //asteptam 2 secunde pana la pornirea conexiunii
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    //metoda care se ocupa de trimiterea mesajelor
//    public void sendMessage() throws JMSException{
//        TextMessage txtMsg = session.createTextMessage(message.getText()); //declaram o variabila de tip TextMessage si ii atribuim un mesaj creat in sesiunea curenta, mesaje provenit din causta de message din GUI
//        producer.send(txtMsg); //spunem producereului sa trimita mesajul mai sus declarat
//    }
//
//    //metoda de logare a mesajelor
//    private void logMessage(String message) {
//        //verificam daca este sau nu plina casuta de mesaje
//        if (messageLog.getPrefColumnCount() > 100) {
//            messageLog.setText(message); //daca este schimbam variabila messageLog cu textul mesajului curent
//        } else {
//            messageLog.setText(message + "\n" + messageLog.getText()); // daca nu este facem append la mesajele anteriaoare cu mesajul curent
//        }
//    }
//
//    //metoda simpla clear chat, inlocuieste textul din messageLog cu un String gol
//    private void clearChat(){
//        messageLog.setText("");
//    }
//
//    //metoda simpla disconnect, face call metodei close() pe variabila connection mai sus declarata
//    private void disconnect() throws JMSException{
//        connection.close();
//    }
//}
