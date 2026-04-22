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

        // Find next capital letter if it exists
        for (int i = 1; i < nameStart.length(); i++) {
            char c = nameStart.charAt(i);
            if (Character.isUpperCase(c)) {
                buf.append(c);
                break;
            }
        }
    }
}