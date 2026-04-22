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
        abbreviatedName.append(name.substring(0, nameStart)); // Add the part before the abbreviation

        // Abbreviate the name
        for (int i = nameStart; i < name.length(); i++) {
            if (i == nameStart || name.charAt(i - 1) == ' ') {
                abbreviatedName.append(name.charAt(i)).append("."); // Add the first letter of each word followed by a dot
            }
        }

        // Remove the last dot if it exists
        if (abbreviatedName.length() > 0 && abbreviatedName.charAt(abbreviatedName.length() - 1) == '.') {
            abbreviatedName.setLength(abbreviatedName.length() - 1);
        }

        buf.setLength(0); // Clear the buffer
        buf.append(abbreviatedName); // Add the abbreviated name to the buffer
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer("John Doe Smith");
        util.abbreviate(5, buffer);
        System.out.println(buffer.toString()); // Output: John D.S
    }
}