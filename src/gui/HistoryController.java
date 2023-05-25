package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
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
     private AnchorPane ContentPane;


    @FXML
    private TableView<History> tbData;
    @FXML
    public TableColumn<History, String> timestamp;

    @FXML
    public TableColumn<History, String> field1;

    @FXML
    public TableColumn<History, String> field2;

    @FXML
    public TableColumn<History, String> score;

    @FXML
    private TableView<History> tbData1;
    @FXML
    public TableColumn<History, String> timestamp1;

    @FXML
    public TableColumn<History, String> field11;

    @FXML
    public TableColumn<History, String> field21;

    @FXML
    public TableColumn<History, String> score1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //make sure the property value factory should be exactly same as the e.g. getStudentId from your model class
        timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        field1.setCellValueFactory(new PropertyValueFactory<>("field1"));
        field2.setCellValueFactory(new PropertyValueFactory<>("field2"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        //add your data to the table here.
        fileReader reader = new fileReader();
        reader.read("smallStress");
        tbData.setItems(reader.getList());


        timestamp1.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        field11.setCellValueFactory(new PropertyValueFactory<>("field1"));
        field21.setCellValueFactory(new PropertyValueFactory<>("field2"));
        score1.setCellValueFactory(new PropertyValueFactory<>("score"));

        fileReader reader1 = new fileReader();
        reader1.read("memoryEater");
        tbData1.setItems(reader1.getList());
    }

    // add your data here from any source 
    private ObservableList<History> History = FXCollections.observableArrayList();

    @FXML
    void switchToScene5(MouseEvent event) throws IOException {
        openGraphsFXML();
    }
    public void openGraphsFXML() throws IOException {
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
