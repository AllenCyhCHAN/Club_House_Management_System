package Scenes;

import Data.DataDriver;
import Data.Staff;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.effect.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Page_LogIn {
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver) {
        StackPane bgPane = new StackPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setPadding(new Insets(25,25,25,25));
        

        Text title = new Text ("HandShake Residence Clubhouse");
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        Reflection reflection = new Reflection();
        reflection.setFraction(0.4f);
        title.setEffect(reflection);
        title.setFill(Color.WHITE);
        grid.add(title, 0, 0, 10, 3);
        
        
        Text title2 = new Text ("       Management System");
        title2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        Reflection r2 = new Reflection();
        r2.setFraction(0.4f);
        title2.setEffect(r2);
        title2.setFill(Color.WHITE);
        grid.add(title2, 0, 0, 10, 8);

        //Textfield for the staffID
        Label label_Id = new Label("Staff Id:");
        label_Id.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
        label_Id.setTextFill(Color.BLACK);
        grid.add(label_Id, 50, 2);
        TextField textField_Id = new TextField();
        grid.add(textField_Id, 52, 2);

        //Password field for the staffPW
        Label label_Password = new Label("Password:");
        label_Password.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL,20));
        label_Password.setTextFill(Color.BLACK);
        grid.add(label_Password, 50, 4);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 52, 4);

        Button btn_login = new Button("Login");
        HBox hBox_Button = new HBox(10);
        hBox_Button.setAlignment(Pos.BOTTOM_RIGHT);
        hBox_Button.getChildren().add(btn_login);
        grid.add(hBox_Button, 52, 6);
                     

        //Login button
        btn_login.setOnAction(e-> {
            String id = textField_Id.getText();
            Staff.setId(id);
            String password = passwordField.getText();
            Staff.setPassword(password);
            try {
                int role = Staff.StaffChecking("CSV/staffdata.csv");
                if (role == 1){  //Manager
                    primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, true)); //Enter the MainPage with dashboard
                } else if (role == 0) { //Normal staff
                    primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, false)); //Enter the MainPage without dashboard
                } else {
                    Messagebox.messageBox("Error", "your input is invalid! Please input again."); //Show the popup window
                  //Clear the input
                  textField_Id.clear();
                  passwordField.clear();
              }

            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        //Set the background image for the pane
        ImageView backgroundImage = new ImageView(new Image("Images/loginbg.jpg",1500,1000,false,false));
        bgPane.getChildren().addAll(backgroundImage,grid);
        Scene loginScene = new Scene(bgPane,1400,700);
        return loginScene;
  }  

}