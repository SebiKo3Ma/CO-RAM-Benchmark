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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stressTest.fxml"));
        Parent scene1Root = loader.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene1Root);
}

    @FXML
    void switchToScene2(MouseEvent event) throws IOException{
        FXMLLoader loader2= new FXMLLoader(getClass().getResource("Details.fxml"));
        Parent scene2Root = loader2.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene2Root);
    }
    @FXML
    void switchToScene3(MouseEvent event) throws IOException{
        FXMLLoader loader3=new FXMLLoader(getClass().getResource("History.fxml"));
        Parent scene3Root = loader3.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene3Root);
    }


}