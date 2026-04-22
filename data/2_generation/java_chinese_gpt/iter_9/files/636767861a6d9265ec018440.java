public class AbbreviationUtil {

    /** 
     * 缩写名称。
     * @param buf 用于追加缩写的缓冲区。
     * @param nameStart 要缩写的名称起始位置。
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (nameStart < 0 || buf == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        String name = buf.toString();
        if (nameStart >= name.length()) {
            return; // No abbreviation possible
        }

        StringBuilder abbreviation = new StringBuilder();
        abbreviation.append(name.charAt(nameStart)); // Add the first character of the name

        for (int i = nameStart + 1; i < name.length(); i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                abbreviation.append(name.charAt(i)); // Add uppercase letters
            }
        }

        buf.setLength(0); // Clear the buffer
        buf.append(abbreviation); // Append the abbreviation
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer("Internationalization");
        util.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: "I"
    }
}