public class AbbreviationUtil {

    /** 
     * नाम को संक्षिप्त करें।
     * @param buf संक्षिप्त नाम जोड़ने के लिए बफर।
     * @param nameStart संक्षिप्त करने के लिए नाम की शुरुआत।
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        // Example name for abbreviation
        String name = "Johnathan Doe";
        
        // Check if nameStart is within bounds
        if (nameStart < 0 || nameStart >= name.length()) {
            throw new IllegalArgumentException("nameStart is out of bounds");
        }

        // Append the first character of the name
        buf.append(name.charAt(nameStart));

        // Append a dot for abbreviation
        buf.append('.');

        // If there are more characters in the name, append the last character
        if (nameStart < name.length() - 1) {
            buf.append(name.charAt(name.length() - 1));
        }
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer();
        util.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: J.D
    }
}