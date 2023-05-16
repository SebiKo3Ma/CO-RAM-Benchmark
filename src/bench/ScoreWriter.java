package bench;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

public class ScoreWriter implements IBenchmark{
    private int Score;
    @Override
    public void initialize(Object ... params){ this.Score = (Integer)params[0]; }

    @Override
    public void run(){
        /*FileSystemView view = FileSystemView.getFileSystemView();
        File file = view.getHomeDirectory();
        String desktopPath = file.getPath();*/

        String filePath = System.getProperty("user.home") + "/Desktop/Scores.txt";
        //System.out.println(filePath);
        //"C:\\Users\\alexa\\Desktop\\Scores.txt  + File.separator + ";
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
            //System.out.println("Score:" + Score);
            fileWriter.write("Score: " + Score + "\n");
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
