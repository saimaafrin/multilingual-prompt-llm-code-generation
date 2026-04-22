import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /** 
     * construir el rango de secuencias del segmento de perfiles actuales
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to build sequence ranges
        // This is a placeholder and should be replaced with actual logic
        for (int i = 0; i < 10; i++) {
            sequenceRanges.add(new SequenceRange(i, i + 1));
        }
        
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