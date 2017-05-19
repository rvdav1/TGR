package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable{
	
    @FXML
	Button mainPlayButton;
    
    @FXML
	Button mainOptionsButton;
    
    @FXML
	Button mainExitButton;
 
    @FXML
	void handleMainPlay(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        
        root=FXMLLoader.load(getClass().getResource("/fxml/PlayMode.fxml"));
        stage=(Stage) mainOptionsButton.getScene().getWindow();
        stage.setHeight(Main.useHeight);
        stage.setWidth(Main.useWidth);
        Scene scene = new Scene(root);
        stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("/css/PlayMode.css").toExternalForm());
        stage.show();
    }
    
    @FXML
	void handleMainOptions(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        
        root=FXMLLoader.load(getClass().getResource("/fxml/Opt.fxml"));
        stage=(Stage) mainOptionsButton.getScene().getWindow();
        stage.setHeight(Main.useHeight);
        stage.setWidth(Main.useWidth);
        Scene scene = new Scene(root);
        stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("/css/Opt.css").toExternalForm());
        stage.show();
    }
    
    @FXML
	void handleMainExit(ActionEvent event){
    	Platform.exit();
    }
	
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
