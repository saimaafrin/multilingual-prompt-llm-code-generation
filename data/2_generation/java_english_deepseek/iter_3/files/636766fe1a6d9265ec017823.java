import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> constantPool = new HashMap<>();
    private int nextIndex = 1;

    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (constantPool.containsKey(key)) {
            return constantPool.get(key);
        } else {
            constantPool.put(key, nextIndex);
            return nextIndex++;
        }
    }
}