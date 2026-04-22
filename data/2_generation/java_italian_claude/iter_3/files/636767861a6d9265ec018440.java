import java.lang.StringBuffer;

public class NameAbbreviator {
    /**
     * Abbrevia il nome.
     * @param buf buffer a cui aggiungere l'abbreviazione.
     * @param nameStart inizio del nome da abbreviare.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
            return;
        }

        // Get the first character
        char firstChar = buf.charAt(nameStart);
        
        // Find the end of the name (next space or end of buffer)
        int nameEnd = nameStart;
        while (nameEnd < buf.length() && !Character.isWhitespace(buf.charAt(nameEnd))) {
            nameEnd++;
        }
        
        // Delete everything after first character up to end of name
        if (nameEnd > nameStart + 1) {
            buf.delete(nameStart + 1, nameEnd);
            
            // Add period after abbreviated character
            buf.insert(nameStart + 1, '.');
        }
    }
}