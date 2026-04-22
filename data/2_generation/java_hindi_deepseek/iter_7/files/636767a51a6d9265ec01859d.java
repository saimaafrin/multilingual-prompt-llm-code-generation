import java.util.Arrays;

public class ArrayComparator {

    /**
     * यदि आंतरिक ऐरे की सामग्री और प्रदान किए गए ऐरे में मेल खाते हैं, तो सत्य लौटाता है।
     * 
     * @param data प्रदान किया गया ऐरे
     * @param offset प्रदान किए गए ऐरे में शुरुआती इंडेक्स
     * @param len तुलना करने के लिए लंबाई
     * @return सत्य यदि आंतरिक ऐरे और प्रदान किए गए ऐरे की सामग्री मेल खाती है, अन्यथा असत्य
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        // आंतरिक ऐरे (इस उदाहरण में, हम एक डमी ऐरे का उपयोग कर रहे हैं)
        byte[] internalArray = {1, 2, 3, 4, 5};

        // यदि प्रदान किया गया ऐरे null है या लंबाई अमान्य है, तो असत्य लौटाएं
        if (data == null || offset < 0 || len < 0 || offset + len > data.length || len > internalArray.length) {
            return false;
        }

        // आंतरिक ऐरे और प्रदान किए गए ऐरे की सामग्री की तुलना करें
        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayComparator comparator = new ArrayComparator();
        byte[] testArray = {1, 2, 3, 4, 5};
        System.out.println(comparator.equals(testArray, 0, 5)); // true
        System.out.println(comparator.equals(testArray, 1, 4)); // false
    }
}