package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    // private AnchorPane ContentPane;


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

    @FXML
    private TableView<History> tbData1;
    @FXML
    public TableColumn<History, String> timestamp1;

    @FXML
    public TableColumn<History, String> memoryUsed1;

    @FXML
    public TableColumn<History, String> runtime1;

    @FXML
    public TableColumn<History, String> score1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //make sure the property value factory should be exactly same as the e.g. getStudentId from your model class
        timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        memoryUsed.setCellValueFactory(new PropertyValueFactory<>("memoryUsed"));
        runtime.setCellValueFactory(new PropertyValueFactory<>("runtime"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        //add your data to the table here.
        fileReader reader = new fileReader();
        reader.read("smallStress");
        tbData.setItems(reader.getList());


        timestamp1.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        memoryUsed1.setCellValueFactory(new PropertyValueFactory<>("memoryUsed"));
        runtime1.setCellValueFactory(new PropertyValueFactory<>("runtime"));
        score1.setCellValueFactory(new PropertyValueFactory<>("score"));

        fileReader reader1 = new fileReader();
        reader1.read("memoryEater");
        tbData1.setItems(reader1.getList());
    }

    // add your data here from any source 
    private ObservableList<History> History = FXCollections.observableArrayList();

}
