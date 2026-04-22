import java.util.Arrays;

public class ByteArrayComparator {
    
    private byte[] internalArray;
    
    /**
     * Constructor to initialize internal array
     */
    public ByteArrayComparator(byte[] array) {
        this.internalArray = array;
    }
    
    /**
     * Restituisce true se i contenuti dell'array interno e dell'array fornito corrispondono.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        
        if (internalArray.length != len) {
            return false;
        }
        
        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }
        
        return true;
    }
}