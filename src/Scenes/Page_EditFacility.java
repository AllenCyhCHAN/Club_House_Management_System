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
import java.text.DecimalFormat;


public class Page_EditFacility {
  public static void editFacilityPage(String title,
                                      DataDriver dataDriver,
                                      Facility facility,
                                      int width,
                                      int height) {
    Stage editFacilityPage = new Stage();
    editFacilityPage.initModality(Modality.APPLICATION_MODAL);
    editFacilityPage.setTitle(title);
    editFacilityPage.setResizable(false);

    VBox vBox = new VBox(10);
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setAlignment(Pos.CENTER);
    
    // facility name
    Label label_FacilityName = new Label("Facility Name");
    TextField textField_FacilityName = new TextField(facility.getFacilityName());
    grid.add(label_FacilityName, 0, 0);
    grid.add(textField_FacilityName, 1, 0);
    
    // rent
    Label label_Rent = new Label("Rent");
    TextField textField_Rent = new TextField(Integer.toString(facility.getRent()));
    grid.add(label_Rent, 0, 1);
    grid.add(textField_Rent, 1, 1);
    
    // timeslot
    Label label_OpeningTime = new Label("Open Time");
    ObservableList<String> openingTimeObservableList = FXCollections.observableArrayList(
      "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
      "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
    );
    
    ComboBox<String> comboBox_OpeningTime = new ComboBox<String>(openingTimeObservableList);
    DecimalFormat formatter = new DecimalFormat("00");
    comboBox_OpeningTime.setValue(formatter.format(facility.getOpeningHour())+":00");
    grid.add(label_OpeningTime, 0, 2);
    grid.add(comboBox_OpeningTime, 1, 2);
    
    Label label_ClosingTime = new Label("Close Time");
    ObservableList<String> closeTimeObservableList = FXCollections.observableArrayList(
      "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00",
      "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
    );
    

    ComboBox<String> comboBox_ClosingTime = new ComboBox<String>(closeTimeObservableList);
    comboBox_ClosingTime.setValue(formatter.format(facility.getClosingHour())+":00");
    grid.add(label_ClosingTime, 0, 3);
    grid.add(comboBox_ClosingTime, 1, 3);
    
    // descriptions
    Label label_Description = new Label("Descriptions");
    TextField textField_description = new TextField(facility.getDescription());
    grid.add(label_Description, 0, 4);
    grid.add(textField_description, 1, 4);

    grid.add(vBox,0,5,2,1);
    grid.setPadding(new Insets(20,30,20,30));

    Label label_Error = new Label("Please fill in all required informations.");
    label_Error.setStyle("-fx-text-fill: red;");
    label_Error.setVisible(false);
    vBox.getChildren().add(label_Error);

    // submit button
    Button btn_Submit = new Button("Submit");
    btn_Submit.setOnAction(e2->{
      //check if there was empty input
      if ((textField_FacilityName.getText().equals("")) || (textField_Rent.getText().equals("")) ||
          (comboBox_OpeningTime.getSelectionModel().isEmpty()) || (comboBox_ClosingTime.getSelectionModel().isEmpty())) {
        label_Error.setText("Please fill in all required informations.");
        label_Error.setVisible(true);
      } else {
        try {         
          dataDriver.modifyFacility(facility.getFacilityID(), textField_FacilityName.getText(), Integer.parseInt(textField_Rent.getText()),
                                      comboBox_OpeningTime.getSelectionModel().getSelectedIndex(),
                                      comboBox_ClosingTime.getSelectionModel().getSelectedIndex(),
                                      textField_description.getText());
          editFacilityPage.close();
        } catch(Exception error) {
          //if there was non-numeric rent
          label_Error.setText("Invalid value for Rent, please check again");
          label_Error.setVisible(true);
        }
      }
    });

    vBox.setAlignment(Pos.CENTER);
    vBox.getChildren().add(btn_Submit);
    
    Scene scene= new Scene(grid, width, height);

    editFacilityPage.setScene(scene);
    editFacilityPage.showAndWait();
  }
 }
  
