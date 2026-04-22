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

        String[] parts = name.split(" ");
        for (int i = nameStart; i < parts.length; i++) {
            if (i > nameStart) {
                buf.append(" "); // Add space between names
            }
            buf.append(parts[i].charAt(0)).append("."); // Append first letter and dot
        }
    }

    public static void main(String[] args) {
        NameAbbreviator abbreviator = new NameAbbreviator();
        StringBuffer buffer = new StringBuffer();
        abbreviator.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: J. D.
    }
}