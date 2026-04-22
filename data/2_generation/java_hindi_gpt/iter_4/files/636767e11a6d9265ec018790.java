import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean isInRange(long time) {
        return time >= startTime && time <= endTime;
    }
}

class ThreadSnapshot {
    private long timestamp;
    private String threadInfo;

    public ThreadSnapshot(long timestamp, String threadInfo) {
        this.timestamp = timestamp;
        this.threadInfo = threadInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getThreadInfo() {
        return threadInfo;
    }
}

public class ThreadSnapshotParser {

    /** 
     * निर्दिष्ट समय सीमा में थ्रेड स्नैपशॉट लोड करें
     */
    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue; // Skip invalid lines
                
                long timestamp = Long.parseLong(parts[0].trim());
                String threadInfo = parts[1].trim();
                
                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (range.isInRange(timestamp)) {
                        snapshots.add(new ThreadSnapshot(timestamp, threadInfo));
                        break; // No need to check other ranges
                    }
                }
            }
        }
        
        return snapshots;
    }
}