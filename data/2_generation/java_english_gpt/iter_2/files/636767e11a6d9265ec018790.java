import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ThreadSnapshot {
    // Assuming ThreadSnapshot has a timestamp and other relevant fields
    private long timestamp;

    public ThreadSnapshot(long timestamp) {
        this.timestamp = timestamp;
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
     * load thread snapshots in appointing time range
     */
    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line contains a timestamp in milliseconds
                long timestamp = Long.parseLong(line.trim());
                ThreadSnapshot snapshot = new ThreadSnapshot(timestamp);
                
                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                        snapshots.add(snapshot);
                        break; // No need to check other ranges if already added
                    }
                }
            }
        }
        
        return snapshots;
    }
}