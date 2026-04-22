import java.util.Arrays;

public class ArrayComparator {

    /**
     * यदि आंतरिक ऐरे की सामग्री और प्रदान किए गए ऐरे में मेल खाते हैं, तो सत्य लौटाता है।
     * 
     * @param data प्रदान किया गया ऐरे
     * @param offset ऐरे में शुरुआती स्थिति
     * @param len तुलना करने के लिए लंबाई
     * @return सत्य यदि ऐरे की सामग्री मेल खाती है, अन्यथा असत्य
     */
    public boolean equals(final byte[] internalArray, final byte[] data, int offset, final int len) {
        if (internalArray == null || data == null || offset < 0 || len < 0 || offset + len > data.length || len > internalArray.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }
}