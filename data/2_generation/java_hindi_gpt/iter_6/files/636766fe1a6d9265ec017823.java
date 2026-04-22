import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> constantNameAndTypePool;
    private int nextIndex;

    public ConstantPool() {
        this.constantNameAndTypePool = new HashMap<>();
        this.nextIndex = 1; // Start indexing from 1
    }

    /**
     * इस प्रतीक तालिका के स्थायी पूल में एक CONSTANT_NameAndType_info जोड़ता है। यदि स्थायी पूल में पहले से ही समान आइटम मौजूद है, तो कुछ नहीं करता है।
     * @param name एक फ़ील्ड या विधि का नाम।
     * @param descriptor एक फ़ील्ड या विधि का विवरण।
     * @return दिए गए मान के साथ एक नया या पहले से मौजूद प्रतीक।
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!constantNameAndTypePool.containsKey(key)) {
            constantNameAndTypePool.put(key, nextIndex++);
        }
        return constantNameAndTypePool.get(key);
    }

    public static void main(String[] args) {
        ConstantPool pool = new ConstantPool();
        int index1 = pool.addConstantNameAndType("myField", "I");
        int index2 = pool.addConstantNameAndType("myField", "I");
        int index3 = pool.addConstantNameAndType("myMethod", "(I)V");

        System.out.println("Index of myField: " + index1); // Should print 1
        System.out.println("Index of myField again: " + index2); // Should print 1
        System.out.println("Index of myMethod: " + index3); // Should print 2
    }
}