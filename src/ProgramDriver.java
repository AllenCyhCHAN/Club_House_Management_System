import Data.*;
import Scenes.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.*;

public class ProgramDriver extends Application {
    DataDriver dataDriver = new DataDriver("CSV/facilityCSV.csv",
            "CSV/memberCSV.csv",
            "CSV/reservationCSV.csv");
    public static void main (String[] args){
        launch(args);
    } //End of main method

    //Set the scene of loginPage as the primaryStage of the booking system
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Setup stage
        primaryStage.setTitle("HandShake Residence Club House");
        primaryStage.setOpacity(0.91);
        Image icon = new Image("Images/bg.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(Page_LogIn.getScene(primaryStage, dataDriver));
        primaryStage.show();
    }
} 

