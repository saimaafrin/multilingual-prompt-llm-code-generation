public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo reformateado 20000123 es 20000123.
     *
     * @param bucketDeTiempo El valor largo que representa el bucket de tiempo en formato YYYYMMDD.
     * @param pasoDiario El paso diario que se utiliza para comprimir el bucket de tiempo.
     * @return El bucket de tiempo comprimido en formato YYYYMMDD.
     */
    public static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Extraer el año, mes y día del bucket de tiempo
        int year = (int) (bucketDeTiempo / 10000);
        int month = (int) ((bucketDeTiempo % 10000) / 100);
        int day = (int) (bucketDeTiempo % 100);

        // Calcular el día comprimido
        int compressedDay = ((day - 1) / pasoDiario) * pasoDiario + 1;

        // Reconstruir el bucket de tiempo comprimido
        long compressedBucket = year * 10000L + month * 100L + compressedDay;

        return compressedBucket;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        long bucket1 = 20000105L;
        long bucket2 = 20000115L;
        long bucket3 = 20000123L;
        int pasoDiario = 11;

        System.out.println(comprimirBucketDeTiempo(bucket1, pasoDiario)); // 20000101
        System.out.println(comprimirBucketDeTiempo(bucket2, pasoDiario)); // 20000112
        System.out.println(comprimirBucketDeTiempo(bucket3, pasoDiario)); // 20000123
    }
}