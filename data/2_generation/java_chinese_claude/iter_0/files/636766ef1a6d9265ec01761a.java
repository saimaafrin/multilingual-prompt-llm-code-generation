import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<String> types;
    
    public SymbolTable() {
        types = new ArrayList<>();
    }
    
    /**
     * 在此符号表的类型表中添加一个类型。如果类型表已经包含类似类型，则不执行任何操作。
     * @param value 一个内部类名。
     * @return 具有给定值的新类型符号或已存在类型符号的索引。
     */
    public int addType(final String value) {
        // 首先检查类型是否已存在
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(value)) {
                return i; // 返回已存在类型的索引
            }
        }
        
        // 如果类型不存在，添加到类型表中
        types.add(value);
        return types.size() - 1; // 返回新添加类型的索引
    }
}