public class StringSearch {
    
    /** 
     * एक स्ट्रिंग के भीतर पहला इंडेक्स खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#indexOf(String)} का उपयोग करती है। 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1; // यदि कोई भी स्ट्रिंग null है, तो -1 लौटाएं
        }
        return str.indexOf(searchStr); // स्ट्रिंग के भीतर खोजें और इंडेक्स लौटाएं
    }

    public static void main(String[] args) {
        // परीक्षण के लिए कुछ उदाहरण
        System.out.println(indexOf("Hello, world!", "world")); // 7
        System.out.println(indexOf("Hello, world!", "Java"));  // -1
        System.out.println(indexOf(null, "test"));              // -1
        System.out.println(indexOf("test", null));              // -1
    }
}