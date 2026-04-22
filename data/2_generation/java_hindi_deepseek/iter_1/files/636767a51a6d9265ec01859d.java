/**
 * यदि आंतरिक ऐरे की सामग्री और प्रदान किए गए ऐरे में मेल खाते हैं, तो सत्य लौटाता है।
 */
public boolean equals(final byte[] data, int offset, final int len) {
    if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
        return false;
    }

    // Assuming `internalArray` is the internal array to compare with
    if (internalArray == null || internalArray.length != len) {
        return false;
    }

    for (int i = 0; i < len; i++) {
        if (internalArray[i] != data[offset + i]) {
            return false;
        }
    }

    return true;
}

// Assuming `internalArray` is a class-level variable
private byte[] internalArray;

// Constructor or method to set the internal array
public void setInternalArray(byte[] array) {
    this.internalArray = array;
}