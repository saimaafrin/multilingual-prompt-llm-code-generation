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

        // Find first vowel after first char
        int length = nameStart.length();
        for (int i = 1; i < length; i++) {
            char c = Character.toLowerCase(nameStart.charAt(i));
            if (isVowel(c)) {
                // Add consonants up to and including first vowel
                buf.append(c);
                break;
            } else {
                buf.append(c);
            }
        }
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }
}