import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /** 
     * 构建当前配置文件段快照搜索序列范围
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to populate sequenceRanges
        // This should be replaced with actual logic to build the sequence ranges
        sequenceRanges.add(new SequenceRange(1, 10));
        sequenceRanges.add(new SequenceRange(11, 20));
        sequenceRanges.add(new SequenceRange(21, 30));
        
        return sequenceRanges;
    }

    public static void main(String[] args) {
        SequenceRangeBuilder builder = new SequenceRangeBuilder();
        List<SequenceRange> ranges = builder.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}

class SequenceRange {
    private int start;
    private int end;

    public SequenceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SequenceRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}