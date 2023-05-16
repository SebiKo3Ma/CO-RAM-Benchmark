package testbench;

import logging.ILog;
import logging.ConsoleLogger;
import timing.ITimer;
import timing.Timer;
import timing.TimeConvert;
import bench.IBenchmark;
import bench.MemoryEaterTest;

public class MainBenchmark {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new MemoryEaterTest();
        TimeConvert newTime = new TimeConvert();

        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in ", newTime.convert(time, "miliseconds"), " ms\n");



        log.close();
        bench.clean();


    }
}
//modific sa vad si io ca mere prob not

/*
- codul meu - de viteza
- stress test
- afisare RAM
 */