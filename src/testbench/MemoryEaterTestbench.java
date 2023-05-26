package testbench;

import logging.ILog;
import logging.ConsoleLogger;

import timing.ITimer;
import timing.Timer;
import timing.TimeConvert;
import bench.IBenchmark;
import bench.MemoryEaterTest;
import recordKeeping.ScoreWriter;

public class MemoryEaterTestbench {
    private static double Score;

    private static long runTime;

    private static int count;
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new MemoryEaterTest();
        IBenchmark writer = new ScoreWriter();
        TimeConvert newTime = new TimeConvert();

        timer.start();
        bench.run();
        long time = timer.stop();
        runTime = (int) newTime.convert(time, "seconds");

        log.write("Finished in " + newTime.convert(time, "seconds") +" seconds");

        count = ((MemoryEaterTest) bench).getIterations();
         Score = (count / newTime.convert(time, "seconds")) * 4*1048576;


        writer.initialize("memoryEater", count, (int) newTime.convert(time, "seconds"), (int) Score/100000);
        writer.run();

        log.close();
        bench.clean();
    }
    public int getScore() {
        return (int) Score/100000;
    }

    public int getRuntime(){return (int) runTime;}

    public int getIterations(){return count;}

}

