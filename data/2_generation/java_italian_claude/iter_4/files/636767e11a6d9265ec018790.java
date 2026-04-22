import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                    String timestamp = line.substring(6).trim();
                    LocalDateTime dateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    
                    // Check if timestamp is within any of the time ranges
                    isInTimeRange = false;
                    for (ProfileAnalyzeTimeRange range : timeRanges) {
                        if (dateTime.isAfter(range.getStartTime()) && 
                            dateTime.isBefore(range.getEndTime())) {
                            isInTimeRange = true;
                            break;
                        }
                    }
                    
                    if (isInTimeRange) {
                        currentSnapshot = new ThreadSnapshot();
                        currentSnapshot.setTimestamp(dateTime);
                        snapshots.add(currentSnapshot);
                    }
                } else if (isInTimeRange && currentSnapshot != null) {
                    // Parse thread information
                    if (line.trim().length() > 0) {
                        ThreadInfo threadInfo = parseThreadInfo(line);
                        if (threadInfo != null) {
                            currentSnapshot.addThreadInfo(threadInfo);
                        }
                    }
                }
            }
        }
        
        return snapshots;
    }
    
    private static ThreadInfo parseThreadInfo(String line) {
        // Helper method to parse individual thread information
        try {
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 3) {
                ThreadInfo info = new ThreadInfo();
                info.setId(Long.parseLong(parts[0]));
                info.setState(parts[1]);
                info.setName(String.join(" ", Arrays.copyOfRange(parts, 2, parts.length)));
                return info;
            }
        } catch (NumberFormatException e) {
            // Skip invalid lines
        }
        return null;
    }
}

// Supporting classes (would typically be in separate files)
class ThreadSnapshot {
    private LocalDateTime timestamp;
    private List<ThreadInfo> threads = new ArrayList<>();
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public void addThreadInfo(ThreadInfo thread) {
        threads.add(thread);
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public List<ThreadInfo> getThreads() {
        return threads;
    }
}

class ThreadInfo {
    private long id;
    private String state;
    private String name;
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public String getState() {
        return state;
    }
    
    public String getName() {
        return name;
    }
}

class ProfileAnalyzeTimeRange {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}