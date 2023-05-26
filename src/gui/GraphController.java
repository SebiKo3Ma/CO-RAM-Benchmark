package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import recordKeeping.fileReader;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {

    @FXML
    LineChart<Number, Number> chart1, chart2;

    private int[] scoreList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileReader reader = new fileReader();
        reader.read("smallStress");
        scoreList = reader.getScores();

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Custom Test Scores");
        int j = 0;
        for(int i = 9; i >= 0; i--){
            series1.getData().add(new XYChart.Data<>(j++, scoreList[i]));
        }
        chart1.getData().add(series1);

        fileReader reader2 = new fileReader();
        reader2.read("memoryEater");
        scoreList = reader2.getScores();

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Overflow Test Scores");
        j = 0;
        for(int i = 9; i >= 0; i--){
            series2.getData().add(new XYChart.Data<>(j++, scoreList[i]));
        }
        chart2.getData().add(series2);
    }
}
