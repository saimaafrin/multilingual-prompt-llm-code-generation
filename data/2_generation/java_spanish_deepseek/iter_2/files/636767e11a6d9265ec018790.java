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
        // Implement the logic to parse a line into a ThreadSnapshot object
        // This is a placeholder implementation
        return new ThreadSnapshot();
    }

    private static boolean isWithinTimeRange(ThreadSnapshot snapshot, List<ProfileAnalyzeTimeRange> timeRanges) {
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (snapshot.getTimestamp() >= range.getStartTime() && snapshot.getTimestamp() <= range.getEndTime()) {
                return true;
            }
        }
        return false;
    }

    // Assuming ThreadSnapshot and ProfileAnalyzeTimeRange classes are defined as follows:
    public static class ThreadSnapshot {
        private long timestamp;

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class ProfileAnalyzeTimeRange {
        private long startTime;
        private long endTime;

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
    }
}