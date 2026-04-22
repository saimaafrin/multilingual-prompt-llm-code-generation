public class CharUtils {
    
    private static final Character[] cache = new Character[128];

    static {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = (char) i;
        }
    }

    /**
     * <p>Converts the character to a Character.</p> <p>For ASCII 7 bit characters, this uses a cache that will return the same Character object each time.</p> <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  the character to convert
     * @return a Character of the specified character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch >= 0 && ch < 128) {
            return cache[ch];
        }
        return Character.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
        System.out.println(toCharacterObject('Z')); // Output: 'Z'
        System.out.println(toCharacterObject((char) 128)); // Output: (Character for ASCII 128)
    }
}