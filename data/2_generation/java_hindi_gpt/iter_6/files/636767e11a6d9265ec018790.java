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
                long timestamp = Long.parseLong(parts[0]);
                String threadInfo = parts[1];

                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                        snapshots.add(new ThreadSnapshot(timestamp, threadInfo));
                        break; // No need to check other ranges if already added
                    }
                }
            }
        }
        
        return snapshots;
    }
}