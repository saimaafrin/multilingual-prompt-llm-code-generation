public class SubstringExtractor {

    /** 
     * निर्दिष्ट स्ट्रिंग से उपस्ट्रिंग प्राप्त करता है, अपवादों से बचते हुए। 
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null; // यदि स्ट्रिंग null है, तो null लौटाएं
        }
        if (start < 0) {
            start = 0; // यदि start नकारात्मक है, तो उसे 0 पर सेट करें
        }
        if (end > str.length()) {
            end = str.length(); // यदि end स्ट्रिंग की लंबाई से अधिक है, तो उसे लंबाई पर सेट करें
        }
        if (start > end) {
            return ""; // यदि start end से अधिक है, तो खाली स्ट्रिंग लौटाएं
        }
        return str.substring(start, end); // उपस्ट्रिंग लौटाएं
    }

    public static void main(String[] args) {
        // परीक्षण के लिए कुछ उदाहरण
        System.out.println(sub("Hello, World!", 7, 12)); // "World"
        System.out.println(sub("Hello, World!", -1, 5)); // "Hello"
        System.out.println(sub("Hello, World!", 0, 20)); // "Hello, World!"
        System.out.println(sub(null, 0, 5)); // null
        System.out.println(sub("Hello", 3, 2)); // ""
    }
}