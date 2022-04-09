package Scenes;

import java.util.ArrayList;
import Data.*;
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

public class Page_ManageMember {
  @SuppressWarnings("unchecked")
  public static Scene getScene(Stage primaryStage,
                               DataDriver dataDriver,
                               boolean managerOrNot) {
    Scene scene;
    BorderPane borderPane = new BorderPane();
    ArrayList<Member> memberArrayList = dataDriver.getMemberArrayList();

    // Page top
    Text pageTitle = new Text ("Resident Management");
    pageTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));    //changed word font to Arial, size in 30
    pageTitle.setFill(Color.BLACK); //set title color to black

    HBox hBox_Title = new HBox();        // renamed all Hbox variable to hBox_Title
    hBox_Title.getChildren().add(pageTitle);
    hBox_Title.setAlignment(Pos.TOP_CENTER);  //centralize title  (new)
    hBox_Title.setPadding(new Insets(5, 10, 5, 10));      // set value from 10 to 15

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

    Button btn_CheckIn = new Button("Check in / Out");
    btn_CheckIn.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_CheckIn.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    Button btn_Dashboard = new Button("Manager Dashboard");
    btn_Dashboard.setFont(Font.font("Arial", FontWeight.BOLD, 16));
    btn_Dashboard.setStyle("-fx-background-color: \n" +
            "        #c3c4c4,\n" +
            "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
            "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
            "    -fx-background-radius: 30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

    HBox Menu = new HBox();
    if (managerOrNot){
      Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, facilityUsage,btn_CheckIn, btn_Dashboard);
    } else {
      Menu.getChildren().addAll(btn_FacilityManagement, btn_ResidentManagement, btn_MakeReservation, facilityUsage,btn_CheckIn);
    }
    Menu.setAlignment(Pos.CENTER);
    Menu.setPadding(new Insets(5,10,5,10));

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
    btn_FacilityManagement.setOnAction(e-> {
      primaryStage.setScene(Page_Facility.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_ResidentManagement.setDisable(true);

    btn_MakeReservation.setOnAction(e->{
      primaryStage.setScene(Page_ManageReservation.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_CheckIn.setOnAction(e-> {
      primaryStage.setScene(Page_CheckInOut.getScene(primaryStage, dataDriver, managerOrNot));
    });

    facilityUsage.setOnAction(e-> {
      primaryStage.setScene(Page_FacilityUsage.getScene(primaryStage, dataDriver, managerOrNot));
    });

    btn_Dashboard.setOnAction(e-> {
      primaryStage.setScene(Page_ManagerDashboard.getScene(primaryStage, dataDriver, managerOrNot));
    });

    // borderPane - bottom
    Button backButton = new Button("Back");
    backButton.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
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

    HBox buttonHBox = new HBox(10);
    buttonHBox.setAlignment(Pos.CENTER);
    buttonHBox.getChildren().addAll(backButton);
    buttonHBox.setPadding(new Insets(15, 10, 15, 10));
    borderPane.setBottom(buttonHBox);
    borderPane.getBottom().setStyle("-fx-background-color: Grey;");

    //Handle back
    backButton.setOnAction(e->{
      primaryStage.setScene(MainMenu.getScene(primaryStage, dataDriver, managerOrNot));
    });

    // borderPane - center
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setAlignment(Pos.TOP_CENTER);
    gridPane.setPadding(new Insets(25, 10, 10, 10));
    borderPane.setCenter(gridPane);

    // create member table
    ObservableList<Member> memberObservableList = FXCollections.observableArrayList(memberArrayList);
    TableView<Member> tableView_Member = new TableView<Member>();
    tableView_Member.setItems(memberObservableList);

    // member ID
    TableColumn<Member,String> column_Id = new TableColumn<Member,String>("Member ID");
    column_Id.setCellValueFactory(new PropertyValueFactory<>("memberID"));
    // member name
    TableColumn<Member,String> column_Name = new TableColumn<Member,String>("Name");
    column_Name.setCellValueFactory(new PropertyValueFactory<>("memberName"));
    // member phone number
    TableColumn<Member,String> column_Phone = new TableColumn<Member,String>("Phone");
    column_Phone.setCellValueFactory(new PropertyValueFactory<Member, String>("memberPhone"));
    // member address
    TableColumn<Member,String> column_Address = new TableColumn<Member,String>("Address");
    column_Address.setCellValueFactory(new PropertyValueFactory<Member, String>("memberAddress"));
    // member email
    TableColumn<Member,String> column_Email = new TableColumn<Member,String>("Email");
    column_Email.setCellValueFactory(new PropertyValueFactory<Member, String>("memberEmail"));

    tableView_Member.getColumns().setAll(column_Id, column_Name, column_Phone, column_Address, column_Email);
    tableView_Member.setPrefWidth(1000);
    tableView_Member.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gridPane.add(tableView_Member, 0, 1);

    // create and handle btn_Add
    Button btn_Add = new Button("Add");
    btn_Add.setOnAction(e->{
      Page_AddMember.addMemberPage("Enter Information", dataDriver);
      primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
    });

    // create and handle btn_Edit
    Button btn_Edit = new Button("Edit");
    btn_Edit.setOnAction(e->{
      if (tableView_Member.getSelectionModel().getSelectedItem() != null) {
        Page_EditMember.editMemberPage("Enter Information", dataDriver, tableView_Member.getSelectionModel().getSelectedItem(),400, 300);
        primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
      } else {
        Messagebox.messageBox("Error", "You must first select a member.");
      }
    });

    //// create and handle btn_Remove
    Button btn_Remove = new Button("Remove");
    btn_Remove.setOnAction(e->{
      if (tableView_Member.getSelectionModel().getSelectedItem() != null) {
        int memberID = tableView_Member.getSelectionModel().getSelectedItem().getMemberID();
        dataDriver.deleteMember(memberID);
        Messagebox.messageBox("Message", "The member and the related reservations have been deleted.");
        primaryStage.setScene(Page_ManageMember.getScene(primaryStage, dataDriver, managerOrNot));
      } else {
        Messagebox.messageBox("Error", "You must first select a member.");
      }
    });

    // create a row to put the buttons on the top of gridPane
    HBox hBox_Button = new HBox(10);
    hBox_Button.setAlignment(Pos.TOP_RIGHT);
    hBox_Button.getChildren().addAll(btn_Add, btn_Edit, btn_Remove);
    gridPane.add(hBox_Button, 0, 0);

    scene = new Scene(borderPane,1400,700);
    return scene;
  }
}