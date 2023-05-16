package bench;
import java.util.Random;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

public class SmallStress implements IBenchmark{
    int size;
    boolean flag = true;

    public void initialize(Object...options){

    }
    public void run(){

    }
    public void run(Object...options) {
        double size = (Double)options[0];
        int sum = 0;

        System.out.println("initial mem used: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");
        long initialFreeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);

        Random random = new Random();
        byte[] array = new byte[400000];

        while (size > 0) {
            random.nextBytes(array);
            for (byte b : array) {
                sum += b;
            }
            size--;
        }
        long finalFreeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);

        // Calculate memory used by the program
        long memoryUsed = initialFreeMemory - finalFreeMemory;
        System.out.println("final mem used: " + Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");

        System.out.println("Total memory used: " + memoryUsed + " MB");
    }
    public void clean(){

    }

    public void cancel(){

    }
}