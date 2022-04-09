package Scenes;

import java.text.DecimalFormat;
import java.util.ArrayList;
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

public class Page_Facility {
  @SuppressWarnings("unchecked")
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver,
                               boolean managerOrNot) {
    Scene scene;
    BorderPane borderPane = new BorderPane();
    ArrayList<Facility> facilitiesList = dataDriver.getFacilityArrayList();
    
    // Page top
    Text pageTitle = new Text ("Facility Management");
    pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));    //changed word font to Arial, size in 30
    pageTitle.setFill(Color.BLACK); //set title color to black

    HBox titleBar = new HBox();        // renamed all Hbox variable to titleBar
    titleBar.getChildren().add(pageTitle);
    titleBar.setAlignment(Pos.TOP_CENTER);  //centralize title  (new)
    titleBar.setPadding(new Insets(5, 10, 5, 10));      // set value from 10 to 15
    
    // menu bar
    Button btn_ToFacilityManagement = new Button("Facility Management");
    btn_ToFacilityManagement.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_ToFacilityManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ToResidentManagement = new Button("Resident Management");
    btn_ToResidentManagement.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_ToResidentManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ToMakeReservation = new Button("Make Reservation");
    btn_ToMakeReservation.setFont(Font.font("Arial",FontWeight.BOLD, 16));
    btn_ToMakeReservation.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ToFacilityUsage = new Button("View Facility Usage");
    btn_ToFacilityUsage.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_ToFacilityUsage.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ToCheckIn = new Button("Check In / Out");
    btn_ToCheckIn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_ToCheckIn.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ToDashBoard = new Button("Manager Dashboard");
    btn_ToDashBoard.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_ToDashBoard.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    
    // dashboard button only shown for manager
    HBox Menu = new HBox();
    if (managerOrNot){
      Menu.getChildren().addAll(btn_ToFacilityManagement, btn_ToResidentManagement, btn_ToMakeReservation, btn_ToFacilityUsage,btn_ToCheckIn, btn_ToDashBoard);
    } else {
      Menu.getChildren().addAll(btn_ToFacilityManagement, btn_ToResidentManagement, btn_ToMakeReservation, btn_ToFacilityUsage,btn_ToCheckIn);
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
    btn_ToFacilityManagement.setDisable(true);
    
    btn_ToResidentManagement.setOnAction(e-> {
      primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
    });
    
    btn_ToMakeReservation.setOnAction(e->{
      primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, managerOrNot));
    });
    
    btn_ToCheckIn.setOnAction(e-> {
      primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, managerOrNot));
    });
    
    btn_ToFacilityUsage.setOnAction(e-> {
      primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, managerOrNot));
    });
    
    btn_ToDashBoard.setOnAction(e-> {
      primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, managerOrNot));
    });



    //Back button
    Button backBtn = new Button("Back");
    backBtn.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
    backBtn.setStyle("-fx-background-color: \n" +
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
    HBox btnHBox = new HBox(10);
    btnHBox.setAlignment(Pos.CENTER);
    btnHBox.getChildren().addAll(backBtn);
    btnHBox.setPadding(new Insets(15, 10, 15, 10));
    borderPane.setBottom(btnHBox);
    borderPane.getBottom().setStyle("-fx-background-color: Grey;");

    //Page center
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10, 10, 10, 10));
    borderPane.setCenter(grid);

    //Add, modify and delete button
    Button btn_Add = new Button("Add");
    Button btn_Modify = new Button("Modify");
    Button btn_Delete = new Button("Delete");

    // create a row to put the buttons on the top of gridPane
    HBox hBox_ForBtns = new HBox(10);
    hBox_ForBtns.setAlignment(Pos.TOP_RIGHT);
    hBox_ForBtns.getChildren().addAll(btn_Add, btn_Modify, btn_Delete);
    grid.add(hBox_ForBtns, 0, 0);

    //Facility table
    ObservableList<Facility> facilityObservableList = FXCollections.observableArrayList(facilitiesList);
    TableView<Facility> tableView_Facility = new TableView<Facility>();
    tableView_Facility.setItems(facilityObservableList);

    TableColumn<Facility,String> column_FacilityID = new TableColumn<Facility,String>("Facility ID");
    column_FacilityID.setCellValueFactory(new PropertyValueFactory<>("facilityID"));

    TableColumn<Facility,String> column_Name = new TableColumn<Facility,String>("Name");
    column_Name.setCellValueFactory(new PropertyValueFactory<>("facilityName"));

    TableColumn<Facility,String> column_Rent = new TableColumn<Facility,String>("Rent");
    column_Rent.setCellValueFactory(new PropertyValueFactory<Facility, String>("rent"));

    TableColumn<Facility,String> column_OpeningHour = new TableColumn<Facility,String>("Open Time");
    column_OpeningHour.setCellValueFactory(facility->{
      int openingTime = facility.getValue().getOpeningHour();
      DecimalFormat formatter = new DecimalFormat("00");
      String string = formatter.format(openingTime)+":00";
      return new ReadOnlyStringWrapper(string);
    });
    TableColumn<Facility,String> column_ClosingHour = new TableColumn<Facility,String>("Close Time");
    column_ClosingHour.setCellValueFactory(facility->{
      int closingTime = facility.getValue().getClosingHour();
      DecimalFormat formatter = new DecimalFormat("00");
      String string = formatter.format(closingTime)+":00";
      return new ReadOnlyStringWrapper(string);
    });
    TableColumn<Facility,String> column_Description = new TableColumn<Facility,String>("Descriptions");
    column_Description.setCellValueFactory(new PropertyValueFactory<Facility, String>("description"));

    tableView_Facility.getColumns().setAll(column_FacilityID, column_Name, column_Rent, column_OpeningHour, column_ClosingHour, column_Description);
    tableView_Facility.setPrefWidth(800);
    tableView_Facility.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    grid.add(tableView_Facility, 0, 1);

    //Handle add
    btn_Add.setOnAction(e->{
      Page_AddFacility.addNewFacilitypage("Enter New Facility's Information", dataDriver);
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    //Handle edit
    btn_Modify.setOnAction(e->{
      if (tableView_Facility.getSelectionModel().getSelectedItem() != null) {
        Page_EditFacility.editFacilityPage("Modify facility", dataDriver, tableView_Facility.getSelectionModel().getSelectedItem(),400, 300);
        primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
      } else {
        Messagebox.messageBox("Error", "You must select a facility in order to make any changes.");
      }
    });

    //Handle remove
    btn_Delete.setOnAction(e->{
      if (tableView_Facility.getSelectionModel().getSelectedItem() != null) {
        int facilityID = tableView_Facility.getSelectionModel().getSelectedItem().getFacilityID();
        dataDriver.deleteFacility(facilityID);
        Messagebox.messageBox("Message", "The facility and its reservations has been deleted.");
        primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
     } else {
        Messagebox.messageBox("Error", "You must first select a facility in order to delete it.");
      }
    });

    //Handle back
    backBtn.setOnAction(e->{
      primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, managerOrNot));
    });

    scene = new Scene(borderPane,1400,700);
    return scene;
  }
}