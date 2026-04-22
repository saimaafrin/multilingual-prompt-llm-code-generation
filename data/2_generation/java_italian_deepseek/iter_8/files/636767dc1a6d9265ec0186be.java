public class TimeBucketCompressor {

    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale.
     * Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101,
     * per 20000115 è 20000112, e per 20000123 è 20000123.
     *
     * @param timeBucket Il bucket temporale da comprimere, in formato YYYYMMDD.
     * @param dayStep Il passo giornaliero per la compressione.
     * @return Il bucket temporale compresso.
     */
    public static long compressTimeBucket(long timeBucket, int dayStep) {
        // Estrai l'anno, il mese e il giorno dal timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);

        // Calcola il giorno compresso
        int compressedDay = ((day - 1) / dayStep) * dayStep + 1;

        // Ricostruisci il bucket temporale compresso
        return year * 10000L + month * 100L + compressedDay;
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(compressTimeBucket(20000105L, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115L, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123L, 11)); // Output: 20000123
    }
}