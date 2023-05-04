package testbench;

import bench.DetailMemorySpace;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class DetailMemorySpaceTestbench{
    public static void main(String[] args) {
        DetailMemorySpace memorySpace = new DetailMemorySpace();
        memorySpace.printMemoryDetails();
    }
}



