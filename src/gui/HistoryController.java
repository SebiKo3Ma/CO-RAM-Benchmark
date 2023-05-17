package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import recordKeeping.History;
import recordKeeping.fileReader;

import java.io.IOException;

public class HistoryController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void switchToScene1(MouseEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<History> tbData;
    @FXML
    public TableColumn<History, String> timestamp;

    @FXML
    public TableColumn<History, String> memoryUsed;

    @FXML
    public TableColumn<History, String> runtime;

    @FXML
    public TableColumn<History, String> score;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //make sure the property value factory should be exactly same as the e.g. getStudentId from your model class
        timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        memoryUsed.setCellValueFactory(new PropertyValueFactory<>("memoryUsed"));
        runtime.setCellValueFactory(new PropertyValueFactory<>("runtime"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        //add your data to the table here.
        fileReader reader = new fileReader();
        reader.read();
        tbData.setItems(reader.getList());
    }

    // add your data here from any source 
    private ObservableList<History> History = FXCollections.observableArrayList();

}
