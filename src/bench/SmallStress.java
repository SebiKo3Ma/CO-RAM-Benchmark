package bench;
import java.util.Random;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;


public class SmallStress implements IBenchmark{
    long iterations, UsedMemory;
    int byteArray;

    public void initialize(Object...options){

    }
    public void run(){

    }
    public void run(Object...options) {
        System.gc();
        iterations = (long)options[0];
        byteArray = (int)options[1];
        int sum = 0;

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage initialMemoryUsage = memoryBean.getHeapMemoryUsage();
        long initialMemory = initialMemoryUsage.getMax()/( 1024 * 1024);
        System.out.println ("Initial allocated memory: " + initialMemory + " MB");

        Random random = new Random();
        byte[] array = new byte[byteArray];

        while (iterations > 0) {
            random.nextBytes(array);
            for (byte b : array) {
                sum += b;

            }
            iterations--;
        }

        MemoryUsage MemoryUsage = memoryBean.getHeapMemoryUsage();
        UsedMemory = MemoryUsage.getUsed()/ (1024 * 1024);
        System.out.println("Memory used for running the program: " + UsedMemory + " MB");

        System.gc();

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