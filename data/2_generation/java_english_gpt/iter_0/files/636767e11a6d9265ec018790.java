import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ThreadSnapshot {
    private String threadName;
    private long timestamp;

    public ThreadSnapshot(String threadName, long timestamp) {
        this.threadName = threadName;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ThreadSnapshot{" +
                "threadName='" + threadName + '\'' +
                ", timestamp=" + timestamp +
                '}';
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
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String threadName = parts[0];
                long timestamp = Long.parseLong(parts[1]);

                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                        snapshots.add(new ThreadSnapshot(threadName, timestamp));
                        break;
                    }
                }
            }
        }
        return snapshots;
    }
}