import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> typeTable = new HashMap<>();
    private int nextIndex = 0;

    /**
     * इस प्रतीक तालिका के प्रकार तालिका में एक प्रकार जोड़ता है। यदि प्रकार तालिका में पहले से ही एक समान प्रकार मौजूद है, तो कुछ नहीं करता है।
     * @param value एक आंतरिक वर्ग का नाम।
     * @return दिए गए मान के साथ एक नए या पहले से मौजूद प्रकार प्रतीक का अनुक्रमांक।
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