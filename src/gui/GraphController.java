package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {

    @FXML
    LineChart<Number, Number> chart1, chart2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Custom Test Scores");
        series1.getData().add(new XYChart.Data<>(1, 20));
        series1.getData().add(new XYChart.Data<>(2, 100));
        series1.getData().add(new XYChart.Data<>(3, 80));
        series1.getData().add(new XYChart.Data<>(4, 180));
        series1.getData().add(new XYChart.Data<>(5, 20));
        series1.getData().add(new XYChart.Data<>(6, -10));
        chart1.getData().add(series1);

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Overflow Test Scores");
        series2.getData().add(new XYChart.Data<>(1, 20));
        series2.getData().add(new XYChart.Data<>(2, 100));
        series2.getData().add(new XYChart.Data<>(3, 80));
        series2.getData().add(new XYChart.Data<>(4, 180));
        series2.getData().add(new XYChart.Data<>(5, 20));
        series2.getData().add(new XYChart.Data<>(6, -10));
        chart2.getData().add(series2);
    }
}
