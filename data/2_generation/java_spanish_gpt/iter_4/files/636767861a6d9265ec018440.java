public class NameAbbreviator {

    /** 
     * Abreviar nombre.
     * @param buf buffer para agregar la abreviatura.
     * @param nameStart inicio del nombre a abreviar.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        String name = "John Doe"; // Example name, replace with actual name source
        if (nameStart < 0 || nameStart >= name.length()) {
            throw new IllegalArgumentException("Invalid nameStart index");
        }

        String[] nameParts = name.split(" ");
        for (int i = nameStart; i < nameParts.length; i++) {
            if (i > nameStart) {
                buf.append(". "); // Add a period and space between initials
            }
            buf.append(nameParts[i].charAt(0)); // Append the first character of each part
        }
    }

    public static void main(String[] args) {
        NameAbbreviator abbreviator = new NameAbbreviator();
        StringBuffer buffer = new StringBuffer();
        abbreviator.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: J. D.
    }
}