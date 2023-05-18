package testbench;

import logging.ILog;
import logging.ConsoleLogger;

import timing.ITimer;
import timing.Timer;
import timing.TimeConvert;
import bench.IBenchmark;
import bench.MemoryEaterTest;
import recordKeeping.ScoreWriter;

public class MemoryEaterBenchmark {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new MemoryEaterTest();
        IBenchmark writer = new ScoreWriter();
        TimeConvert newTime = new TimeConvert();

        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in " + newTime.convert(time, "seconds") +" seconds");

        int count = ((MemoryEaterTest) bench).getIterations();
        double Score = (count / newTime.convert(time, "seconds")) * 4*1048576;


        writer.initialize("memoryEater", count, (int) newTime.convert(time, "seconds"), (int) Score/100000);
        writer.run();

        log.close();
        bench.clean();
    }

}

