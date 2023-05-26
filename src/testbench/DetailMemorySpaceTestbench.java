package testbench;

import bench.DetailMemorySpace;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class DetailMemorySpaceTestbench{
    public static void main() {
        DetailMemorySpace memorySpace = new DetailMemorySpace();
       // memorySpace.printMemoryDetails();

    }
    public double getFreeGB() {
        return bench.DetailMemorySpace.getFreeGB();
    }
    public double getTotalGB() {
        return bench.DetailMemorySpace.getTotalGB();
    }
    public double getUsedGB() {
        return bench.DetailMemorySpace.getUsedGB();
    }

}



