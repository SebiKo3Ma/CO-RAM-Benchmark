package testbench;

import bench.IBenchmark;
import bench.SmallStress;
import timing.ITimer;
import timing.TimeConvert;
import timing.Timer;
import logging.ConsoleLogger;

public class TestSmallStress {
    public static void main (String [] args){
        IBenchmark bench = new SmallStress();
        ITimer timer = new Timer();
        ConsoleLogger log = new ConsoleLogger();
        TimeConvert newTime = new TimeConvert();

        double size = 10000.0;

        timer.start();
        bench.run(size);
        long finishedTime = timer.stop();
        double score = size/(newTime.convert(finishedTime, "seconds"));
        log.write("Score: " + score);
        log.close();

    }
}
