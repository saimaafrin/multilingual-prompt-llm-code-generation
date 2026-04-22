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
        
        // Calcular el día reformateado
        int reformattedDay = ((day - 1) / pasoDiario) * pasoDiario + 1;
        
        // Crear una fecha con el día reformateado
        LocalDate date = LocalDate.of(year, month, reformattedDay);
        
        // Formatear la fecha como un número largo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = date.format(formatter);
        
        // Convertir la cadena formateada de vuelta a un long
        return Long.parseLong(formattedDate);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(comprimirBucketDeTiempo(20000105L, 11)); // 20000101
        System.out.println(comprimirBucketDeTiempo(20000115L, 11)); // 20000112
        System.out.println(comprimirBucketDeTiempo(20000123L, 11)); // 20000123
    }
}