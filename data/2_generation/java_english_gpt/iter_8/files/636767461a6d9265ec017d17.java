public class StringUnescaper {

    /** 
     * Unescape a string DOT identifier.
     * @param input the input
     * @return the unescaped output
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
        String input = "some\\ identifier\\ with\\ escapes";
        String output = unescaper.unescapeId(input);
        System.out.println(output); // Output: some identifier with escapes
    }
}