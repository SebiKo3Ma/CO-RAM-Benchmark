package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import testbench.DetailMemorySpaceTestbench;
import javafx.scene.control.TextField;
import testbench.MemoryEaterBenchmark;
import testbench.SmallStressBenchmark;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class controller{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane ContentPane;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label timeLabel;
    @FXML
    private TextField resultTextField;

    @FXML
    private void handleStressButton() {
        // Call the TestSmallStress code from the testbench package
        SmallStressBenchmark test = new SmallStressBenchmark();
        test.main(null);

        // Get the results from the TestSmallStress instance
        double score = test.getScore();

        long time = test.getTime();


        // Update the text field with the results
        resultTextField.setText("Score: " + score + ", Time: " + time);

    }

    @FXML
    private void handleMemoryEater() {


        // Call the TestSmallStress code from the testbench package
        MemoryEaterBenchmark test = new MemoryEaterBenchmark();
        test.main(null);

        // Get the results from the TestSmallStress instance
        double score2 = test.getScore();
        // Update the text field with the results
        resultTextField.setText("Score: " + score2);


    }
    @FXML
     void handleDetailMemorySpaceTestbech(MouseEvent event) throws IOException {
/*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Details2.fxml"));
            Parent scene6Root = loader.load();
            ContentPane.getChildren().setAll(scene6Root);
*/

        DetailMemorySpaceTestbench test=new DetailMemorySpaceTestbench();
        test.main();


    }
    @FXML
    void buttonDetails(MouseEvent event){
        DetailMemorySpaceTestbench detail = new DetailMemorySpaceTestbench();
        detail.main();
    }
    @FXML
    void switchToScene1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stressTest.fxml"));
        Parent scene1Root = loader.load();
        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene1Root);
}

    @FXML
    void switchToScene2(MouseEvent event) throws IOException{
        // Create and load the FXML file for the new scene or page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
        Parent scene2Root = loader.load();
        ContentPane.getChildren().setAll(scene2Root);
    }
    @FXML
    void switchToScene3(MouseEvent event) throws IOException{
        // Create and load the FXML file for the new scene or page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
        Parent scene3Root = loader.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene3Root);
    }
    @FXML
    void switchToScene4(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stressTest.fxml"));
        Parent scene4Root = loader.load();

        // Set the new scene as the content of the contentPane
        ContentPane.getChildren().setAll(scene4Root);
    }



   /* @FXML
    void showTextField(MouseEvent event) throws IOException{
        TextField.setOpacity(1.0);
    }*/



}