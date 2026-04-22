import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /** 
     * construir el rango de secuencias del segmento de perfiles actuales
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Aquí se puede agregar la lógica para construir los rangos de secuencias
        // Por ejemplo, se puede simular la creación de algunos rangos de secuencias
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