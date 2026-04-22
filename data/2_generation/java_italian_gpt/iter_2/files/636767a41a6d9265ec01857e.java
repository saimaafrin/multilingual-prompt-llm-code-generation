public class LongComparator {
    
    /** 
     * Confronta i due valori {@code long} specificati. Il segno del valore restituito è lo stesso di {@code ((Long) a).compareTo(b)}. <p> <b>Nota per Java 7 e versioni successive:</b> questo metodo dovrebbe essere considerato deprecato; utilizzare invece il metodo equivalente {@link Long#compare}.
     * @param a il primo {@code long} da confrontare
     * @param b il secondo {@code long} da confrontare
     * @return un valore negativo se {@code a} è minore di {@code b}; un valore positivo se {@code a} è maggiore di {@code b}; o zero se sono uguali
     */
    private static int compareSigned(long a, long b) {
        return (a < b) ? -1 : (a > b) ? 1 : 0;
    }

    public static void main(String[] args) {
        // Test the compareSigned method
        System.out.println(compareSigned(5L, 10L)); // Output: -1
        System.out.println(compareSigned(10L, 5L)); // Output: 1
        System.out.println(compareSigned(10L, 10L)); // Output: 0
    }
}