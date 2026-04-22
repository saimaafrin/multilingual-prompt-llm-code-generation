import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> constantPool = new HashMap<>();

    /**
     * 将一个 CONSTANT_NameAndType_info 添加到该符号表的常量池中。如果常量池已经包含类似项，则不执行任何操作。
     * @param name 字段或方法名称。
     * @param descriptor 字段或方法描述符。
     * @return 具有给定值的新符号或已存在的符号。
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (constantPool.containsKey(key)) {
            return constantPool.get(key);
        } else {
            int newIndex = constantPool.size() + 1; // Assuming index starts from 1
            constantPool.put(key, newIndex);
            return newIndex;
        }
    }
}