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

        int length = buf.length();
        boolean lastWasWhitespace = true;
        
        for (int i = nameStart; i < length; i++) {
            char currentChar = buf.charAt(i);
            
            if (Character.isWhitespace(currentChar)) {
                lastWasWhitespace = true;
            } else {
                if (lastWasWhitespace) {
                    // Keep first letter after whitespace
                    if (i != nameStart) {
                        buf.setCharAt(i, Character.toUpperCase(currentChar));
                    }
                    lastWasWhitespace = false;
                } else {
                    // Delete non-first letters
                    buf.deleteCharAt(i);
                    i--;
                    length--;
                }
            }
        }
    }
}