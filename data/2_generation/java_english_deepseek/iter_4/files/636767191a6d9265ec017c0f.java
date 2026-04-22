/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is stored in a byte array called 'data'
    int currentCapacity = data.length;
    int requiredCapacity = currentCapacity + size;

    // If the current capacity is sufficient, no need to enlarge
    if (requiredCapacity <= currentCapacity) {
        return;
    }

    // Calculate the new capacity, typically doubling the size or adding the required size
    int newCapacity = Math.max(currentCapacity * 2, requiredCapacity);

    // Create a new array with the new capacity
    byte[] newData = new byte[newCapacity];

    // Copy the existing data to the new array
    System.arraycopy(data, 0, newData, 0, currentCapacity);

    // Replace the old array with the new one
    data = newData;
}