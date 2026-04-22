import java.util.Arrays;

public class ByteArrayMatcher {
    
    private byte[] internalArray;
    
    public ByteArrayMatcher(byte[] array) {
        this.internalArray = array;
    }
    
    /**
     * Returns true if the contents of the internal array and the provided array match.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        
        if (len != internalArray.length) {
            return false;
        }
        
        for (int i = 0; i < len; i++) {
            if (data[offset + i] != internalArray[i]) {
                return false;
            }
        }
        
        return true;
    }
}