package Scenes;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Data.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox; 
import javafx.geometry.Insets;


public class Page_AddMember {
 public static void addMemberPage(String title,
                                  DataDriver dataDriver) {
    Stage addMemberPage = new Stage();
    addMemberPage.initModality(Modality.APPLICATION_MODAL);
    addMemberPage.setTitle(title);
    addMemberPage.setResizable(false);

    VBox vBox = new VBox(10);
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setAlignment(Pos.CENTER);
    grid.setPadding(new Insets(20,30,20,30));
    
    // name
    Label label_Name = new Label("Member Name");
    TextField textField_Name = new TextField();
    grid.add(label_Name, 0, 0);
    grid.add(textField_Name, 1, 0);
    
    // phone number
    Label label_Phone = new Label("Phone Number");
    TextField textField_phone = new TextField();
    grid.add(label_Phone, 0, 1);
    grid.add(textField_phone, 1, 1);
    
    // address
    Label label_Address = new Label("Member Address");
    TextField textField_Address = new TextField();
    grid.add(label_Address, 0, 2);
    grid.add(textField_Address, 1, 2);
    
    // email
    Label label_Email = new Label("Member Email");
    TextField textField_Email = new TextField();
    grid.add(label_Email, 0, 3);
    grid.add(textField_Email, 1, 3);
    
    // error message label
    Label label_Error = new Label("Please fill in all required information");
    label_Error.setStyle("-fx-text-fill: red;");
    label_Error.setVisible(false);
    vBox.getChildren().add(label_Error);
    
    //submit button
    Button btn_Submit  = new Button("Submit");
    btn_Submit.setOnAction(e->{
      //check if empty input was found 
      if ((textField_Name.getText().equals(""))  || (textField_phone.getText().equals(""))
            || (textField_Address.getText().equals("")) || (textField_Email.getText().equals(""))) {
        label_Error.setVisible(true);
      } else {
        try {
          dataDriver.createMember(textField_Name.getText(), Integer.parseInt(textField_phone.getText()),
                                      textField_Address.getText(), textField_Email.getText());
          addMemberPage.close();
          Messagebox.messageBox("Message", "The member is successfully added into the system.");
        } catch (Exception e1) {
          // if non numeric phone number was found 
          label_Error.setText("Invalid member phone number, please check again");
          label_Error.setVisible(true);
          
        }
      }
    });

    vBox.setAlignment(Pos.CENTER);
    vBox.getChildren().add(btn_Submit);
    
    grid.add(vBox,0,4,2,1);
    Scene page = new Scene(grid);

    addMemberPage.setScene(page);
    addMemberPage.showAndWait();
  }
 }
  
