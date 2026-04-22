public class NameAbbreviator {

    /** 
     * Abbreviate name.
     * @param buf buffer to append abbreviation.
     * @param nameStart start of name to abbreviate.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        String name = "John Doe"; // Example name, replace with actual name source
        if (nameStart < 0 || nameStart >= name.length()) {
            throw new IllegalArgumentException("Invalid nameStart index");
        }

        String[] parts = name.split(" ");
        for (int i = nameStart; i < parts.length; i++) {
            if (i == nameStart) {
                buf.append(parts[i].charAt(0)).append(". ");
            } else {
                buf.append(parts[i]).append(" ");
            }
        }
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        NameAbbreviator abbreviator = new NameAbbreviator();
        abbreviator.abbreviate(0, buffer);
        System.out.println(buffer.toString().trim()); // Output: J. Doe
    }
}