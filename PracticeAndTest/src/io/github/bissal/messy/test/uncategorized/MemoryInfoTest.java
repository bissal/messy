package io.github.bissal.messy.test.uncategorized;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

public class MemoryInfoTest {
	public MemoryInfoTest() {
		System.out.println("runtime");
		
		long totalMemorySize = Runtime.getRuntime().totalMemory();
		long maxMemorySize = Runtime.getRuntime().maxMemory();
		long freeMemorySize = Runtime.getRuntime().freeMemory();
		
		System.out.println(totalMemorySize);
		System.out.println(freeMemorySize);
		System.out.println(maxMemorySize);
		
		System.out.println("management factory");
		
		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		MemoryUsage usage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
		
		System.out.println(usage.getCommitted());
		System.out.println(usage.getInit());
		System.out.println(usage.getUsed());
		System.out.println(usage.getMax());
		
		
//		com.sun.management.OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) osBean;
//		long total = ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize();
		
//		System.out.println(total);
		
		
	}
}
