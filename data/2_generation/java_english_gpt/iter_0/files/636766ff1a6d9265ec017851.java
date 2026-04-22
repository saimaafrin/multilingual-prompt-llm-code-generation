public class ByteSearcher {
    
    private byte[] buffer;

    public ByteSearcher(byte[] buffer) {
        this.buffer = buffer;
    }

    /** 
     * Searches for a byte of specified value in the <code>buffer</code>, starting at the specified <code>position</code>.
     * @param value The value to find.
     * @param pos   The starting position for searching.
     * @return The position of byte found, counting from beginning of the<code>buffer</code>, or <code>-1</code> if not found.
     */
    protected int findByte(byte value, int pos) {
        if (pos < 0 || pos >= buffer.length) {
            return -1; // Invalid starting position
        }
        
        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i; // Return the position of the found byte
            }
        }
        
        return -1; // Byte not found
    }

    public static void main(String[] args) {
        byte[] data = {1, 2, 3, 4, 5, 2};
        ByteSearcher searcher = new ByteSearcher(data);
        int position = searcher.findByte((byte) 2, 0);
        System.out.println("Position of byte: " + position); // Output: Position of byte: 1
    }
}