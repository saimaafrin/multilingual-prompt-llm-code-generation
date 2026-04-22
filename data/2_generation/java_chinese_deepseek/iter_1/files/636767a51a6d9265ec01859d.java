public boolean equals(final byte[] data, int offset, final int len) {
    if (data == null || offset < 0 || len < 0 || offset + len > this.data.length || offset + len > data.length) {
        return false;
    }
    for (int i = 0; i < len; i++) {
        if (this.data[offset + i] != data[offset + i]) {
            return false;
        }
    }
    return true;
}