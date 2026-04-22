import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class ThreadSnapshotLoader {

    /**
     * load thread snapshots in appointing time range
     * @param startTime start time in milliseconds
     * @param endTime end time in milliseconds 
     * @return List of ThreadInfo objects containing thread snapshots
     */
    public List<ThreadInfo> loadThreadSnapshots(long startTime, long endTime) {
        List<ThreadInfo> snapshots = new ArrayList<>();
        
        // Get the thread management bean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Get current time
        long currentTime = System.currentTimeMillis();

        // Validate time range
        if (startTime > endTime || endTime > currentTime) {
            return snapshots;
        }

        // Get all thread IDs
        long[] threadIds = threadMXBean.getAllThreadIds();

        // Get thread info for each thread
        for (long threadId : threadIds) {
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            
            if (threadInfo != null) {
                // Get thread start time (approximate)
                long threadStartTime = threadInfo.getThreadState() == Thread.State.NEW ? 
                    currentTime : threadInfo.getThreadCpuTime();
                
                // Only add threads that were active in the specified time range
                if (threadStartTime >= startTime && threadStartTime <= endTime) {
                    snapshots.add(threadInfo);
                }
            }
        }

        return snapshots;
    }
}