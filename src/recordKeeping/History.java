package recordKeeping;

import javafx.beans.property.SimpleStringProperty;
public class History {
    private SimpleStringProperty timestamp;
    private SimpleStringProperty field1;
    private SimpleStringProperty field2;
    private SimpleStringProperty score;

    public History(String timestamp, String field1, String field2, String score) {
        this.timestamp = new SimpleStringProperty(timestamp);
        this.field1 = new SimpleStringProperty(field1);
        this.field2 = new SimpleStringProperty(field2);
        this.score = new SimpleStringProperty(score);
    }

    public String getTimestamp() {
        return timestamp.get();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = new SimpleStringProperty(timestamp);
    }

    public String getField1() {
        return field1.get();
    }

    public void setField1(String field1) {
        this.field1 = new SimpleStringProperty(field1);
    }

    public String getField2() {
        return field2.get();
    }

    public void setField2(String field2) {
        this.field2 = new SimpleStringProperty(field2);
    }

    public String getScore() {
        return score.get();
    }

    public void setScore(String score) {
        this.score = new SimpleStringProperty(score);
    }
}
