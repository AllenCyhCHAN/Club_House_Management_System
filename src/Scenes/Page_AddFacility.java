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
import javafx.geometry.Insets;

class Page_AddFacility {
  public static void addNewFacilitypage(String title,
                                        DataDriver dataDriver) {
    
    Stage addFacilitypage = new Stage();
    addFacilitypage.initModality(Modality.APPLICATION_MODAL);
    addFacilitypage.setTitle(title);
    addFacilitypage.setResizable(false);
    
    VBox vBox = new VBox(10);
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setAlignment(Pos.CENTER);
    
    // Facility name row
    Label label_FacilityName = new Label("Facility Name");
    TextField textField_FacilityName = new TextField();
    grid.add(label_FacilityName, 0, 0);
    grid.add(textField_FacilityName, 1, 0);
    
    //Rent row
    Label label_Rent = new Label("Rent");
    TextField textField_Rent = new TextField();
    grid.add(label_Rent, 0, 1);
    grid.add(textField_Rent, 1, 1);
    
    // Opening time and Closing time 
    Label label_OpeningTime = new Label("Opening Time");
    ObservableList<String> openTimeMenuItems = FXCollections.observableArrayList(
                                                                                 "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
                                                                                 "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
                                                                                );
    ComboBox<String> comboBox_OpeningTime = new ComboBox<String>(openTimeMenuItems);
    grid.add(label_OpeningTime, 0, 2);
    grid.add(comboBox_OpeningTime, 1, 2);
    Label label_CloseTime = new Label("Closing Time");
    ObservableList<String> closeTimeMenuItems = FXCollections.observableArrayList(
                                                                                  "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
                                                                                  "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
                                                                                 );
    ComboBox<String> comboBox_ClosingTime = new ComboBox<String>(closeTimeMenuItems);
    grid.add(label_CloseTime, 0, 3);
    grid.add(comboBox_ClosingTime, 1, 3);
    
    // Description row
    Label label_Description = new Label("Descriptions");
    TextField textView_description = new TextField();
    grid.add(label_Description, 0, 4);
    grid.add(textView_description, 1, 4);
  
    grid.setPadding(new Insets(20,30,20,30));
    
    // error notice 
    Label label_Error = new Label("Please fill in all required information");
    label_Error.setStyle("-fx-text-fill: red;");
    label_Error.setVisible(false);
    vBox.getChildren().add(label_Error);
    
    // submit button 
    Button btn_Submit = new Button("Submit");
    btn_Submit.setOnAction(e2->{
      // if either textfield is empty , show error notice
      if ((textField_FacilityName.getText().equals("")) || (textField_Rent.getText().equals("")) ||
          (comboBox_OpeningTime.getSelectionModel().isEmpty()) || (comboBox_ClosingTime.getSelectionModel().isEmpty())) {
        label_Error.setText("Please fill in all required information");
        label_Error.setVisible(true);
      } else {
        try {        
          dataDriver.createFacility(textField_FacilityName.getText(), Integer.parseInt(textField_Rent.getText()),
                                    comboBox_OpeningTime.getSelectionModel().getSelectedIndex(), 
                                    comboBox_ClosingTime.getSelectionModel().getSelectedIndex(),
                                    textView_description.getText());
          addFacilitypage.close();
          Messagebox.messageBox("Message", "The new facility is successfully added into the system.");
        } catch(Exception e) {
          //error for non numeric rent
          label_Error.setText("Invalid rent value, please check again");
          label_Error.setVisible(true);
        }
      }
    });
    vBox.setAlignment(Pos.CENTER);
    vBox.getChildren().add(btn_Submit);
    
    grid.add(vBox,0,5,2,1);
    
    Scene scene= new Scene(grid);
    
    addFacilitypage.setScene(scene);
    addFacilitypage.showAndWait();
  }
}
