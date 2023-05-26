package bench;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class DetailMemorySpace {

        static OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        static long totalMemory = osBean.getTotalPhysicalMemorySize();
        static long freeMemory = osBean.getFreePhysicalMemorySize();
        static long usedMemory = totalMemory - freeMemory;
        static double usedGB = (double) usedMemory / (1024 * 1024 * 1024);
        static double totalGB = (double) totalMemory / (1024 * 1024 * 1024);
        static double freeGB = (double) freeMemory / (1024 * 1024 * 1024);

        public static double getFreeGB() {
                return freeGB;
        }

        public static double getTotalGB() {
                return totalGB;
        }

        public static double getUsedGB() {
                return usedGB;
        }

        public void printMemoryDetails() {
                System.out.println("Total Memory: " + totalGB + " GB");
                System.out.println("Used Memory: " + usedGB + " GB");
                System.out.println("Free Memory: " + freeGB + " GB");
        }
}