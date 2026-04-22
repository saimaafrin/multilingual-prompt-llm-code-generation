public class StringUtils {
    /**
     * Restituisce il numero di occorrenze della sottostringa {@code sub} nella stringa {@code str}.
     * @param str stringa in cui cercare. Restituisce 0 se è null.
     * @param sub stringa da cercare. Restituisce 0 se è null.
     * @return il numero di occorrenze della sottostringa {@code sub} nella stringa {@code str}.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || sub.length() == 0) {
            return 0;
        }

        int count = 0;
        int pos = 0;
        int idx;

        while ((idx = str.indexOf(sub, pos)) != -1) {
            count++;
            pos = idx + sub.length();
        }

        return count;
    }
}