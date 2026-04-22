public class CharUtils {

    private static final Character[] CHAR_CACHE = new Character[128];

    static {
        for (int i = 0; i < CHAR_CACHE.length; i++) {
            CHAR_CACHE[i] = (char) i;
        }
    }

    /**
     * <p>Convierte el carácter a un objeto "Character".</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo objeto "Character" cada vez.</p>
     * <pre>
     * CharUtils.toCharacterObject(' ')  = ' '
     * CharUtils.toCharacterObject('A')  = 'A'
     * </pre>
     * @param ch  el carácter a convertir
     * @return un objeto "Character" del carácter especificado
     */
    public static Character toCharacterObject(final char ch) {
        if (ch < CHAR_CACHE.length) {
            return CHAR_CACHE[ch];
        }
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
    }
}