public class StringSearch {
    
    /** 
     * एक स्ट्रिंग के भीतर अंतिम अनुक्रमांक खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#lastIndexOf(String)} का उपयोग करती है। 
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // उदाहरण के लिए परीक्षण
        String str = "Hello, world! Hello again!";
        String searchStr = "Hello";
        int index = lastIndexOf(str, searchStr);
        System.out.println("The last index of '" + searchStr + "' is: " + index);
    }
}