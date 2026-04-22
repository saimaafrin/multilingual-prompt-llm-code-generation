import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> accumulatorMap;

    public Accumulator() {
        this.accumulatorMap = new HashMap<>();
    }

    /**
     * Accumula il valore con il valore esistente nella stessa chiave fornita.
     */
    public void valueAccumulation(String key, Long value) {
        if (key == null || value == null) {
            return;
        }

        accumulatorMap.merge(key, value, Long::sum);
    }
}