package bench;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.Vector;


public class MemoryEaterTest implements IBenchmark{
    OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    static int count = 0;

    public void run(){

        Vector v = new Vector();

        long targetFreeMemory = 500L * 1024L * 1024L;
        System.out.println("Free memory: " + targetFreeMemory/(1024*1024));

        long freeMemory = osBean.getFreePhysicalMemorySize();

        while (freeMemory > targetFreeMemory) {
            freeMemory = osBean.getFreePhysicalMemorySize();

                try {
                    count++;
                    byte b[] = new byte[4 * 1048576];
                    v.add(b);
                    if(freeMemory <= targetFreeMemory) {
                        break;
                    }

                } catch (OutOfMemoryError e) {
                    try {
                        System.out.println("\nProgram has reached " + count + " iterations");
                    } catch (OutOfMemoryError f) {
                        ;
                    }
                    break;
                    }

            }

    }

    public int getIterations(){
        return count;
    }

    public void run(Object ... params) {

    }

    public void initialize(Object ... params){

    }

    public void clean(){

    }

    public void cancel(){

    }
}
