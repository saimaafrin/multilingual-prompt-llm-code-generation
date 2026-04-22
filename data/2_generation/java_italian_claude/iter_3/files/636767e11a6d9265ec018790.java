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
                    if (line.startsWith("Thread-")) {
                        String[] parts = line.split("\\s+");
                        if (parts.length >= 2) {
                            String threadName = parts[0];
                            String threadState = parts[1];
                            currentSnapshot.addThread(threadName, threadState);
                        }
                    }
                    // Parse stack trace
                    else if (line.startsWith("\tat ")) {
                        currentSnapshot.addStackTraceLine(line.trim());
                    }
                }
            }
        }
        
        return snapshots;
    }
}

// Supporting classes (would be in separate files)
class ThreadSnapshot {
    private long timestamp;
    private Map<String, String> threads;
    private List<String> stackTrace;
    
    public ThreadSnapshot() {
        threads = new HashMap<>();
        stackTrace = new ArrayList<>();
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public void addThread(String name, String state) {
        threads.put(name, state);
    }
    
    public void addStackTraceLine(String line) {
        stackTrace.add(line);
    }
    
    // Getters
    public long getTimestamp() {
        return timestamp;
    }
    
    public Map<String, String> getThreads() {
        return threads;
    }
    
    public List<String> getStackTrace() {
        return stackTrace;
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