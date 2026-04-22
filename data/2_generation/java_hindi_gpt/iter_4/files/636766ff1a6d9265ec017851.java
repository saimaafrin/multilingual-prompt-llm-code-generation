public class ByteFinder {
    private byte[] buffer;

    public ByteFinder(byte[] buffer) {
        this.buffer = buffer;
    }

    /** 
     * निर्दिष्ट <code>position</code> से शुरू होकर <code>buffer</code> में निर्दिष्ट मान के एक बाइट की खोज करता है।
     * @param value वह मान जिसे खोजना है।
     * @param pos   खोजने के लिए प्रारंभिक स्थिति।
     * @return बाइट की स्थिति जो मिली, <code>buffer</code> की शुरुआत से गिनती करते हुए, या <code>-1</code> यदि नहीं मिली।
     */
    protected int findByte(byte value, int pos) {
        if (pos < 0 || pos >= buffer.length) {
            return -1; // Invalid position
        }
        
        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i; // Found the byte
            }
        }
        
        return -1; // Not found
    }

    public static void main(String[] args) {
        byte[] data = {1, 2, 3, 4, 5, 3};
        ByteFinder finder = new ByteFinder(data);
        int index = finder.findByte((byte) 3, 0);
        System.out.println("Index of byte: " + index); // Output: Index of byte: 2
    }
}