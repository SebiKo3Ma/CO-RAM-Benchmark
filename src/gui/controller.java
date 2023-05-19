package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import testbench.DetailMemorySpaceTestbench;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class controller{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane ContentPane;
    @FXML
    void buttonDetails(MouseEvent event){
        DetailMemorySpaceTestbench detail = new DetailMemorySpaceTestbench();
        detail.main();
    }
    @FXML
    void switchToScene1(MouseEvent event) throws IOException {
        // Create and load the FXML file for the new scene or page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent scene1Root = loader.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene1Root);
}

    @FXML
    void switchToScene2(MouseEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("History.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToScene3(MouseEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("stressTest.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}