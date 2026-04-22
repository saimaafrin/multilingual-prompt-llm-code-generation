public class ArrayConverter {
    
    /** 
     * <p>प्राथमिक डबल्स के एक एरे को ऑब्जेक्ट्स में परिवर्तित करता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>double</code> एरे
     * @return एक <code>Double</code> एरे, <code>null</code> यदि इनपुट एरे null है
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        
        Double[] objectArray = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i]; // Autoboxing from double to Double
        }
        return objectArray;
    }

    public static void main(String[] args) {
        double[] primitiveArray = {1.1, 2.2, 3.3};
        Double[] objectArray = toObject(primitiveArray);
        
        // Print the object array
        for (Double d : objectArray) {
            System.out.println(d);
        }
    }
}