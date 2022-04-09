package Scenes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

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

public class Page_ManagerDashboard {
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver,
                               boolean managerOrNot) {
    Scene scene;
    BorderPane borderPane = new BorderPane();
    ArrayList<Facility> facilityArrayList = new ArrayList<>(dataDriver.getFacilityArrayList());
    Collections.sort(facilityArrayList);

    // Page top
    Text pageTitle = new Text ("Manager Dashboard");
    pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
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

    Button Dashboard = new Button("Manager Dashboard");
    Dashboard.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    Dashboard.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Dashboard.setDisable(true);

    HBox Menu = new HBox();
    Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, btn_FacilityUsage,btn_CheckIn, Dashboard);
    Menu.setAlignment(Pos.CENTER);
    Menu.setPadding(new Insets(5,10,5,10));

    VBox TopBar = new VBox();
    TopBar.getChildren().addAll(pageTitle, Menu);
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

    Button btn_Back = new Button("Back");
    btn_Back.setFont(Font.font("Arial",FontWeight.BOLD, 20));   //new set back button font
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
            "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");  //(new) set bottom color

    HBox bottomBar = new HBox(20);
    bottomBar.setAlignment(Pos.CENTER);
    bottomBar.getChildren().addAll(btn_Back);
    bottomBar.setPadding(new Insets(15, 10, 15, 10));
    borderPane.setBottom(bottomBar);
    borderPane.getBottom().setStyle("-fx-background-color: Grey;");  //(new) set bottom color

    //Page center
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    grid.setHgap(20);
    grid.setVgap(20);
    grid.setPadding(new Insets(10, 10, 10, 10));
    borderPane.setCenter(grid);

    //Initialise reservation table
    ObservableList<Reservation> reservationObservableList = FXCollections.observableArrayList(dataDriver.getReservationArrayList());
    TableView<Reservation> tableView_Reservation = new TableView<Reservation>();
    tableView_Reservation.setItems(reservationObservableList);
    
    TableColumn<Reservation,String> Column_ResId = new TableColumn<Reservation,String>("Reservation ID");
    Column_ResId.setCellValueFactory(new PropertyValueFactory<>("reservationID"));

    TableColumn<Reservation,String> Column_MemId = new TableColumn<Reservation,String>("Member ID");
    Column_MemId.setCellValueFactory(new PropertyValueFactory<>("reservation_MemberID"));

    TableColumn<Reservation,String> column_Facility = new TableColumn<Reservation,String>("Booked Facility");
    column_Facility.setCellValueFactory(reservation->{
      int facID = reservation.getValue().getReservation_FacilityID();
      String facilityName = dataDriver.findFacilityWithID(facID).getFacilityName();
      return new ReadOnlyStringWrapper(facilityName);
    });

    TableColumn<Reservation,String> dateColumn = new TableColumn<Reservation,String>("Date");
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    
    TableColumn<Reservation,String> timeColumn = new TableColumn<Reservation,String>("Time");
    timeColumn.setCellValueFactory(reservation->{
      int startTime = reservation.getValue().getTime();
      DecimalFormat formatter = new DecimalFormat("00");
      String startTimestr = formatter.format(startTime)+" : 00";
      String endTimestr = formatter.format(startTime + 1)+" : 00";
      String reservation_Time = startTimestr +" - "+endTimestr;
      return new ReadOnlyStringWrapper(reservation_Time);
    });
    TableColumn<Reservation,String> statusColumn = new TableColumn<Reservation,String>("Status");  //changed from time to status
    statusColumn.setCellValueFactory(reservation->{
      if (reservation.getValue().getStatus().equals("Booked")) {
        return new ReadOnlyStringWrapper("booked");
      } else if (reservation.getValue().getStatus().equals("Checked In")) {
        return new ReadOnlyStringWrapper("signed-in");
      } else {
        return new ReadOnlyStringWrapper("signed-out");
      }
    });
    
    Label reservation_table_Title = new Label("Reservation Table : ");
    reservation_table_Title.setFont(Font.font("Arial",FontWeight.BOLD, 20));
    grid.add(reservation_table_Title, 0, 1);

    tableView_Reservation.getColumns().setAll(Column_ResId, Column_MemId, column_Facility, dateColumn, timeColumn, statusColumn);
    tableView_Reservation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tableView_Reservation.setPrefWidth(600); //just fit size of table
    grid.add(tableView_Reservation, 0, 2);
    
    //Initialise utilisation rate table
    ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilityArrayList);
    TableView<Facility> tableView_Utilization = new TableView<Facility>();
    tableView_Utilization.setItems(facilityObservableList);

    TableColumn<Facility,String> column_FacName = new TableColumn<Facility,String>("Facility Name");
    column_FacName.setCellValueFactory(new PropertyValueFactory<>("facilityName"));

    TableColumn<Facility,String> Column_UtilRate = new TableColumn<Facility,String>("Utilisation Rate");
    Column_UtilRate.setCellValueFactory(facility->{
      double utilisationRate = facility.getValue().getUtilisationRate_PreviousMonth();
      DecimalFormat formatter = new DecimalFormat("##0.00%");
      String utilisationRateString = formatter.format(utilisationRate);

      return new ReadOnlyStringWrapper(utilisationRateString);
    });

    TableColumn<Facility, String> rankColumn = new TableColumn<>("Popularity Ranking");
    rankColumn.setCellValueFactory(facility->{
      int rank = facilityArrayList.indexOf(facility.getValue())+1;
      return new ReadOnlyStringWrapper(String.valueOf(rank));
    });

    tableView_Utilization.getColumns().setAll(column_FacName, Column_UtilRate, rankColumn);
    tableView_Utilization.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    tableView_Utilization.setPrefWidth(250);
    Label utilisationTable_Title = new Label("Utilisation Rate of Facilities in the Past 30 Days : ");
    utilisationTable_Title.setFont(Font.font("Arial",FontWeight.BOLD, 15));
    grid.add(utilisationTable_Title, 2, 1);
     
    grid.add(tableView_Utilization, 2, 2);

    //Handle back
    btn_Back.setOnAction(e->{
      primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_FacilityManagement.setOnAction(e->{
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_ResidentManagement.setOnAction(e->{
      primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_FacilityManagement.setOnAction(e->{
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_MakeReservation.setOnAction(e->{
      primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_FacilityUsage.setOnAction(e->{
      primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_CheckIn.setOnAction(e->{
      primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, managerOrNot));
    });

    scene = new Scene(borderPane,1400,700);
    return scene;
  }
}