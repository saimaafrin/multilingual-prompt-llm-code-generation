import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThreadSnapshotParser {

    public static class ThreadSnapshot {
        private long timestamp;
        private String threadName;
        private String threadState;

        public ThreadSnapshot(long timestamp, String threadName, String threadState) {
            this.timestamp = timestamp;
            this.threadName = threadName;
            this.threadState = threadState;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getThreadName() {
            return threadName;
        }

        public String getThreadState() {
            return threadState;
        }

        @Override
        public String toString() {
            return "ThreadSnapshot{" +
                    "timestamp=" + timestamp +
                    ", threadName='" + threadName + '\'' +
                    ", threadState='" + threadState + '\'' +
                    '}';
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

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                long timestamp = Long.parseLong(parts[0]);
                String threadName = parts[1];
                String threadState = parts[2];

                for (ProfileAnalyzeTimeRange range : timeRanges) {
                    if (timestamp >= range.getStartTime() && timestamp <= range.getEndTime()) {
                        snapshots.add(new ThreadSnapshot(timestamp, threadName, threadState));
                        break;
                    }
                }
            }
        }

        return snapshots;
    }

    public static void main(String[] args) {
        try {
            File file = new File("thread_snapshots.txt");
            List<ProfileAnalyzeTimeRange> timeRanges = new ArrayList<>();
            timeRanges.add(new ProfileAnalyzeTimeRange(1000L, 2000L));
            timeRanges.add(new ProfileAnalyzeTimeRange(3000L, 4000L));

            List<ThreadSnapshot> snapshots = parseFromFileWithTimeRange(file, timeRanges);
            for (ThreadSnapshot snapshot : snapshots) {
                System.out.println(snapshot);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}