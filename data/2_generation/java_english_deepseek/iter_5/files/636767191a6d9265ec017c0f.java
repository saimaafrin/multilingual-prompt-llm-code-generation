/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is stored in a byte array called 'data'
    int currentCapacity = data.length;
    int newCapacity = currentCapacity + size;

    // Create a new array with the increased capacity
    byte[] newData = new byte[newCapacity];

    // Copy the existing data to the new array
    System.arraycopy(data, 0, newData, 0, currentCapacity);

    // Update the reference to the new array
    data = newData;
}