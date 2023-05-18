package recordKeeping;

import javafx.beans.property.SimpleStringProperty;
public class History {
    private SimpleStringProperty timestamp;
    private SimpleStringProperty memoryUsed;
    private SimpleStringProperty runtime;
    private SimpleStringProperty score;

    public History(String timestamp, String memoryUsed, String runtime, String score) {
        this.timestamp = new SimpleStringProperty(timestamp);
        this.memoryUsed = new SimpleStringProperty(memoryUsed);
        this.runtime = new SimpleStringProperty(runtime);
        this.score = new SimpleStringProperty(score);
    }

    public String getTimestamp() {
        return timestamp.get();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = new SimpleStringProperty(timestamp);
    }

    public String getMemoryUsed() {
        return memoryUsed.get();
    }

    public void setMemoryUsed(String memoryUsed) {
        this.memoryUsed = new SimpleStringProperty(memoryUsed);
    }

    public String getRuntime() {
        return runtime.get();
    }

    public void setRuntime(String runtime) {
        this.runtime = new SimpleStringProperty(runtime);
    }

    public String getScore() {
        return score.get();
    }

    public void setScore(String score) {
        this.score = new SimpleStringProperty(score);
    }
}
