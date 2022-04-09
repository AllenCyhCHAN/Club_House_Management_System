package Scenes;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Data.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Page_ManageReservation {
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver,
                               boolean managerOrNot) {
    Scene scene;
    BorderPane borderPane = new BorderPane();

    // Page top
    Text titleText = new Text("Make Reservation");
    titleText.setFont(Font.font("Arial", FontWeight.BOLD, 30));    //changed word font to Arial, size in 30
    titleText.setFill(Color.BLACK); //set title color to black

    HBox hBox_Title = new HBox();        // renamed all Hbox variable to hBox_Title
    hBox_Title.getChildren().add(titleText);
    hBox_Title.setAlignment(Pos.TOP_CENTER);  //centralize title  (new)
    hBox_Title.setPadding(new Insets(5, 10, 5, 10));      // set value from 10 to 15

    // menu bar
    Button btn_FacilityManagement = new Button("Facility Management");
    btn_FacilityManagement.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_FacilityManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_ResidentManagement = new Button("Resident Management");
    btn_ResidentManagement.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_ResidentManagement.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_MakeReservation = new Button("Make Reservation");
    btn_MakeReservation.setFont(Font.font("Arial", FontWeight.BOLD, 16));
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

    HBox Menu = new HBox();
    if (managerOrNot) {
      Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, btn_FacilityUsage, btn_CheckIn, btn_DashBoard);
    } else {
      Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, btn_FacilityUsage, btn_CheckIn);
    }
    Menu.setAlignment(Pos.CENTER);
    Menu.setPadding(new Insets(5, 10, 5, 10));

    VBox TopBar = new VBox();
    TopBar.getChildren().addAll(hBox_Title, Menu);
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
    btn_FacilityManagement.setOnAction(e -> {
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_ResidentManagement.setOnAction(e -> {
      primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_MakeReservation.setDisable(true);

    btn_CheckIn.setOnAction(e -> {
      primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_FacilityUsage.setOnAction(e -> {
      primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_DashBoard.setOnAction(e -> {
      primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, managerOrNot));
    });

    // Page bottom
    Button btn_Submit = new Button("Submit");
    btn_Submit.setStyle("-fx-background-color: \n" +
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
    btn_Submit.setDisable(true); // First disable the button
    
    // back button
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
    HBox hBox_button = new HBox(10);
    hBox_button.setAlignment(Pos.CENTER);
    hBox_button.getChildren().add(btn_Submit);
    hBox_button.getChildren().add(backButton);
    hBox_button.setPadding(new Insets(15, 10, 15, 10));
    borderPane.setBottom(hBox_button);
    borderPane.getBottom().setStyle("-fx-background-color: Grey;");

    // Page center
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(10, 10, 10, 10));
    borderPane.setCenter(grid);

    // Initialise all nodes that will be used
    Label label_Phone = new Label("Member Phone");
    TextField textField_Phone = new TextField();
    Button btn_Search = new Button("Search");
    grid.add(label_Phone, 0, 0);
    grid.add(textField_Phone, 1, 0);
    grid.add(btn_Search, 2, 0);

    Label label_InvalidPhone = new Label("Invalid member phone");
    label_InvalidPhone.setStyle("-fx-text-fill: red;");
    label_InvalidPhone.setVisible(false); // Hide error label on initialisation
    grid.add(label_InvalidPhone, 3, 0);

    Label label_Name = new Label("Member Name");
    ComboBox<String> comboBox_MemberMenu = new ComboBox<String>();
    ObservableList<String> memberObservableList = comboBox_MemberMenu.getItems();
    label_Name.setVisible(false);
    comboBox_MemberMenu.setVisible(false);
    grid.add(label_Name, 0, 1);
    grid.add(comboBox_MemberMenu, 1, 1);

    Label label_Email = new Label("Member Email");
    label_Email.setVisible(false);
    grid.add(label_Email, 0, 2);
    Label label_EmailValue = new Label();
    label_EmailValue.setVisible(false);
    grid.add(label_EmailValue, 1, 2);

    Label label_Facility = new Label("Facility");
    ComboBox<String> comboBox_Facility = new ComboBox<String>();
    ObservableList<String> facilityObservableList = comboBox_Facility.getItems();
    label_Facility.setVisible(false);
    comboBox_Facility.setVisible(false);
    grid.add(label_Facility, 0, 3);
    grid.add(comboBox_Facility, 1, 3);

    // Populate comboBox_Facility
    ArrayList<Facility> facilityArrayList = dataDriver.getFacilityArrayList();
    for (int i = 0; i < facilityArrayList.size(); i++) {
      Facility currentFacility = facilityArrayList.get(i);
      facilityObservableList.add(currentFacility.getFacilityName());
    }

    Label label_Date = new Label("Date");
    DatePicker datePicker = new DatePicker();
    label_Date.setVisible(false);
    datePicker.setVisible(false);
    grid.add(label_Date, 0, 4);
    grid.add(datePicker, 1, 4);

    Label label_Timeslot = new Label("Timeslot");
    ComboBox<String> comboBox_Timeslot = new ComboBox<String>();
    label_Timeslot.setVisible(false);
    comboBox_Timeslot.setVisible(false);
    ObservableList<String> timeslotObservableList = comboBox_Timeslot.getItems();
    grid.add(label_Timeslot, 0, 5);
    grid.add(comboBox_Timeslot, 1, 5);

    ArrayList<Member> memberArrayList = dataDriver.getMemberArrayList();
    btn_Search.setOnAction(e-> {
      String fieldInput = textField_Phone.getText();
      try {
        if (dataDriver.findMemberWithPhone(Integer.parseInt(fieldInput)) != null) {
          label_Name.setVisible(true);
          comboBox_MemberMenu.setVisible(true);

          // there might be memebr using same phone member to register
          // sort member by phone number and display the the name in a drop down list for selection
          ArrayList<String> nameArrayList = new ArrayList<String>();
          ArrayList<Member> repeatMember = new ArrayList<Member>();
          for (int i = 0; i < memberArrayList.size(); i++) {
            Member currentMember = memberArrayList.get(i);
            if (currentMember.getMemberPhone() == Integer.parseInt(fieldInput)) {
              repeatMember.add(currentMember);
              nameArrayList.add(currentMember.getMemberName());
            }
          }
          memberObservableList.clear();
          for (int i=0; i<nameArrayList.size(); i++) {
            memberObservableList.add(nameArrayList.get(i));
          }
        }
      } catch (NumberFormatException exception) {
        label_InvalidPhone.setVisible(true); // erroe label appear if a invalid phone number is entered
        exception.printStackTrace();
      }
    });

    comboBox_MemberMenu.setOnAction(e-> {
      String fieldInput = textField_Phone.getText();
      ArrayList<Member> duplicateMemberArrayList = new ArrayList<Member>();
      for (int i = 0; i < memberArrayList.size(); i++) {
        Member currentMember = memberArrayList.get(i);
        if (currentMember.getMemberPhone() == Integer.parseInt(fieldInput)) {
          duplicateMemberArrayList.add(currentMember);
        }
      }
      Member targetMember = duplicateMemberArrayList.get(comboBox_MemberMenu.getSelectionModel().getSelectedIndex());

      label_EmailValue.setText(targetMember.getMemberEmail());
      label_Email.setVisible(true); // emial address of the member is shown after the selection of member 
      label_EmailValue.setVisible(true);

      label_Facility.setVisible(true);
      comboBox_Facility.setVisible(true);
    });

    //Handle facility selection
    comboBox_Facility.setOnAction(e->{
      //Check if date is already selected
      if (!datePicker.isVisible()) {
        //Make date menu visible
        label_Date.setVisible(true);
        datePicker.setVisible(true);
      } else {
        //Get selected facility and date
        Facility selectedFacility = facilityArrayList.get(comboBox_Facility.getSelectionModel().getSelectedIndex());
        LocalDate selectedDate = datePicker.getValue();

        //Clear available timeslots and disable submit
        timeslotObservableList.clear();
        btn_Submit.setDisable(true);

        //Grab available timeslots
        ArrayList<Integer> availability_ArrayList= dataDriver.facility_Availability_ArrayList(selectedFacility.getFacilityID(), selectedDate);
        //Add timeslot
        for (int i = 0; i < availability_ArrayList.size();i++) {
          int startTime = availability_ArrayList.get(i);
          int endTime = startTime+1;
          DecimalFormat formatter = new DecimalFormat("00");
          String text_StartTime = formatter.format(startTime)+":00";
          String text_EndTime = formatter.format(endTime)+":00";

          timeslotObservableList.add(text_StartTime+" - "+text_EndTime);
        }
      }

    }
    );


    //Handle date selection
    datePicker.setOnAction(e->{
      //Get selected facility and date
      Facility selectedFacility = facilityArrayList.get(comboBox_Facility.getSelectionModel().getSelectedIndex());
      LocalDate selectedDate = datePicker.getValue();

      //Clear availabe timeslots and disable submit
      timeslotObservableList.clear();
      btn_Submit.setDisable(true);

      //Grab available timeslots
      ArrayList<Integer> availabeTimeslots = dataDriver.facility_Availability_ArrayList(selectedFacility.getFacilityID(), selectedDate);
      //Add timeslot
      for (int i = 0; i < availabeTimeslots.size();i++) {
        int startTime = availabeTimeslots.get(i);
        int endTime = startTime+1;
        DecimalFormat formatter = new DecimalFormat("00");
        String text_StartTime = formatter.format(startTime)+":00";
        String text_EndTime = formatter.format(endTime)+":00";


        timeslotObservableList.add(text_StartTime+" - "+text_EndTime);
      }

      //Make timeslots visible
      label_Timeslot.setVisible(true);
      comboBox_Timeslot.setVisible(true);
    });

    //Handle timeslot selection
    comboBox_Timeslot.setOnAction(e->{
      btn_Submit.setDisable(false);
    });

    //Handle submit
    btn_Submit.setOnAction(e->{
      String fieldInput = textField_Phone.getText();
      ArrayList<Member> duplicateMember = new ArrayList<Member>();
      for (int i = 0; i < memberArrayList.size(); i++) {
        Member currentMember = memberArrayList.get(i);
        if (currentMember.getMemberPhone() == Integer.parseInt(fieldInput)) {
          duplicateMember.add(currentMember);
        }
      }
      Member targetMember = duplicateMember.get(comboBox_MemberMenu.getSelectionModel().getSelectedIndex());
      Facility targetFacility = facilityArrayList.get(comboBox_Facility.getSelectionModel().getSelectedIndex());
      LocalDate targetDate = datePicker.getValue();
      ArrayList<Integer> availabilityArrayList = targetFacility.retrieveAvailableTime(targetDate);
      int selectedTime = availabilityArrayList.get(comboBox_Timeslot.getSelectionModel().getSelectedIndex());

      // get the current date & time
      LocalDate now = LocalDate.now();
      int timeNow = LocalTime.now().getHour();

      //Check if the member has booked some other facilities for the timeslot
      if (targetMember.checkTimeslotAvailability(targetDate, selectedTime)) {
        Messagebox.messageBox("Error", "The member has already booked another \nfacility on "+targetDate+" for that timeslot!");
      }
      else if(targetDate.isBefore(now)){
        Messagebox.messageBox("Error", "This timeslot is already expired");
      }
      else if(targetDate.isEqual(now) && selectedTime < timeNow){
        Messagebox.messageBox("Error", "This timeslot is already expired");
      }
      else {
        dataDriver.createReservation(targetMember.getMemberID(), targetFacility.getFacilityID(), targetDate, selectedTime);

        //
        Messagebox.messageBox("Message", "Reservation created");

        //Reset scene
        primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, managerOrNot));
      }
    });

    //Handle back
    backButton.setOnAction(e->{
      primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, managerOrNot));
    });

      scene = new Scene(borderPane,1400,700);
    return scene;
  }
}
