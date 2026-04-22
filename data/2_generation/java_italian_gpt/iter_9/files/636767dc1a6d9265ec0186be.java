public class TimeBucketCompressor {

    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale. 
     * Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101, 
     * per 20000115 è 20000112, e per 20000123 è 20000123.
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Estrai l'anno, il mese e il giorno dal timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);
        
        // Calcola il giorno riformattato
        int newDay = (day - 1) / dayStep * dayStep + 1;
        
        // Gestisci il caso in cui il nuovo giorno supera il numero di giorni nel mese
        int daysInMonth = getDaysInMonth(year, month);
        if (newDay > daysInMonth) {
            newDay = daysInMonth;
        }
        
        // Riformatta il bucket temporale
        return year * 10000 + month * 100 + newDay;
    }

    // Funzione di supporto per ottenere il numero di giorni in un mese
    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // mese non valido
        }
    }

    // Funzione di supporto per determinare se un anno è bisestile
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(compressTimeBucket(20000105, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Output: 20000123
    }
}