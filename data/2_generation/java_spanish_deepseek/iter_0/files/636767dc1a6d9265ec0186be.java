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
        
        // Crear una fecha con LocalDate
        LocalDate date = LocalDate.of(year, month, day);
        
        // Calcular el día ajustado según el pasoDiario
        int adjustedDay = ((day - 1) / pasoDiario) * pasoDiario + 1;
        
        // Crear una nueva fecha con el día ajustado
        LocalDate adjustedDate = LocalDate.of(year, month, adjustedDay);
        
        // Formatear la fecha ajustada a un long
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = adjustedDate.format(formatter);
        
        return Long.parseLong(formattedDate);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(comprimirBucketDeTiempo(20000105L, 11)); // Debería imprimir 20000101
        System.out.println(comprimirBucketDeTiempo(20000115L, 11)); // Debería imprimir 20000112
        System.out.println(comprimirBucketDeTiempo(20000123L, 11)); // Debería imprimir 20000123
    }
}