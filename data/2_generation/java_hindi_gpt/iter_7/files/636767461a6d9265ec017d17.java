public class StringUnescaper {

    /** 
     * एक स्ट्रिंग DOT पहचानकर्ता को अनएस्केप करें।
     * @param input इनपुट
     * @return अनएस्केप किया गया आउटपुट
     */
    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        boolean isEscaped = false;

        for (char c : input.toCharArray()) {
            if (isEscaped) {
                output.append(c);
                isEscaped = false;
            } else if (c == '\\') {
                isEscaped = true;
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        StringUnescaper unescaper = new StringUnescaper();
        String input = "Hello\\ World\\!";
        String output = unescaper.unescapeId(input);
        System.out.println(output); // Output: Hello World!
    }
}