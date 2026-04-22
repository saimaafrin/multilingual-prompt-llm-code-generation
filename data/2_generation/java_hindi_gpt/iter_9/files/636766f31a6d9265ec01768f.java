public class ArrayCloner {
    
    /** 
     * <p>एक ऐरे को क्लोन करता है और टाइपकास्ट परिणाम लौटाता है और <code>null</code> को संभालता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  क्लोन करने के लिए ऐरे, यह <code>null</code> हो सकता है
     * @return क्लोन किया गया ऐरे, <code>null</code> यदि <code>null</code> इनपुट हो
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        
        // Print the cloned array
        if (cloned != null) {
            for (char c : cloned) {
                System.out.print(c + " ");
            }
        } else {
            System.out.println("Cloned array is null");
        }
    }
}