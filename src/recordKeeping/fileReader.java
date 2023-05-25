package recordKeeping;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {

    private String path, timestamp, field1, field2, score;
    ObservableList<History> dataList = FXCollections.observableArrayList();
    public void read(Object ... params) {
        path = (String)params[0];
        String file = System.getProperty("user.home") + "/Documents/CoffeeBenchmarkFiles/" + path + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings
                String[] values = line.split(",");

                // Ensure that the line has exactly four values
                if (values.length != 4) {
                    System.err.println("Invalid line: " + line);
                    continue;
                }

                timestamp = values[0];
                field1 = values[1];
                field2 = values[2];
                score = values[3];

                History record = new History(timestamp, field1, field2, score);
                dataList.add(0, record);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<History> getList(){
        return dataList;
    }
}
