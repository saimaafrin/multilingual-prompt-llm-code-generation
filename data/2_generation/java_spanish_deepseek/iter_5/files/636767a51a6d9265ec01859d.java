public boolean equals(final byte[] data, int offset, final int len) {
    if (data == null || this.internalArray == null) {
        return false;
    }
    if (offset < 0 || len < 0 || offset + len > data.length || len > this.internalArray.length) {
        return false;
    }
    for (int i = 0; i < len; i++) {
        if (this.internalArray[i] != data[offset + i]) {
            return false;
        }
    }
    return true;
}