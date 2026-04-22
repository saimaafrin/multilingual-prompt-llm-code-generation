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
        // Assuming ThreadSnapshot has a constructor or a method to parse from a string
        // This is a placeholder implementation
        try {
            return new ThreadSnapshot(line);
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isWithinTimeRange(ThreadSnapshot snapshot, List<ProfileAnalyzeTimeRange> timeRanges) {
        long snapshotTime = snapshot.getTimestamp();
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (snapshotTime >= range.getStartTime() && snapshotTime <= range.getEndTime()) {
                return true;
            }
        }
        return false;
    }

    // Assuming ThreadSnapshot and ProfileAnalyzeTimeRange classes are defined elsewhere
    // Placeholder classes for demonstration purposes
    public static class ThreadSnapshot {
        private long timestamp;
        private String data;

        public ThreadSnapshot(String line) {
            // Parse the line to extract timestamp and data
            // This is a placeholder implementation
            String[] parts = line.split(",");
            this.timestamp = Long.parseLong(parts[0]);
            this.data = parts[1];
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getData() {
            return data;
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