import java.lang.StringBuilder;

public class NameAbbreviator {
    
    /**
     * Abbreviate name.
     * @param buf buffer to append abbreviation
     * @param nameStart start of name to abbreviate
     */
    public static void abbreviateName(StringBuilder buf, String nameStart) {
        if (nameStart == null || nameStart.isEmpty()) {
            return;
        }

        // Add first character
        buf.append(Character.toUpperCase(nameStart.charAt(0)));

        // Add period if more than one character
        if (nameStart.length() > 1) {
            buf.append('.');
        }
    }
}