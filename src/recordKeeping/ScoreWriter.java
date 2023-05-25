package recordKeeping;

import bench.IBenchmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ScoreWriter implements IBenchmark {
    private int Score, field2, field1;
    private String path;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void initialize(Object ... params){
        this.path = (String)params[0];
        this.field1 = (Integer)params[1];
        this.field2 = (Integer)params[2];
        this.Score = (Integer)params[3];
    }

    @Override
    public void run(){

        String filePath = System.getProperty("user.home") + "/Documents/CoffeeBenchmarkFiles/" + path + ".txt";

        try {
            Files.createDirectories(Paths.get(System.getProperty("user.home") + "/Documents/CoffeeBenchmarkFiles"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File(filePath);
        if(file.exists()){
            ;
        }
        else{
            try{
                if(file.createNewFile()){
                    //System.out.println("File created successfully\n");
                    ;
                }
                else{
                    System.out.println("Failed to create file\n");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            FileWriter fileWriter = new FileWriter(filePath,true);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.write(sdf.format(timestamp) + "," + field1 + "," + field2 + "," + Score + "\n");
            System.out.println("Successfully wrote in the file.");
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e){
                e.printStackTrace();
            }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }
}
