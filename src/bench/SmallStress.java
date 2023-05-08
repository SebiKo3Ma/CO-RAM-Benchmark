package bench;
import java.util.Random;

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

        Random random = new Random();
        byte[] array = new byte[100000];

        while (size > 0) {
            random.nextBytes(array);
            size--;
            for (byte b : array) {
                sum += b;
            }
        }
        System.out.println("total : " +  Runtime.getRuntime().totalMemory() + "\n");
        System.out.println("free : " +  Runtime.getRuntime().freeMemory() + "\n");
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Total memory used: " + memoryUsed + " bytes");
    }
    public void clean(){

    }

    public void cancel(){

    }
}