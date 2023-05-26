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
import javafx.scene.control.TextArea;
import testbench.MemoryEaterTestbench;
import testbench.SmallStressTestbench;

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
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private Label timeLabel;

    @FXML
    private TextArea resultTextField;


    @FXML
    private void handleStressButton() {
        // Call the TestSmallStress code from the testbench package
        SmallStressTestbench test = new SmallStressTestbench();
        test.main(null);

        // Get the results from the TestSmallStress instance
        int score = test.getScore();
        int readSpeed = test.getReadSpeed();
        int writeSpeed = test.getWriteSpeed();


        // Update the text field with the results
        resultTextField.setText("\nWriting speed: " + writeSpeed + " MB/s\nReading Speed: " + readSpeed + " MB/s\nScore: " + score);
    }

    @FXML
    private void handleMemoryEater() {


        // Call the TestSmallStress code from the testbench package
        MemoryEaterTestbench test = new MemoryEaterTestbench();
        test.main(null);

        // Get the results from the TestSmallStress instance
        int score2 = test.getScore();
        int iterations = test.getIterations();
        int runtime = test.getRuntime();
        // Update the text field with the results
        resultTextField.setText("\nIterations: " + iterations + "\nRuntime: " + runtime + "s\nScore: " + score2);


    }
    @FXML
     void handleDetailMemorySpaceTestbech(MouseEvent event) throws IOException {

        String textColor = "-fx-text-fill: #edd4ab";
        textField1.setOpacity(0.7);
        textField1.setStyle(textColor);
        textField2.setOpacity(0.7);
        textField2.setStyle(textColor);
        textField3.setOpacity(0.7);
        textField3.setStyle(textColor);
        textField4.setOpacity(0.7);
        textField4.setStyle(textColor);


        DetailMemorySpaceTestbench test=new DetailMemorySpaceTestbench();
        test.main();


        double UsedGB=test.getUsedGB();
        double FreeGB=test.getFreeGB();
        double TotalGB= test.getTotalGB();
        textField1.setText("Free Memory: "+ FreeGB);
        textField2.setText("Used Memory: "+ UsedGB);
        textField3.setText("Total memory: "+TotalGB);



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