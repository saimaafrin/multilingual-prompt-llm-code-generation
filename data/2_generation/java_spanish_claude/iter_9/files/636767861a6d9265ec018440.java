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

        // Find first letter and capitalize it
        char firstChar = Character.toUpperCase(buf.charAt(nameStart));
        
        // Replace rest of name with a period
        buf.setLength(nameStart + 2);
        buf.setCharAt(nameStart, firstChar);
        buf.setCharAt(nameStart + 1, '.');
    }
}