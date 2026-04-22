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
        String[] parts = name.substring(nameStart).split(" ");
        for (String part : parts) {
            if (!part.isEmpty()) {
                abbreviatedName.append(part.charAt(0)).append("."); // Add the first character of each part
            }
        }

        // Remove the last dot if exists
        if (abbreviatedName.length() > 0 && abbreviatedName.charAt(abbreviatedName.length() - 1) == '.') {
            abbreviatedName.setLength(abbreviatedName.length() - 1);
        }

        buf.setLength(0); // Clear the buffer
        buf.append(abbreviatedName); // Set the abbreviated name
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer("John Doe Smith");
        util.abbreviate(5, buffer);
        System.out.println(buffer); // Output: John D.S
    }
}