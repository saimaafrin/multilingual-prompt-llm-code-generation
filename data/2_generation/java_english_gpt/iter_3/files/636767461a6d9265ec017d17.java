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
        boolean escaping = false;

        for (char c : input.toCharArray()) {
            if (escaping) {
                output.append(c);
                escaping = false;
            } else {
                if (c == '\\') {
                    escaping = true;
                } else {
                    output.append(c);
                }
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