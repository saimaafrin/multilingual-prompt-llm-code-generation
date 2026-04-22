import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThreadSnapshotParser {

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

        for (String line : lines) {
            ThreadSnapshot snapshot = ThreadSnapshot.parse(line);
            if (snapshot != null && isWithinTimeRange(snapshot, timeRanges)) {
                snapshots.add(snapshot);
            }
        }

        return snapshots;
    }

    private static boolean isWithinTimeRange(ThreadSnapshot snapshot, List<ProfileAnalyzeTimeRange> timeRanges) {
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (snapshot.getTimestamp() >= range.getStartTime() && snapshot.getTimestamp() <= range.getEndTime()) {
                return true;
            }
        }
        return false;
    }

    // Assuming ThreadSnapshot and ProfileAnalyzeTimeRange classes are defined elsewhere
    static class ThreadSnapshot {
        private long timestamp;

        public ThreadSnapshot(long timestamp) {
            this.timestamp = timestamp;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public static ThreadSnapshot parse(String line) {
            // Implement parsing logic here
            // For example, parse the timestamp from the line
            try {
                long timestamp = Long.parseLong(line.split(",")[0]);
                return new ThreadSnapshot(timestamp);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class ProfileAnalyzeTimeRange {
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