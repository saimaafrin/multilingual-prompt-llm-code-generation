/**
 * निर्दिष्ट <code>position</code> से शुरू होकर <code>buffer</code> में निर्दिष्ट मान के एक बाइट की खोज करता है।
 * @param value वह मान जिसे खोजना है।
 * @param pos   खोजने के लिए प्रारंभिक स्थिति।
 * @return बाइट की स्थिति जो मिली, <code>buffer</code> की शुरुआत से गिनती करते हुए, या <code>-1</code> यदि नहीं मिली।
 */
protected int findByte(byte value, int pos) {
    if (pos < 0 || pos >= buffer.length) {
        throw new IndexOutOfBoundsException("Position is out of bounds");
    }
    
    for (int i = pos; i < buffer.length; i++) {
        if (buffer[i] == value) {
            return i;
        }
    }
    
    return -1;
}