import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> nameAndTypeMap = new HashMap<>();
    private int nextIndex = 1;

    /**
     * इस प्रतीक तालिका के स्थायी पूल में एक CONSTANT_NameAndType_info जोड़ता है। यदि स्थायी पूल में पहले से ही समान आइटम मौजूद है, तो कुछ नहीं करता है।
     * @param name एक फ़ील्ड या विधि का नाम।
     * @param descriptor एक फ़ील्ड या विधि का विवरण।
     * @return दिए गए मान के साथ एक नया या पहले से मौजूद प्रतीक।
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (nameAndTypeMap.containsKey(key)) {
            return nameAndTypeMap.get(key);
        } else {
            int index = nextIndex++;
            nameAndTypeMap.put(key, index);
            return index;
        }
    }
}