package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on ${DATE}.
 */

public class Controller {
    @FXML
    TextArea textArea;
    public void handleFileButton() {
    }
    public void handleSave(){
        BufferedWriter writer = null;
        System.out.println(textArea.getText());
        try {
            writer = new BufferedWriter(new FileWriter("new file.txt"));
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(writer != null){
                try{
                    writer.flush();
                    writer.close();
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void handleOpen() {
        try {
            List<String> list = Files.readAllLines(Paths.get("new file.txt"));
            for (String str : list){
                System.out.println(str);
                textArea.appendText(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
