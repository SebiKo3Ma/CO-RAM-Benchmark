package testbench;

import bench.IBenchmark;
import bench.SmallStress;
import timing.ITimer;
import timing.TimeConvert;
import timing.Timer;
import logging.ConsoleLogger;
import recordKeeping.ScoreWriter;

import java.sql.Time;

public class TestSmallStress {
    private double score;
    private static long Time;
    public static void main (String [] args){

        IBenchmark bench = new SmallStress();
        ITimer timer = new Timer();
        ConsoleLogger log = new ConsoleLogger();
        TimeConvert newTime = new TimeConvert();
        ScoreWriter writer = new ScoreWriter();

        long iterations = 10;
        int byteArray = 300 * 1024 * 1024;

        timer.start();
        bench.run(iterations, byteArray);

        long finishedTime = timer.stop();
        double score = (iterations/ (newTime.convert(finishedTime, "seconds"))) * byteArray;

      //  log.write("Score: " + score/100000);
      //  log.write ("Time: " + newTime.convert(finishedTime, "seconds") + " seconds");
        Time= (long) newTime.convert(finishedTime, "seconds");


        writer.initialize("smallStress", (int)((SmallStress) bench).getMemory(), (int) newTime.convert(finishedTime, "seconds"), (int) score/100000);
        writer.run();

        log.close();
        bench.clean();
    }
    public double getScore() {
        return score/100000;
    }

    public long getTime() {
        return Time;
    }
}
