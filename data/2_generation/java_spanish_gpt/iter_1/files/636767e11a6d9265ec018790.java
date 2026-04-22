import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ThreadSnapshot {
    // Assuming ThreadSnapshot has some properties
    private String threadName;
    private long timestamp;

    public ThreadSnapshot(String threadName, long timestamp) {
        this.threadName = threadName;
        this.timestamp = timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public long getTimestamp() {
        return timestamp;
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

public class ThreadSnapshotParser {

    /** 
     * Cargar instantáneas de hilos en el rango de tiempo especificado
     */
    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the line format is "threadName,timestamp"
                String[] parts = line.split(",");
                if (parts.length != 2) continue;

                String threadName = parts[0];
                long timestamp;
                try {
                    timestamp = Long.parseLong(parts[1]);
                } catch (NumberFormatException e) {
                    continue; // Skip lines with invalid timestamp
                }

                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                        snapshots.add(new ThreadSnapshot(threadName, timestamp));
                        break; // No need to check other ranges once added
                    }
                }
            }
        }
        
        return snapshots;
    }
}