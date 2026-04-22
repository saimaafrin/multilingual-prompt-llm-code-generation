/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is represented by a byte array named 'data'
    // and 'length' is the current length of the byte vector.
    
    // Calculate the new length required
    int newLength = length + size;
    
    // If the current array is not large enough, create a new one
    if (newLength > data.length) {
        // Double the size of the array until it can accommodate the new length
        int newCapacity = data.length * 2;
        while (newCapacity < newLength) {
            newCapacity *= 2;
        }
        
        // Create a new array with the calculated capacity
        byte[] newData = new byte[newCapacity];
        
        // Copy the existing data to the new array
        System.arraycopy(data, 0, newData, 0, length);
        
        // Update the reference to the new array
        data = newData;
    }
}