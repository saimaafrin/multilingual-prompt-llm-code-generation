public class HeaderParser {

    /** 
     * वर्तमान पंक्ति के अंत तक बाइट्स को छोड़ता है।
     * @param headerPart हेडर, जिन्हें पार्स किया जा रहा है।
     * @param end अंतिम बाइट का अनुक्रमांक, जिसे अभी तक प्रोसेस नहीं किया गया है।
     * @return \r\n अनुक्रमांक, जो पंक्ति के अंत को दर्शाता है।
     */
    private int parseEndOfLine(String headerPart, int end) {
        int length = headerPart.length();
        for (int i = end; i < length; i++) {
            if (headerPart.charAt(i) == '\r') {
                if (i + 1 < length && headerPart.charAt(i + 1) == '\n') {
                    return i + 2; // Return the index after \r\n
                }
            }
        }
        return length; // If no end of line is found, return the length of the string
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String header = "Header line 1\r\nHeader line 2";
        int endIndex = parser.parseEndOfLine(header, 0);
        System.out.println("End of line index: " + endIndex);
    }
}