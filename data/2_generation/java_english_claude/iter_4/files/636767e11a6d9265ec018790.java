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

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }

    public static class ProfileAnalyzeTimeRange {
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public ProfileAnalyzeTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isInRange(LocalDateTime timestamp) {
            return !timestamp.isBefore(startTime) && !timestamp.isAfter(endTime);
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
                    // If we were processing a snapshot, check if it's in range and add it
                    if (currentTimestamp != null) {
                        ThreadSnapshot snapshot = new ThreadSnapshot(
                            currentTimestamp, 
                            currentThreadName,
                            currentThreadState,
                            new ArrayList<>(currentStackTrace)
                        );
                        
                        // Check if snapshot is in any of the time ranges
                        for (ProfileAnalyzeTimeRange range : timeRanges) {
                            if (range.isInRange(currentTimestamp)) {
                                snapshots.add(snapshot);
                                break;
                            }
                        }
                    }
                    
                    // Start new snapshot
                    currentTimestamp = LocalDateTime.parse(line.substring(6));
                    currentStackTrace.clear();
                } else if (line.startsWith("Thread:")) {
                    currentThreadName = line.substring(8);
                } else if (line.startsWith("State:")) {
                    currentThreadState = line.substring(7);
                } else if (!line.trim().isEmpty()) {
                    currentStackTrace.add(line.trim());
                }
            }
            
            // Handle last snapshot
            if (currentTimestamp != null) {
                ThreadSnapshot snapshot = new ThreadSnapshot(
                    currentTimestamp,
                    currentThreadName,
                    currentThreadState,
                    new ArrayList<>(currentStackTrace)
                );
                
                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (range.isInRange(currentTimestamp)) {
                        snapshots.add(snapshot);
                        break;
                    }
                }
            }
        }
        
        return snapshots;
    }
}