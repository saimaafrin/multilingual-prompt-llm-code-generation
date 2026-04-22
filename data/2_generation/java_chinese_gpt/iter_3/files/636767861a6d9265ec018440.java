public class AbbreviationUtil {

    /** 
     * 缩写名称。
     * @param buf 用于追加缩写的缓冲区。
     * @param nameStart 要缩写的名称起始位置。
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        // Example name to abbreviate
        String name = "Internationalization";
        
        // Check if the nameStart is within the bounds of the name length
        if (nameStart < 0 || nameStart >= name.length()) {
            throw new IllegalArgumentException("nameStart is out of bounds");
        }

        // Append the first character of the name from the nameStart position
        buf.append(name.charAt(nameStart));

        // Append the last character of the name
        buf.append(name.charAt(name.length() - 1));
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer();
        util.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: "an"
    }
}