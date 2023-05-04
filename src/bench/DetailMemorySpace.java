package bench;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class DetailMemorySpace {
        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalMemory = osBean.getTotalPhysicalMemorySize();
        long freeMemory = osBean.getFreePhysicalMemorySize();
        long usedMemory = totalMemory - freeMemory;
        double usedGB = (double) usedMemory / (1024 * 1024 * 1024);
        double totalGB = (double) totalMemory / (1024 * 1024 * 1024);
        double freeGB = (double) freeMemory / (1024 * 1024 * 1024);
        public void printMemoryDetails() {
                System.out.println("Total Memory: " + totalGB + " GB");
                System.out.println("Used Memory: " + usedGB + " GB");
                System.out.println("Free Memory: " + freeGB + " GB");
        }
}