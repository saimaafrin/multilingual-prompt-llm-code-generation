public class StringArrayCopy {
    
    /** 
     * यह विधि प्रदान किए गए ऐरे की एक प्रति बनाती है, और सुनिश्चित करती है कि नए बनाए गए ऐरे में सभी स्ट्रिंग केवल छोटे अक्षरों में हों। 
     * <p> इस विधि का उपयोग स्ट्रिंग ऐरे की नकल करने के लिए करने का मतलब है कि src ऐरे में किए गए परिवर्तन dst ऐरे को संशोधित नहीं करते हैं।
     */
    private static String[] copyStrings(final String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? src[i].toLowerCase() : null;
        }
        return dst;
    }

    public static void main(String[] args) {
        String[] original = {"Hello", "World", "JAVA", null, "Programming"};
        String[] copied = copyStrings(original);
        
        // Print the copied array
        for (String str : copied) {
            System.out.println(str);
        }
    }
}