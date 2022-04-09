package Scenes;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import Data.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Page_FacilityUsage {
  @SuppressWarnings("unchecked")
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver,
                               boolean managerOrNot) {
    Scene scene;
    BorderPane borderPane = new BorderPane();
    LocalDate today = LocalDate.now();
    int currentTime = LocalTime.now().getHour();

    DecimalFormat formatter = new DecimalFormat("00");

    Text pageTitle = new Text ("View Facility Usage");
    pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));    //changed word font to Arial, size in 30
    pageTitle.setFill(Color.BLACK); //set title color to black

    HBox titleBar = new HBox();        // renamed all Hbox variable to titleBar
    titleBar.getChildren().add(pageTitle);
    titleBar.setAlignment(Pos.TOP_CENTER);  //centralize title  (new)
    titleBar.setPadding(new Insets(5, 10, 5, 10));      // set value from 10 to 15

    // menu bar
    Button btn_FacilityManagement = new Button("Facility Management");
    btn_FacilityManagement.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_FacilityManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ResidentManagement = new Button("Resident Management");
    btn_ResidentManagement.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_ResidentManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_MakeReservation = new Button("Make Reservation");
    btn_MakeReservation.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_MakeReservation.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_FacilityUsage = new Button("View Facility Usage");
    btn_FacilityUsage.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_FacilityUsage.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_CheckIn = new Button("Check In / Out");
    btn_CheckIn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_CheckIn.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_DashBoard = new Button("Manager Dashboard");
    btn_DashBoard.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_DashBoard.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    // dashboard button only shown to manager
    HBox hBox_Menu = new HBox();
    if (managerOrNot){
      hBox_Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, btn_FacilityUsage,btn_CheckIn, btn_DashBoard);
    } else {
      hBox_Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, btn_FacilityUsage,btn_CheckIn);
    }
    hBox_Menu.setAlignment(Pos.CENTER);
    hBox_Menu.setPadding(new Insets(5,10,5,10));

    VBox TopBar = new VBox();
    TopBar.getChildren().addAll(titleBar, hBox_Menu);
    TopBar.setAlignment(Pos.CENTER);

    borderPane.setTop(TopBar);
    borderPane.getTop().setStyle("-fx-background-color: \n" +
            "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
            "        linear-gradient(#020b02, #3a3a3a),\n" +
            "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
            "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
            "    -fx-background-insets: 0,1,4,5;\n" +
            "    -fx-background-radius: 9,8,5,4;\n" +
            "    -fx-padding: 15 30 15 30;\n" +
            "    -fx-font-family: \"Helvetica\";\n" +
            "    -fx-font-size: 18px;\n" +
            "    -fx-font-weight: bold;\n" +
            "    -fx-text-fill: #333333;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");   //set from SteelBlue to grey

    //Assign the actions for each button
    btn_FacilityManagement.setOnAction(e-> {
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_ResidentManagement.setOnAction(e-> {
      primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_MakeReservation.setOnAction(e->{
      primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_CheckIn.setOnAction(e-> {
      primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_DashBoard.setOnAction(e-> {
      primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_FacilityUsage.setDisable(true);
    
    // Page bottom
    // back button
    Button btn_Back = new Button("Back");
    btn_Back.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
    btn_Back.setStyle("-fx-background-color: \n" +
            "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
            "        linear-gradient(#020b02, #3a3a3a),\n" +
            "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
            "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
            "    -fx-background-insets: 0,1,4,5;\n" +
            "    -fx-background-radius: 9,8,5,4;\n" +
            "    -fx-padding: 15 30 15 30;\n" +
            "    -fx-font-family: \"Helvetica\";\n" +
            "    -fx-font-size: 18px;\n" +
            "    -fx-font-weight: bold;\n" +
            "    -fx-text-fill: #333333;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
    HBox hBox_Button = new HBox(10);
    hBox_Button.setAlignment(Pos.CENTER);
    hBox_Button.getChildren().addAll(btn_Back);
    hBox_Button.setPadding(new Insets(15, 10, 15, 10));
    borderPane.setBottom(hBox_Button);
    borderPane.getBottom().setStyle("-fx-background-color: Grey;");
    
    //back button handling
    btn_Back.setOnAction(e->{
      primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, managerOrNot));
    });

    //Page center
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10, 10, 10, 10));
    borderPane.setCenter(grid);

    Label label_SystemTime = new Label("System time: "+ LocalTime.now());
    label_SystemTime.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    grid.add(label_SystemTime, 0,0);

    //Initialise facility table
    ObservableList<Facility> observableList_Facility = FXCollections.observableArrayList(dataDriver.getFacilityArrayList());
    TableView<Facility> table_Facility = new TableView<Facility>();
    table_Facility.setItems(observableList_Facility);
    TableColumn<Facility,String> column_FacilityId = new TableColumn<Facility,String>("Facility ID");
    column_FacilityId.setCellValueFactory(new PropertyValueFactory<>("facilityID"));

    TableColumn<Facility,String> Column_FacilityName = new TableColumn<Facility,String>("Facility Name");
    Column_FacilityName.setCellValueFactory(new PropertyValueFactory<>("facilityName"));

    TableColumn<Facility,String> column_OccupiedOrNot = new TableColumn<Facility,String>("Occupied");
    column_OccupiedOrNot.setCellValueFactory(facility->{
      //Status: true means in use(i.e. someone checked in) false means not in use
      if (facility.getValue().getStatus()) {
        return new ReadOnlyStringWrapper("Yes");
      } else {
        return new ReadOnlyStringWrapper("No");
      }
    });
    TableColumn<Facility,String> column_FacilityBooking = new TableColumn<Facility,String>("Booked");
    column_FacilityBooking.setCellValueFactory(facility->{
      if (facility.getValue().checkTimeslotBooked(today, currentTime)) {
        return new ReadOnlyStringWrapper("Yes");
      } else {
        return new ReadOnlyStringWrapper("No");
      }
    });

    table_Facility.getColumns().setAll(column_FacilityId, Column_FacilityName, column_OccupiedOrNot, column_FacilityBooking);
    table_Facility.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    table_Facility.setPrefWidth(800);
    grid.add(table_Facility, 0, 1);

    scene = new Scene(borderPane,1400,700);
    return scene;
  }
}