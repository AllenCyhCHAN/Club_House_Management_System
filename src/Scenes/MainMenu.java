package Scenes;

import Data.DataDriver;
import javafx.scene.Scene;
import javafx.stage.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.geometry.*;

public class MainMenu {

    public static Scene getScene(Stage primaryStage,
                                 DataDriver dataDriver,
                                 boolean isManager) {

        Scene mainMenu;
        StackPane backgroundStackPane = new StackPane();

        // function button
        Button btn_Facility = new Button("Facility Management");
        btn_Facility.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_Facility.setMinSize(300,100);
        btn_Facility.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btn_ResidentManagement = new Button("Resident Management");
        btn_ResidentManagement.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_ResidentManagement.setMinSize(300,100);
        btn_ResidentManagement.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btReservation = new Button("Make Reservation");
        btReservation.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btReservation.setMinSize(300,100);
        btReservation.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btn_CheckIn = new Button("Check in");
        btn_CheckIn.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_CheckIn.setMinSize(300,100);
        btn_CheckIn.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btn_Usage = new Button("View Facility Usage");
        btn_Usage.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_Usage.setMinSize(300,100);
        btn_Usage.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btn_Dashboard = new Button("Manager Dashboard");
        btn_Dashboard.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_Dashboard.setMinSize(300,100);
        btn_Dashboard.setStyle("-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

        Button btn_LogOut = new Button("Log out");
        btn_LogOut.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        btn_LogOut.setMinSize(150,50);
        btn_LogOut.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");
        
        // put the functions horizontally
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(btn_Facility, btn_ResidentManagement );
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(50);
        
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(btReservation, btn_Usage);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(50);
        
        // dashboard button will only shown for manager
        HBox hb3 = new HBox();
        if (isManager){
            hb3.getChildren().addAll(btn_CheckIn, btn_Dashboard);
        } else {
            hb3.getChildren().add(btn_CheckIn);
        }

        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(50);

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(btn_LogOut);

        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(50);

        VBox vb = new VBox();
        vb.getChildren().addAll(hb1,hb2,hb3,hb4);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(50);
        
        // event handler for functions button
        btn_Facility.setOnAction(e-> {
          primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, isManager));
        });
        
        btn_ResidentManagement.setOnAction(e-> {
          primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, isManager));
        });
        
        btReservation.setOnAction(e->{
          primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, isManager));
        });
        
        btn_CheckIn.setOnAction(e-> {
          primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, isManager));
        });
        
        btn_Usage.setOnAction(e-> {
          primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, isManager));
        });

        btn_Dashboard.setOnAction(e->{
          primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, isManager));
        });
        
        btn_LogOut.setOnAction(e->{
          primaryStage.setScene(Page_LogIn.getScene(primaryStage, dataDriver));
        });

        //Set the background image for the pane
        ImageView bg = new ImageView(new Image("Images/background.png",1600,800,false,false));
        backgroundStackPane.getChildren().addAll(bg,vb);
        mainMenu = new Scene(backgroundStackPane,1400,700);
        return mainMenu;
    }
}
