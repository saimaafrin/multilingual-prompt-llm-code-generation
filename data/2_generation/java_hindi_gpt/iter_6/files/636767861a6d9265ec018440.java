public class AbbreviationUtil {

    /** 
     * नाम को संक्षिप्त करें।
     * @param buf संक्षिप्त नाम जोड़ने के लिए बफर।
     * @param nameStart संक्षिप्त करने के लिए नाम की शुरुआत।
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (nameStart < 0 || buf == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        String name = buf.toString();
        if (nameStart >= name.length()) {
            return; // Nothing to abbreviate
        }

        StringBuilder abbreviatedName = new StringBuilder();
        for (int i = nameStart; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (i == nameStart || name.charAt(i - 1) == ' ') {
                abbreviatedName.append(currentChar).append(". ");
            }
        }

        // Remove the last added space and dot if exists
        if (abbreviatedName.length() > 0) {
            abbreviatedName.setLength(abbreviatedName.length() - 1); // Remove last space
            abbreviatedName.setLength(abbreviatedName.length() - 1); // Remove last dot
        }

        buf.setLength(0); // Clear the buffer
        buf.append(abbreviatedName.toString()); // Append the abbreviated name
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer("John Doe Smith");
        util.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: J. D. S.
    }
}