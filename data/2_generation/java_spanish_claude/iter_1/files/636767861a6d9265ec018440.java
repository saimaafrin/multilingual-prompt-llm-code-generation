import java.lang.StringBuffer;

public class NameAbbreviator {
    
    /**
     * Abreviar nombre.
     * @param buf buffer para agregar la abreviatura.
     * @param nameStart inicio del nombre a abreviar.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
            return;
        }

        // Find first letter
        char firstLetter = buf.charAt(nameStart);
        
        // Convert to uppercase and add period
        buf.setCharAt(nameStart, Character.toUpperCase(firstLetter));
        buf.insert(nameStart + 1, '.');
        
        // Delete rest of name if it exists
        int nextSpace = buf.indexOf(" ", nameStart);
        if (nextSpace != -1) {
            buf.delete(nameStart + 2, nextSpace);
        } else {
            buf.delete(nameStart + 2, buf.length());
        }
    }
}