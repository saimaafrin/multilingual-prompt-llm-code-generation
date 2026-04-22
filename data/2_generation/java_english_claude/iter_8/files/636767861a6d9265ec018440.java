import java.lang.StringBuffer;

public class NameAbbreviator {
    
    /**
     * Abbreviate name.
     * @param buf buffer to append abbreviation.
     * @param nameStart start of name to abbreviate.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
            return;
        }

        // Find first letter after nameStart
        int pos = nameStart;
        while (pos < buf.length() && !Character.isLetter(buf.charAt(pos))) {
            pos++;
        }

        if (pos < buf.length()) {
            // Keep first letter
            char firstLetter = buf.charAt(pos);
            
            // Delete rest of name and add period
            buf.delete(pos + 1, buf.length());
            buf.append('.');
        }
    }
}