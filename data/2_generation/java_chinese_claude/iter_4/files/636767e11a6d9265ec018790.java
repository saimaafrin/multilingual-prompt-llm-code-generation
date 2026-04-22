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

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
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
                    // If we were processing a thread, save it if it's in range
                    if (currentTimestamp != null && currentThreadName != null) {
                        boolean inRange = timeRanges.stream()
                            .anyMatch(range -> range.isInRange(currentTimestamp));
                        
                        if (inRange) {
                            snapshots.add(new ThreadSnapshot(
                                currentTimestamp,
                                currentThreadName,
                                currentThreadState,
                                new ArrayList<>(currentStackTrace)
                            ));
                        }
                    }
                    
                    // Start new thread snapshot
                    String timeStr = line.substring(6).trim();
                    currentTimestamp = LocalDateTime.parse(timeStr, formatter);
                    currentStackTrace.clear();
                } else if (line.startsWith("Thread")) {
                    currentThreadName = line.trim();
                    // Assume next line contains thread state
                    line = reader.readLine();
                    currentThreadState = line.trim();
                } else if (!line.trim().isEmpty()) {
                    currentStackTrace.add(line.trim());
                }
            }
            
            // Handle last thread if exists
            if (currentTimestamp != null && currentThreadName != null) {
                boolean inRange = timeRanges.stream()
                    .anyMatch(range -> range.isInRange(currentTimestamp));
                    
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