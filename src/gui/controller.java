package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import testbench.DetailMemorySpaceTestbench;
import javafx.scene.control.TextField;

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
        testbench.TestSmallStress test = new testbench.TestSmallStress();
        test.main(null);

        // Get the results from the TestSmallStress instance
        double score = test.getScore();
        long time = test.getTime();

        // Update the text field with the results
        resultTextField.setText("Score: " + score + ", Time: " + time);

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
        /*Parent root= FXMLLoader.load(getClass().getResource("History.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        // Create and load the FXML file for the new scene or page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
        Parent scene2Root = loader.load();

        // Set the new scene as the content of the contentPane
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
    @FXML
    void switchToScene5(MouseEvent event) throws IOException {
        openGraphsFXML();
    }


   /* @FXML
    void showTextField(MouseEvent event) throws IOException{
        TextField.setOpacity(1.0);
    }*/


    public void openGraphsFXML() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Graphs.fxml"));
            Parent root = fxmlLoader.load();

            // Access the SplitPane with the ID "contentPane"
            SplitPane contentPane = (SplitPane) root.lookup("#contentPane");
            if (contentPane != null) {
                // Add the new content to the SplitPane
                contentPane.getItems().add(root);
            }

            // Create a new Stage for the Scene
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
}