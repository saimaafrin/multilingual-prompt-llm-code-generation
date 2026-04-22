import java.io.*;
import java.util.*;

public class ThreadSnapshotParser {

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            ThreadSnapshot currentSnapshot = null;
            boolean isInTimeRange = false;
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time:")) {
                    // Parse timestamp
                    long timestamp = Long.parseLong(line.substring(5).trim());
                    
                    // Check if timestamp is within any of the time ranges
                    isInTimeRange = false;
                    for (ProfileAnalyzeTimeRange range : timeRanges) {
                        if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                            isInTimeRange = true;
                            break;
                        }
                    }
                    
                    if (isInTimeRange) {
                        currentSnapshot = new ThreadSnapshot();
                        currentSnapshot.setTimestamp(timestamp);
                        snapshots.add(currentSnapshot);
                    }
                } else if (isInTimeRange && currentSnapshot != null) {
                    // Parse thread info
                    if (line.trim().length() > 0) {
                        String[] threadInfo = line.split("\\s+");
                        if (threadInfo.length >= 2) {
                            ThreadInfo info = new ThreadInfo();
                            info.setThreadId(Long.parseLong(threadInfo[0]));
                            info.setThreadName(threadInfo[1]);
                            info.setThreadState(threadInfo.length > 2 ? threadInfo[2] : "UNKNOWN");
                            currentSnapshot.addThreadInfo(info);
                        }
                    }
                }
            }
        }
        
        return snapshots;
    }
}

class ThreadSnapshot {
    private long timestamp;
    private List<ThreadInfo> threadInfoList = new ArrayList<>();
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public void addThreadInfo(ThreadInfo info) {
        threadInfoList.add(info);
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public List<ThreadInfo> getThreadInfoList() {
        return threadInfoList;
    }
}

class ThreadInfo {
    private long threadId;
    private String threadName;
    private String threadState;
    
    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }
    
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
    
    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }
    
    public long getThreadId() {
        return threadId;
    }
    
    public String getThreadName() {
        return threadName;
    }
    
    public String getThreadState() {
        return threadState;
    }
}

class ProfileAnalyzeTimeRange {
    private long startTime;
    private long endTime;
    
    public ProfileAnalyzeTimeRange(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public long getEndTime() {
        return endTime;
    }
}