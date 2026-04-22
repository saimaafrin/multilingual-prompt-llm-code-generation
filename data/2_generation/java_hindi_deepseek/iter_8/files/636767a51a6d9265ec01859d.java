import java.util.Arrays;

public class ArrayComparator {

    /**
     * यदि आंतरिक ऐरे की सामग्री और प्रदान किए गए ऐरे में मेल खाते हैं, तो सत्य लौटाता है।
     *
     * @param data   प्रदान किया गया ऐरे
     * @param offset ऐरे में शुरुआती स्थान
     * @param len    तुलना करने के लिए लंबाई
     * @return सत्य यदि मेल खाते हैं, अन्यथा असत्य
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        // आंतरिक ऐरे (इस उदाहरण में, हम एक डमी ऐरे का उपयोग कर रहे हैं)
        byte[] internalArray = {1, 2, 3, 4, 5};

        // यदि ऑफसेट या लंबाई अमान्य है, तो असत्य लौटाएं
        if (offset < 0 || len < 0 || offset + len > data.length || len > internalArray.length) {
            return false;
        }

        // आंतरिक ऐरे और प्रदान किए गए ऐरे के हिस्से की तुलना करें
        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayComparator comparator = new ArrayComparator();
        byte[] data = {1, 2, 3, 4, 5};
        boolean result = comparator.equals(data, 0, 5);
        System.out.println(result); // Output: true
    }
}