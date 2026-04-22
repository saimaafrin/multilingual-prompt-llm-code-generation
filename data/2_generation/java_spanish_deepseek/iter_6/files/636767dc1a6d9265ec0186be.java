public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo reformateado 20000123 es 20000123.
     *
     * @param bucketDeTiempo El valor literal largo del bucket de tiempo.
     * @param pasoDiario El paso diario para reformatear el bucket de tiempo.
     * @return El bucket de tiempo reformateado.
     */
    public static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Extraer el año y el mes del bucket de tiempo
        long yearMonth = (bucketDeTiempo / 100) * 100;
        int day = (int) (bucketDeTiempo % 100);

        // Calcular el día reformateado
        int reformattedDay = ((day - 1) / pasoDiario) * pasoDiario + 1;

        // Combinar el año, mes y día reformateado
        return yearMonth + reformattedDay;
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(comprimirBucketDeTiempo(20000105L, 11)); // Debería imprimir 20000101
        System.out.println(comprimirBucketDeTiempo(20000115L, 11)); // Debería imprimir 20000112
        System.out.println(comprimirBucketDeTiempo(20000123L, 11)); // Debería imprimir 20000123
    }
}