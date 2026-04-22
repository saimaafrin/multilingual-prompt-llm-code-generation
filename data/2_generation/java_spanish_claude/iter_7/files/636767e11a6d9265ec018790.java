import java.io.*;
import java.util.*;

public class ThreadSnapshotParser {

    public static class ThreadSnapshot {
        private long timestamp;
        private String threadName;
        private String threadState;
        private List<String> stackTrace;

        public ThreadSnapshot(long timestamp, String threadName, String threadState, List<String> stackTrace) {
            this.timestamp = timestamp;
            this.threadName = threadName;
            this.threadState = threadState;
            this.stackTrace = stackTrace;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }

    public static class ProfileAnalyzeTimeRange {
        private long startTime;
        private long endTime;

        public ProfileAnalyzeTimeRange(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isInRange(long timestamp) {
            return timestamp >= startTime && timestamp <= endTime;
        }
    }

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            long currentTimestamp = -1;
            String currentThreadName = null;
            String currentThreadState = null;
            List<String> currentStackTrace = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Time:")) {
                    // If we were processing a previous snapshot, save it
                    if (currentTimestamp != -1) {
                        ThreadSnapshot snapshot = new ThreadSnapshot(
                            currentTimestamp, 
                            currentThreadName,
                            currentThreadState,
                            new ArrayList<>(currentStackTrace)
                        );
                        
                        // Only add if timestamp is in any of the specified ranges
                        for (ProfileAnalyzeTimeRange range : timeRanges) {
                            if (range.isInRange(currentTimestamp)) {
                                snapshots.add(snapshot);
                                break;
                            }
                        }
                    }
                    
                    // Start new snapshot
                    currentTimestamp = Long.parseLong(line.substring(5).trim());
                    currentStackTrace.clear();
                } else if (line.startsWith("Thread:")) {
                    currentThreadName = line.substring(7).trim();
                } else if (line.startsWith("State:")) {
                    currentThreadState = line.substring(6).trim();
                } else if (!line.trim().isEmpty()) {
                    currentStackTrace.add(line.trim());
                }
            }
            
            // Handle last snapshot
            if (currentTimestamp != -1) {
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