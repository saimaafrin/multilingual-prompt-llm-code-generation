import java.nio.ByteBuffer;

public class ByteSearch {
    private ByteBuffer buffer;
    
    public ByteSearch(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Searches for a byte of specified value in the <code>buffer</code>, starting at the specified <code>position</code>.
     * @param value The value to find.
     * @param pos   The starting position for searching.
     * @return The position of byte found, counting from beginning of the<code>buffer</code>, or <code>-1</code> if not found.
     */
    public int findByte(byte value, int pos) {
        if (pos < 0 || pos >= buffer.limit()) {
            return -1;
        }

        // Save the current position
        int originalPosition = buffer.position();
        
        try {
            // Set position to start searching from
            buffer.position(pos);
            
            // Search through remaining bytes
            while (buffer.hasRemaining()) {
                if (buffer.get() == value) {
                    return buffer.position() - 1;
                }
            }
            
            return -1;
        } finally {
            // Restore original position
            buffer.position(originalPosition);
        }
    }
}