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
                buf.append(". "); // Add a period and space for subsequent names
            }
            String part = nameParts[i];
            if (part.length() > 0) {
                buf.append(part.charAt(0)).append("."); // Append the first letter and a period
            }
        }
    }

    public static void main(String[] args) {
        NameAbbreviator abbreviator = new NameAbbreviator();
        StringBuffer buffer = new StringBuffer();
        abbreviator.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: J. D.
    }
}