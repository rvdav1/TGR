package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import persistence.WriteInXML;

public class DeleteProfileController implements Initializable {

	List<File> files;
	
	@FXML
	Button deleteProfileButton;

	@FXML
	Button deleteAllButton;

	@FXML
	Button backDel;
	
	@FXML
	ComboBox<File> deleteBox;

	@FXML
	Label labelDel;

	@FXML
	void handleDeleteProfile(ActionEvent event) throws IOException {
		if (files.size() > 0){
			deleteBox.getSelectionModel().getSelectedItem().delete();
		
			Stage stage;
			Parent root;
        
			root=FXMLLoader.load(getClass().getResource("/fxml/DeleteProfile.fxml"));
			stage=(Stage) deleteProfileButton.getScene().getWindow();
			stage.setHeight(Main.useHeight);
			stage.setWidth(Main.useWidth);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else
			labelDel.setText("Nothing to delete!");
	}
	
	@FXML
	void handleDeleteAllProfile(ActionEvent event) throws IOException {
		for (int i = 0; i < files.size(); i++)
			files.get(i).delete();
		
        Stage stage;
        Parent root;
        
        root=FXMLLoader.load(getClass().getResource("/fxml/DeleteProfile.fxml"));
        stage=(Stage) deleteAllButton.getScene().getWindow();
        stage.setHeight(Main.useHeight);
        stage.setWidth(Main.useWidth);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	@FXML
	void handleDelBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        root=FXMLLoader.load(getClass().getResource("/fxml/Opt.fxml"));
        stage=(Stage) backDel.getScene().getWindow();
        stage.setHeight(Main.useHeight);
        stage.setWidth(Main.useWidth);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}

	public void initialize(URL location, ResourceBundle resources) {
		File f = new File(WriteInXML.getFolder());
		files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		ObservableList<File> allFiles = FXCollections.observableArrayList(files);
		deleteBox.setItems(allFiles);
		deleteBox.getSelectionModel().select(0);
	}

}
