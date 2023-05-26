package testbench;

import bench.IBenchmark;
import bench.SmallStressTest;
import timing.ITimer;
import timing.TimeConvert;
import timing.Timer;
import logging.ConsoleLogger;
import recordKeeping.ScoreWriter;

public class SmallStressBenchmark {

    private double score;

    private static long Time;
    public static void main (String [] args){

        IBenchmark bench = new SmallStressTest();
        ITimer timer = new Timer();
        ConsoleLogger log = new ConsoleLogger();
        TimeConvert newTime = new TimeConvert();
        ScoreWriter writer = new ScoreWriter();

        long iterations = 10;
        int byteArray;

        byteArray = ((SmallStressTest) bench). readAmountOfMemory();

        timer.start();
        bench.run(iterations, byteArray);
        long finishedTime = timer.stop();
        double score = (iterations/ (newTime.convert(finishedTime, "seconds"))) * byteArray;

        long timeForReading = ((SmallStressTest) bench). readingTime();
        long timeForWriting = ((SmallStressTest) bench).writingTime();

        log.write("Score: " + score/100000);
        log.write ("Time for running the program: " + newTime.convert(finishedTime, "seconds") + " seconds");
      
        Time = (long) newTime.convert(finishedTime, "seconds");

        double readSpeed, writeSpeed;
        System.gc();

        readSpeed = ((SmallStressTest) bench).getReadMemory() / newTime.convert(timeForReading, "seconds");
        writeSpeed = ((SmallStressTest) bench).getReadMemory() / newTime.convert(timeForWriting, "seconds");
        log.write("Read:" + readSpeed + " MB/s\n" + "Write:" + writeSpeed + " MB/s");

        writer.initialize("smallStress",(int) writeSpeed, (int) readSpeed, (int) score/100000);
        writer.run();

        log.close();

    }
    public double getScore() {
        return score/100000;
    }

    public long getTime() {
        return Time;
    }
}
