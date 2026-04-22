/**
 * वर्तमान पंक्ति के अंत तक बाइट्स को छोड़ता है।
 * @param headerPart हेडर, जिन्हें पार्स किया जा रहा है।
 * @param end अंतिम बाइट का अनुक्रमांक, जिसे अभी तक प्रोसेस नहीं किया गया है।
 * @return \r\n अनुक्रमांक, जो पंक्ति के अंत को दर्शाता है।
 */
private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char c = headerPart.charAt(index);
        if (c == '\r' || c == '\n') {
            if (c == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
                return index + 2; // \r\n sequence found
            }
            return index + 1; // \r or \n found
        }
        index++;
    }
    return -1; // No end of line found
}