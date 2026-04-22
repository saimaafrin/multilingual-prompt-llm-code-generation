public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo reformateado 20000123 es 20000123.
     */
    public static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Convertir el bucket de tiempo a String para facilitar la manipulación
        String bucketStr = Long.toString(bucketDeTiempo);
        
        // Extraer el año y el mes (primeros 6 dígitos)
        String yearMonth = bucketStr.substring(0, 6);
        
        // Extraer el día (últimos 2 dígitos)
        int day = Integer.parseInt(bucketStr.substring(6, 8));
        
        // Calcular el día comprimido
        int compressedDay = (day / pasoDiario) * pasoDiario;
        
        // Si el día comprimido es 0, se ajusta al primer día del mes
        if (compressedDay == 0) {
            compressedDay = 1;
        }
        
        // Formatear el día comprimido a dos dígitos
        String compressedDayStr = String.format("%02d", compressedDay);
        
        // Combinar el año, mes y día comprimido
        String compressedBucketStr = yearMonth + compressedDayStr;
        
        // Convertir de nuevo a long
        return Long.parseLong(compressedBucketStr);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(comprimirBucketDeTiempo(20000105L, 11)); // Debería imprimir 20000101
        System.out.println(comprimirBucketDeTiempo(20000115L, 11)); // Debería imprimir 20000112
        System.out.println(comprimirBucketDeTiempo(20000123L, 11)); // Debería imprimir 20000123
    }
}