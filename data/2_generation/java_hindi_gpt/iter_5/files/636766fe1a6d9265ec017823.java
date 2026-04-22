import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> constantNameAndTypeMap;
    private int nextIndex;

    public ConstantPool() {
        this.constantNameAndTypeMap = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * इस प्रतीक तालिका के स्थायी पूल में एक CONSTANT_NameAndType_info जोड़ता है। यदि स्थायी पूल में पहले से ही समान आइटम मौजूद है, तो कुछ नहीं करता है।
     * @param name एक फ़ील्ड या विधि का नाम।
     * @param descriptor एक फ़ील्ड या विधि का विवरण।
     * @return दिए गए मान के साथ एक नया या पहले से मौजूद प्रतीक।
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!constantNameAndTypeMap.containsKey(key)) {
            constantNameAndTypeMap.put(key, nextIndex);
            return nextIndex++;
        }
        return constantNameAndTypeMap.get(key);
    }

    public static void main(String[] args) {
        ConstantPool pool = new ConstantPool();
        int index1 = pool.addConstantNameAndType("myField", "I");
        int index2 = pool.addConstantNameAndType("myField", "I");
        System.out.println("Index of first addition: " + index1);
        System.out.println("Index of second addition (should be same): " + index2);
    }
}