import java.util.ArrayList;
import java.util.List;

public class ConfigSnapshot {

    /**
     * 构建当前配置文件段快照搜索序列范围
     * @return 返回一个包含SequenceRange对象的列表
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // 假设我们有一些配置段的范围数据
        // 这里我们模拟一些数据
        sequenceRanges.add(new SequenceRange(1, 100));
        sequenceRanges.add(new SequenceRange(101, 200));
        sequenceRanges.add(new SequenceRange(201, 300));
        
        return sequenceRanges;
    }

    // 假设SequenceRange是一个简单的类，表示一个范围
    public static class SequenceRange {
        private int start;
        private int end;

        public SequenceRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "SequenceRange{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        ConfigSnapshot configSnapshot = new ConfigSnapshot();
        List<SequenceRange> ranges = configSnapshot.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}