public boolean equals(final byte[] data, int offset, final int len) {
    if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
        return false;
    }
    
    if (this.internalArray == null || this.internalArray.length < len) {
        return false;
    }
    
    for (int i = 0; i < len; i++) {
        if (this.internalArray[i] != data[offset + i]) {
            return false;
        }
    }
    
    return true;
}