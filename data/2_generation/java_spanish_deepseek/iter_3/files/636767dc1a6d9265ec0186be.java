import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo reformateado 20000123 es 20000123.
     */
    public static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Convertir el bucket de tiempo a una cadena para facilitar el manejo
        String bucketStr = Long.toString(bucketDeTiempo);
        
        // Extraer el año, mes y día
        int year = Integer.parseInt(bucketStr.substring(0, 4));
        int month = Integer.parseInt(bucketStr.substring(4, 6));
        int day = Integer.parseInt(bucketStr.substring(6, 8));
        
        // Calcular el día comprimido
        int compressedDay = ((day - 1) / pasoDiario) * pasoDiario + 1;
        
        // Crear una fecha con el día comprimido
        LocalDate compressedDate = LocalDate.of(year, month, compressedDay);
        
        // Formatear la fecha comprimida a un long
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String compressedDateStr = compressedDate.format(formatter);
        
        return Long.parseLong(compressedDateStr);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        long bucket1 = 20000105L;
        int pasoDiario = 11;
        System.out.println(comprimirBucketDeTiempo(bucket1, pasoDiario)); // Debería imprimir 20000101

        long bucket2 = 20000115L;
        System.out.println(comprimirBucketDeTiempo(bucket2, pasoDiario)); // Debería imprimir 20000112

        long bucket3 = 20000123L;
        System.out.println(comprimirBucketDeTiempo(bucket3, pasoDiario)); // Debería imprimir 20000123
    }
}