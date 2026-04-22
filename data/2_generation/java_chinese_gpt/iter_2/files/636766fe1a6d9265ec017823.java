import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> constantPool;
    private int nextIndex;

    public ConstantPool() {
        this.constantPool = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * 将一个 CONSTANT_NameAndType_info 添加到该符号表的常量池中。如果常量池已经包含类似项，则不执行任何操作。
     * @param name 字段或方法名称。
     * @param descriptor 字段或方法描述符。
     * @return 具有给定值的新符号或已存在的符号。
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!constantPool.containsKey(key)) {
            constantPool.put(key, nextIndex);
            nextIndex++;
        }
        return constantPool.get(key);
    }

    public static void main(String[] args) {
        ConstantPool pool = new ConstantPool();
        int index1 = pool.addConstantNameAndType("myField", "I");
        int index2 = pool.addConstantNameAndType("myField", "I");
        System.out.println("Index of first addition: " + index1);
        System.out.println("Index of second addition (should be the same): " + index2);
    }
}