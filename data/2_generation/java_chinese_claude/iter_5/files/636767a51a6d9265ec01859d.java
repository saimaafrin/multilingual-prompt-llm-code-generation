import java.util.Arrays;

public class ByteArrayMatcher {
    private byte[] internalArray;
    
    /**
     * 如果内部数组的内容与提供的数组匹配，则返回真。
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        
        if (internalArray == null || internalArray.length != len) {
            return false;
        }
        
        for (int i = 0; i < len; i++) {
            if (data[offset + i] != internalArray[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // Constructor to set internal array
    public ByteArrayMatcher(byte[] array) {
        this.internalArray = array;
    }
}