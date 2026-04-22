/**
 * 如果内部数组的内容与提供的数组匹配，则返回真。
 */
public boolean equals(final byte[] data, int offset, final int len) {
    if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
        return false;
    }
    
    // Assuming 'internalArray' is the internal array to compare against
    if (len != internalArray.length) {
        return false;
    }
    
    for (int i = 0; i < len; i++) {
        if (data[offset + i] != internalArray[i]) {
            return false;
        }
    }
    
    return true;
}

// Assuming 'internalArray' is defined somewhere in the class
private byte[] internalArray;