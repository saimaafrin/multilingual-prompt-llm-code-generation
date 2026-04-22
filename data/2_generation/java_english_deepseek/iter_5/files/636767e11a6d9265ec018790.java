import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ThreadSnapshotParser {

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        List<String> lines = Files.readAllLines(file.toPath());

        for (String line : lines) {
            ThreadSnapshot snapshot = parseLine(line);
            if (snapshot != null && isWithinTimeRange(snapshot, timeRanges)) {
                snapshots.add(snapshot);
            }
        }

        return snapshots;
    }

    private static ThreadSnapshot parseLine(String line) {
        // Assuming the line is in a specific format, e.g., "timestamp,threadId,state"
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return null;
        }

        long timestamp = Long.parseLong(parts[0]);
        long threadId = Long.parseLong(parts[1]);
        String state = parts[2];

        return new ThreadSnapshot(timestamp, threadId, state);
    }

    private static boolean isWithinTimeRange(ThreadSnapshot snapshot, List<ProfileAnalyzeTimeRange> timeRanges) {
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (snapshot.getTimestamp() >= range.getStartTime() && snapshot.getTimestamp() <= range.getEndTime()) {
                return true;
            }
        }
        return false;
    }

    public static class ThreadSnapshot {
        private long timestamp;
        private long threadId;
        private String state;

        public ThreadSnapshot(long timestamp, long threadId, String state) {
            this.timestamp = timestamp;
            this.threadId = threadId;
            this.state = state;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getThreadId() {
            return threadId;
        }

        public String getState() {
            return state;
        }
    }

    public static class ProfileAnalyzeTimeRange {
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
}