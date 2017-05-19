package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EndController implements Initializable{
	@FXML
	Label labelEnd;
	
	@FXML
	Button backEndButton;
	
    @FXML
	void handleEndBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        
        root=FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        stage=(Stage) backEndButton.getScene().getWindow();
        stage.setHeight(Main.useHeight);
        stage.setWidth(Main.useWidth);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    void setWinnerLabel(){
		labelEnd.setText("Victory!");
    	if (Main.winner)
			labelEnd.setTextFill(Color.RED);
    	else
    		labelEnd.setTextFill(Color.BLUE);
    }

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.setWinnerLabel();
	}

}
