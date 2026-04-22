/**
 * Enlarges this byte vector so that it can receive 'size' more bytes.
 * @param size number of additional bytes that this byte vector should be able to receive.
 */
private void enlarge(final int size) {
    // Assuming the byte vector is represented by a byte array named 'data'
    // and its current length is stored in a variable named 'length'.
    
    // Calculate the new capacity needed
    int newCapacity = length + size;
    
    // If the current data array is null or too small, create a new array
    if (data == null || data.length < newCapacity) {
        // Create a new array with the required capacity
        byte[] newData = new byte[newCapacity];
        
        // Copy the existing data to the new array
        if (data != null) {
            System.arraycopy(data, 0, newData, 0, length);
        }
        
        // Update the reference to the new array
        data = newData;
    }
}