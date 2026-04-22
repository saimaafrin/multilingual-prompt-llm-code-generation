import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<String> typeTable;
    
    public SymbolTable() {
        typeTable = new ArrayList<>();
    }
    
    /**
     * 在此符号表的类型表中添加一个类型。如果类型表已经包含类似类型，则不执行任何操作。
     * @param value 一个内部类名。
     * @return 具有给定值的新类型符号或已存在类型符号的索引。
     */
    public int addType(final String value) {
        // Check if type already exists
        for (int i = 0; i < typeTable.size(); i++) {
            if (typeTable.get(i).equals(value)) {
                return i;
            }
        }
        
        // Add new type if not found
        typeTable.add(value);
        return typeTable.size() - 1;
    }
}