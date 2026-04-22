import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> nameAndTypeMap = new HashMap<>();
    private int nextIndex = 1;

    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (nameAndTypeMap.containsKey(key)) {
            return nameAndTypeMap.get(key);
        } else {
            nameAndTypeMap.put(key, nextIndex);
            return nextIndex++;
        }
    }
}