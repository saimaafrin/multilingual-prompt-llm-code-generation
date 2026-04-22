import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadSnapshotAnalyzer {

    public static class ThreadSnapshot {
        private LocalDateTime timestamp;
        private String threadName;
        private String threadState;
        private List<String> stackTrace;
        
        public ThreadSnapshot(LocalDateTime timestamp, String threadName, String threadState, List<String> stackTrace) {
            this.timestamp = timestamp;
            this.threadName = threadName;
            this.threadState = threadState;
            this.stackTrace = stackTrace;
        }
        
        // Getters
        public LocalDateTime getTimestamp() { return timestamp; }
        public String getThreadName() { return threadName; }
        public String getThreadState() { return threadState; }
        public List<String> getStackTrace() { return stackTrace; }
    }

    public static class ProfileAnalyzeTimeRange {
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        
        public ProfileAnalyzeTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        public boolean isInRange(LocalDateTime time) {
            return !time.isBefore(startTime) && !time.isAfter(endTime);
        }
    }

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) 
            throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            LocalDateTime currentTimestamp = null;
            String currentThreadName = null;
            String currentThreadState = null;
            List<String> currentStackTrace = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time:")) {
                    // If we have a complete snapshot, check if it's in range and add it
                    if (currentTimestamp != null && currentThreadName != null) {
                        boolean inRange = false;
                        for (ProfileAnalyzeTimeRange range : timeRanges) {
                            if (range.isInRange(currentTimestamp)) {
                                inRange = true;
                                break;
                            }
                        }
                        
                        if (inRange) {
                            snapshots.add(new ThreadSnapshot(
                                currentTimestamp,
                                currentThreadName,
                                currentThreadState,
                                new ArrayList<>(currentStackTrace)
                            ));
                        }
                    }
                    
                    // Start new snapshot
                    String timeStr = line.substring(6).trim();
                    currentTimestamp = LocalDateTime.parse(timeStr, formatter);
                    currentStackTrace.clear();
                }
                else if (line.startsWith("Thread:")) {
                    currentThreadName = line.substring(8).trim();
                }
                else if (line.startsWith("State:")) {
                    currentThreadState = line.substring(7).trim();
                }
                else if (!line.trim().isEmpty()) {
                    currentStackTrace.add(line.trim());
                }
            }
            
            // Add the last snapshot if it exists and is in range
            if (currentTimestamp != null && currentThreadName != null) {
                boolean inRange = false;
                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (range.isInRange(currentTimestamp)) {
                        inRange = true;
                        break;
                    }
                }
                
                if (inRange) {
                    snapshots.add(new ThreadSnapshot(
                        currentTimestamp,
                        currentThreadName,
                        currentThreadState,
                        new ArrayList<>(currentStackTrace)
                    ));
                }
            }
        }
        
        return snapshots;
    }
}