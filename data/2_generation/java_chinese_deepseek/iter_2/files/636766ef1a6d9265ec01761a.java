import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> typeTable;
    private int nextIndex;

    public SymbolTable() {
        this.typeTable = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * 在此符号表的类型表中添加一个类型。如果类型表已经包含类似类型，则不执行任何操作。
     * @param value 一个内部类名。
     * @return 具有给定值的新类型符号或已存在类型符号的索引。
     */
    public int addType(final String value) {
        if (typeTable.containsKey(value)) {
            return typeTable.get(value);
        } else {
            typeTable.put(value, nextIndex);
            return nextIndex++;
        }
    }
}