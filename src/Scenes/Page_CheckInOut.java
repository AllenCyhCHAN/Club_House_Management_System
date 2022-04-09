package Scenes;

import Data.DataDriver;
import Data.Member;
import Data.Reservation;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Page_CheckInOut {
    @SuppressWarnings("unchecked")
    public static Scene getScene(Stage primaryStage,
                                 DataDriver dataDriver,
                                 boolean isManager) {
        BorderPane borderPane = new BorderPane();
        Scene scene;
        Text pageTitle = new Text ("Check In ");
        pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));    //changed word font to Arial, size in 30
        pageTitle.setFill(Color.BLACK); //set title color to black

        HBox titleBar = new HBox();        // renamed all Hbox variable to titleBar
        titleBar.getChildren().add(pageTitle);
        titleBar.setPadding(new Insets(5, 10, 5, 10));
        titleBar.setAlignment(Pos.TOP_CENTER);  //centralize title  (new)

        // menu bar
        Button facilityMGMT = new Button("Facility Management");
        facilityMGMT.setFont(Font.font("Arial",FontWeight.BOLD, 16));
        facilityMGMT.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button residentMGMT = new Button("Resident Management");
        residentMGMT.setFont(Font.font("Arial",FontWeight.BOLD, 16));
        residentMGMT.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button makeReservation = new Button("Make Reservation");
        makeReservation.setFont(Font.font("Arial",FontWeight.BOLD, 16));
        makeReservation.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button facilityUsage = new Button("View Facility Usage");
        facilityUsage.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        facilityUsage.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button checkIn = new Button("Check In / Out");
        checkIn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        checkIn.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button dashBoard = new Button("Manager DashBoard");
        dashBoard.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        dashBoard.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        
        // dashboard button onlt shown to manager
        HBox Menu = new HBox();
        if (isManager){
            Menu.getChildren().addAll(facilityMGMT, residentMGMT, makeReservation, facilityUsage,checkIn, dashBoard);
        } else {
            Menu.getChildren().addAll(facilityMGMT, residentMGMT, makeReservation, facilityUsage,checkIn);
        }
        Menu.setAlignment(Pos.CENTER);
        Menu.setPadding(new Insets(5,10,5,10));

        VBox TopBar = new VBox();
        TopBar.getChildren().addAll(titleBar, Menu);
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
        facilityMGMT.setOnAction(e-> {
            primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, isManager));
        });

        residentMGMT.setOnAction(e-> {
            primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, isManager));
        });

        dashBoard.setOnAction(e-> {
            primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, isManager));
        });

        checkIn.setDisable(true);

        makeReservation.setOnAction(e->{
            primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, isManager));
        });

        facilityUsage.setOnAction(e-> {
            primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, isManager));
        });


        // Bottom part for putting the check-in/ check-out button
        Button btn_CheckIn = new Button("Check-In");
        btn_CheckIn.setStyle("-fx-background-color: \n" +
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
        btn_CheckIn.setDisable(true); // disable first and unlock until a booked reservation is selected

        Button btn_CheckOut = new Button("Check-Out");
        btn_CheckOut.setStyle("-fx-background-color: \n" +
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
        btn_CheckOut.setDisable(true); // disable first and unlock until a checked-in reservation is selected

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: \n" +
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
        hBox_Button.getChildren().addAll(btn_CheckIn,btn_CheckOut,backButton);
        hBox_Button.setPadding(new Insets(10,10,10,10));
        borderPane.setBottom(hBox_Button);
        borderPane.getBottom().setStyle("-fx-background-color: Grey;");

        // Center part 
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(grid);

        
        // Initialise all nodes that will be used
        Label label_MemberId = new Label("Member ID");
        TextField textField_TextField = new TextField();
        Button btn_Search = new Button("Search");
        Label label_InvalidId = new Label("Invalid member ID");
        label_InvalidId.setVisible(false); // Hide error label on initialisation
       
        HBox hBox_SearchMember = new HBox(10);
        hBox_SearchMember.setAlignment(Pos.CENTER_RIGHT);
        hBox_SearchMember.getChildren().addAll(label_MemberId,textField_TextField,btn_Search);
        grid.add(hBox_SearchMember, 1,0);
        grid.add(label_InvalidId, 2,0);

        //Set up the reservations table for check-in and check-out
        TableView<Reservation> tableview_Reservation = new TableView<Reservation>();
        
        TableColumn<Reservation,String> column_ReservationId = new TableColumn<Reservation,String>("Reservation ID");
        column_ReservationId.setCellValueFactory(new PropertyValueFactory<>("reservationID"));
        
        TableColumn<Reservation,String> column_Facility = new TableColumn<Reservation,String>("Booked Facility");
        column_Facility.setCellValueFactory(reservation->{
            int facilityId = reservation.getValue().getReservation_FacilityID();
            String facilityName = dataDriver.findFacilityWithID(facilityId).getFacilityName();
            return new ReadOnlyStringWrapper(facilityName);});

        TableColumn<Reservation,String> dateColumn = new TableColumn<Reservation,String>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        TableColumn<Reservation,String> timeColumn = new TableColumn<Reservation,String>("Reserved time");
        timeColumn.setCellValueFactory(reservation->{
            int startTime = reservation.getValue().getTime();
            String timeText = Integer.toString(startTime)+":00" + "-" + Integer.toString(startTime+1)+":00";
            return new ReadOnlyStringWrapper(timeText);
        });
        TableColumn<Reservation,String> tableColumn_Status = new TableColumn<Reservation,String>("Status");
        tableColumn_Status.setCellValueFactory(reservation->{
          String status = reservation.getValue().getStatus();
          if (status.equals("Booked")) {
              return new ReadOnlyStringWrapper("Booked");
          } else if (status.equals("Checked In")) { 
              return new ReadOnlyStringWrapper("Checked In");
          } else {
              return new ReadOnlyStringWrapper("Checked Out");}});
        
        tableview_Reservation.getColumns().setAll(column_ReservationId, column_Facility, dateColumn, timeColumn, tableColumn_Status);
        tableview_Reservation.setPrefWidth(800);
        tableview_Reservation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        grid.add(tableview_Reservation, 0, 1,2,1);

        // Id searching button handler
        btn_Search.setOnAction(e->{
            String fieldInput = textField_TextField.getText();
            try {
              if (dataDriver.findMemberWithID(Integer.parseInt(fieldInput)) != null) { //verify member id exist
                    Member selectedMember = dataDriver.findMemberWithID(Integer.parseInt(fieldInput));
                    ObservableList<Reservation> reservationObservables = FXCollections.observableArrayList(selectedMember.getReservations());
                    tableview_Reservation.setItems(reservationObservables);
                    btn_CheckIn.setDisable(false);
                    btn_CheckOut.setDisable(false);}
                else {label_InvalidId.setVisible(true);
                  label_InvalidId.setText("Invalid member ID.");
                  label_InvalidId.setStyle("-fx-text-fill: red;");
                    ;}}
            catch(Exception exception) {
              label_InvalidId.setVisible(true);
              btn_CheckIn.setDisable(true);}
        });

        // Check-in button handler
        btn_CheckIn.setOnAction(e->{
            if (tableview_Reservation.getSelectionModel().isEmpty()) {
                Messagebox.messageBox("Error", "Please select a reservation.");
            } else {
                // member can check-in earlier 
                if (tableview_Reservation.getSelectionModel().getSelectedItem().getStatus().equals("Booked")) {
                    Reservation targetReservation = tableview_Reservation.getSelectionModel().getSelectedItem();
                    dataDriver.checkIn(targetReservation.getReservationID());
                    Messagebox.messageBox("Success", "Check-in Successfully!");
                    
                    primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, isManager));
                    
                    tableColumn_Status.setCellValueFactory(reservation->{
                      if (reservation.getValue().getStatus().equals("Booked")) {return new ReadOnlyStringWrapper("Booked");}
                      else if (reservation.getValue().getStatus().equals("Checked In")) {return new ReadOnlyStringWrapper("Checked In");}
                      else {return new ReadOnlyStringWrapper("Checked Out");}
                    });

                } else {
                    Messagebox.messageBox("Error", "This reservation had already checked in before.");
                }
            }
        });
        
        // check-out button handler
        btn_CheckOut.setOnAction(e->{
            if (tableview_Reservation.getSelectionModel().isEmpty()) {
                Messagebox.messageBox("Error", "Please select a reservation.");
            } else {
                if (tableview_Reservation.getSelectionModel().getSelectedItem().getStatus().equals("Checked In")) {
                    Reservation targetReservation = tableview_Reservation.getSelectionModel().getSelectedItem();
                    dataDriver.checkOut(targetReservation.getReservationID());
                    Messagebox.messageBox("Success", "Check-out Successful!");
                    primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, isManager));
                } else {
                    Messagebox.messageBox("Error", "This reservation has not been checked-in or has already checked out.");}
            }
        });

        //Handle back
        backButton.setOnAction(e->{
            primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, isManager));
        });

        scene = new Scene(borderPane,1400,700);
        return scene;
    }
}
