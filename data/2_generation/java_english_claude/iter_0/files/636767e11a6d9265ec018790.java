import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class ThreadSnapshotLoader {

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
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            LocalDateTime currentTimestamp = null;
            String currentThreadName = null;
            String currentThreadState = null;
            List<String> currentStackTrace = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time:")) {
                    // Save previous snapshot if exists
                    if (currentTimestamp != null && isInAnyTimeRange(currentTimestamp, timeRanges)) {
                        snapshots.add(new ThreadSnapshot(currentTimestamp, currentThreadName, 
                            currentThreadState, new ArrayList<>(currentStackTrace)));
                    }
                    
                    // Start new snapshot
                    currentTimestamp = parseTimestamp(line);
                    currentStackTrace.clear();
                } else if (line.startsWith("Thread:")) {
                    currentThreadName = parseThreadName(line);
                    currentThreadState = parseThreadState(line);
                } else if (!line.trim().isEmpty()) {
                    currentStackTrace.add(line.trim());
                }
            }
            
            // Add last snapshot if in range
            if (currentTimestamp != null && isInAnyTimeRange(currentTimestamp, timeRanges)) {
                snapshots.add(new ThreadSnapshot(currentTimestamp, currentThreadName,
                    currentThreadState, new ArrayList<>(currentStackTrace)));
            }
        }
        
        return snapshots;
    }
    
    private static boolean isInAnyTimeRange(LocalDateTime time, List<ProfileAnalyzeTimeRange> timeRanges) {
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (range.isInRange(time)) {
                return true;
            }
        }
        return false;
    }
    
    private static LocalDateTime parseTimestamp(String line) {
        // Implementation depends on actual timestamp format in file
        // This is a placeholder
        return LocalDateTime.now();
    }
    
    private static String parseThreadName(String line) {
        // Implementation depends on actual thread info format in file
        // This is a placeholder
        return line.substring(line.indexOf(":") + 1).trim();
    }
    
    private static String parseThreadState(String line) {
        // Implementation depends on actual thread state format in file
        // This is a placeholder
        return "RUNNING";
    }
}