package Scenes;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox; 
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

// class for making a meesage box with inputed title and message
public class Messagebox{
   public static void messageBox(String title,
                                 String message ){
    Stage messageBox = new Stage();
    
    messageBox.initModality(Modality.APPLICATION_MODAL);
    messageBox.setTitle(title);
    messageBox.setResizable(true);
    
    Text text_Message = new Text(message);
      
    Button btn_Close= new Button("Close");
    
    VBox vBox_Text= new VBox(10);
    vBox_Text.getChildren().add(text_Message);
    vBox_Text.setAlignment(Pos.CENTER);
    
    VBox vBox_button= new VBox(10);
    vBox_button.getChildren().add(btn_Close);
    vBox_button.setAlignment(Pos.CENTER);
    
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(20,30,20,30));
    pane.add(vBox_Text,0,0);
    pane.add(vBox_button,0,1);
    pane.setVgap(10);
    
    Scene messageScene= new Scene(pane);

    btn_Close.setOnAction(e -> {
        messageBox.close(); });

    messageBox.setScene(messageScene);
    messageBox.showAndWait();}}