public class CharUtils {
    /**
     * <p>Convierte el carácter a un objeto "Character".</p> 
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo objeto "Character" cada vez.</p> 
     * <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  el carácter a convertir
     * @return un objeto "Character" del carácter especificado
     */
    public static Character toCharacterObject(final char ch) {
        if (ch >= 0 && ch <= 127) {
            return CharacterCache.cache[ch];
        }
        return new Character(ch);
    }

    private static class CharacterCache {
        private static final Character[] cache = new Character[128];

        static {
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new Character((char) i);
            }
        }
    }
}