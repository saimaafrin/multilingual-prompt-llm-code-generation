import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /**
     * Calcola la dimensione della stringa utf8 che inizia all'indice specificato {@code index} con la lunghezza specificata {@code length}.
     *
     * @param str   La sequenza di caratteri da cui calcolare la dimensione UTF-8.
     * @param index L'indice iniziale della sottostringa.
     * @param len   La lunghezza della sottostringa.
     * @return La dimensione in byte della sottostringa in formato UTF-8.
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null || index < 0 || len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        CharSequence str = "Ciao, mondo!";
        int index = 0;
        int len = 4;
        int size = computeUTF8Size(str, index, len);
        System.out.println("Dimensione UTF-8: " + size + " byte");
    }
}