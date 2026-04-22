/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is represented by a byte array named 'data'
    // and 'length' is the current length of the byte vector.
    
    // Calculate the new capacity needed
    int newCapacity = length + size;
    
    // If the current capacity is sufficient, do nothing
    if (newCapacity <= data.length) {
        return;
    }
    
    // Calculate the new capacity, doubling the current capacity if necessary
    int currentCapacity = data.length;
    while (currentCapacity < newCapacity) {
        currentCapacity *= 2;
    }
    
    // Create a new array with the new capacity
    byte[] newData = new byte[currentCapacity];
    
    // Copy the existing data to the new array
    System.arraycopy(data, 0, newData, 0, length);
    
    // Update the reference to the new array
    data = newData;
}