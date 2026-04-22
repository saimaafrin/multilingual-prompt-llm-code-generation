public class StringSearch {
    /** 
     * एक स्ट्रिंग के भीतर पहला इंडेक्स खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#indexOf(String)} का उपयोग करती है। 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1; // Return -1 if either string is null
        }
        return str.indexOf(searchStr); // Use String's indexOf method
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello, world!";
        String searchStr = "world";
        int index = indexOf(str, searchStr);
        System.out.println("Index of '" + searchStr + "' in '" + str + "': " + index);
    }
}