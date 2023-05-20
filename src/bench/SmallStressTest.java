package bench;
import java.util.Random;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Scanner;
import timing.ITimer;
import timing.Timer;

public class SmallStressTest implements IBenchmark{
    long iterations, UsedMemory, finishedReadingTime;
    int byteArray;
    MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
    MemoryUsage initialMemoryUsage = memoryBean.getHeapMemoryUsage();
    long initialMemory = initialMemoryUsage.getMax();

    public void initialize(Object...options){

    }
    public void run(){

    }
    public void run(Object...options) {
        System.gc();
        iterations = (long)options[0];

        Random random = new Random();
        byte[] array = new byte[byteArray];
        byte[] result = new byte[byteArray];

        while (iterations > 0) {
            random.nextBytes(array);
            for (int i = 0; i < byteArray; i++) {
                result[i] += array[i];
            }
            iterations--;
        }

        MemoryUsage MemoryUsage = memoryBean.getHeapMemoryUsage();
        UsedMemory = MemoryUsage.getUsed()/ (1024 * 1024);
        System.out.println("Memory used for running the program: " + UsedMemory  + " MB");

        System.gc();
    }

    public long writingTime(){
        byte[] array = new byte[byteArray];
        ITimer timer = new Timer();
        timer.start();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        long finishedWritingTime = timer.stop();
        return finishedWritingTime;
    }

    public long readingTime(){
        byte[] array = new byte[byteArray];
        ITimer timer = new Timer();
        timer.start();
        for (int i = 0; i < array.length; i++){
            byte element = array[i];
        }
        finishedReadingTime = timer.stop();
        return finishedReadingTime;
    }

    public int readAmountOfMemory (){
        System.out.println ("Initial allocated memory: " + initialMemory/(1024 * 1024) + " MB");
        System.out.println("Give an amount of memory:");

        Scanner scanner = new Scanner(System.in);
        byteArray = scanner.nextInt() * 1024 * 1024;
        boolean flag = true;

        if (byteArray > initialMemory) {
            System.out.println("Too much memory.\nPlease select a smaller amount");
            byteArray = 0;
            flag = false;
        }

        while (!flag) {
            byteArray = 0;
            byteArray = scanner.nextInt() * (1024 * 1024);
            if (byteArray < initialMemory) {
                flag = true;
            }
        }
        return byteArray;
    }

    public long getMemory(){
        return UsedMemory;
    }

    public void clean(){
        System.gc();
    }

    public void cancel(){

    }
}