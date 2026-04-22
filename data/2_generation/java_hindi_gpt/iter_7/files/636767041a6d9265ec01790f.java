public class ArrayConverter {
    
    /** 
     * <p>प्राथमिक int के एक ऐरे को ऑब्जेक्ट्स में परिवर्तित करता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>int</code> ऐरे
     * @return एक <code>Integer</code> ऐरे, <code>null</code> यदि null ऐरे इनपुट है
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.valueOf(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5};
        Integer[] objectArray = toObject(primitiveArray);
        
        // Print the result
        for (Integer num : objectArray) {
            System.out.print(num + " ");
        }
    }
}