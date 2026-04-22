/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is represented by a byte array
    byte[] newData = new byte[data.length + size];
    System.arraycopy(data, 0, newData, 0, data.length);
    data = newData;
}

// Assuming the byte vector is stored in a byte array named 'data'
private byte[] data;