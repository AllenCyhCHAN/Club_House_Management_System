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


public class Page_EditMember {
public static void editMemberPage(String title,
                                  DataDriver dataDriver,
                                  Member member,
                                  int width,
                                  int height) {
    Stage editMemberPage = new Stage();
    editMemberPage.initModality(Modality.APPLICATION_MODAL);
    editMemberPage.setTitle(title);
    editMemberPage.setResizable(false);

    VBox vBox = new VBox(10);
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setAlignment(Pos.CENTER);
    
    // member name
    Label label_Name = new Label("Name");
    TextField textField_Name = new TextField(member.getMemberName()); // get inputted value
    grid.add(label_Name, 0, 0);
    grid.add(textField_Name, 1, 0);
    
    // member phone
    Label label_Phone = new Label("Phone Number");
    TextField textField_Phone = new TextField(Integer.toString(member.getMemberPhone()));
    grid.add(label_Phone, 0, 1);
    grid.add(textField_Phone, 1, 1);
    
    // member address
    Label label_Address = new Label("Address");
    TextField textField_Address = new TextField(member.getMemberAddress());
    grid.add(label_Address, 0, 2);
    grid.add(textField_Address, 1, 2);
    
    // member email
    Label label_Email = new Label("Email");
    TextField textField_Email = new TextField(member.getMemberEmail());
    grid.add(label_Email, 0, 3);
    grid.add(textField_Email, 1, 3);
    
    grid.add(vBox,0,4,2,1);
    grid.setPadding(new Insets(20,30,20,30));

    // error label
    Label label_Error = new Label("Please fill in all required informations");
    label_Error.setStyle("-fx-text-fill: red;");
    label_Error.setVisible(false);
    vBox.getChildren().add(label_Error);

    //submit button
    Button btn_Submit = new Button("Submit");
    btn_Submit.setOnAction(e2->{
      //check if there was empty input 
      if ((textField_Name.getText().equals("")) || (textField_Phone.getText().equals(""))
            || (textField_Address.getText().equals("")) || (textField_Email.getText().equals("")) ) {
        label_Error.setVisible(true);
      } else {
        try {
          dataDriver.modifyMember(member.getMemberID(), textField_Name.getText(), Integer.parseInt(textField_Phone.getText()),
                                    textField_Address.getText(), textField_Email.getText());
          editMemberPage.close();
          Messagebox.messageBox("Message", "The member information is successfully updated.");
        } catch (Exception e) {
          //check if there was non-numeric phone number 
          label_Error.setText("Invalid value for member phone number, please check again");
          label_Error.setVisible(true);
        }
      }
    });

    vBox.setAlignment(Pos.CENTER);
    vBox.getChildren().add(btn_Submit);
    
    Scene scene= new Scene(grid);

    editMemberPage.setScene(scene);
    editMemberPage.showAndWait();
  }
 }
  
