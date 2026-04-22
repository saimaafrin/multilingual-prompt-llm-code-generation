public class StringSplitter {
    
    /** 
     * एक स्ट्रिंग को डिलीमीटर की पहली उपस्थिति पर विभाजित करें। परिणाम में डिलीमीटर शामिल नहीं है।
     * @param toSplit वह स्ट्रिंग जिसे विभाजित करना है
     * @param delimiter वह डिलीमीटर जिससे स्ट्रिंग को विभाजित किया जाएगा
     * @return एक दो तत्वों वाला एरे जिसमें इंडेक्स 0 डिलीमीटर से पहले का हिस्सा है, और इंडेक्स 1 डिलीमीटर के बाद का हिस्सा है (कोई भी तत्व डिलीमीटर को शामिल नहीं करता); या <code>null</code> यदि दिए गए इनपुट स्ट्रिंग में डिलीमीटर नहीं मिला
     */
    public static String[] split(String toSplit, String delimiter) {
        if (toSplit == null || delimiter == null) {
            return null;
        }
        
        int index = toSplit.indexOf(delimiter);
        if (index == -1) {
            return null;
        }
        
        String beforeDelimiter = toSplit.substring(0, index);
        String afterDelimiter = toSplit.substring(index + delimiter.length());
        
        return new String[] { beforeDelimiter, afterDelimiter };
    }

    public static void main(String[] args) {
        String[] result = split("Hello,World", ",");
        if (result != null) {
            System.out.println("Before delimiter: " + result[0]);
            System.out.println("After delimiter: " + result[1]);
        } else {
            System.out.println("Delimiter not found.");
        }
    }
}