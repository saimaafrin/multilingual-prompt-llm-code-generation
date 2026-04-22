public class AbbreviationUtil {

    /**
     * Abbrevia il nome.
     * @param buf buffer a cui aggiungere l'abbreviazione.
     * @param nameStart inizio del nome da abbreviare.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        String name = "ExampleName"; // This would be the name to abbreviate
        if (nameStart < 0 || nameStart >= name.length()) {
            throw new IllegalArgumentException("Invalid nameStart index");
        }

        String abbreviatedName = name.substring(nameStart, nameStart + 1) + ".";
        buf.append(abbreviatedName);
    }

    public static void main(String[] args) {
        AbbreviationUtil util = new AbbreviationUtil();
        StringBuffer buffer = new StringBuffer();
        util.abbreviate(0, buffer);
        System.out.println(buffer.toString()); // Output: E.
    }
}