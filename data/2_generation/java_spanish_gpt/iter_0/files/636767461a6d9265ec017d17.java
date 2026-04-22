public class DotIdentifierUnescaper {

    /** 
     * Remueve el "escape" de un identificador de cadena DOT.
     * @param input la entrada
     * @return la salida sin carácteres "escape"
     */
    private String unescapeId(String input) {
        if (input == null) {
            return null;
        }
        // Reemplaza las secuencias de escape
        return input.replaceAll("\\\\\"", "\"")
                    .replaceAll("\\\\\\\\", "\\\\")
                    .replaceAll("\\\\n", "\n")
                    .replaceAll("\\\\r", "\r")
                    .replaceAll("\\\\t", "\t");
    }

    public static void main(String[] args) {
        DotIdentifierUnescaper unescaper = new DotIdentifierUnescaper();
        String escapedId = "This is a test string with an escaped quote: \\\" and a backslash: \\\\";
        String unescapedId = unescaper.unescapeId(escapedId);
        System.out.println(unescapedId);
    }
}