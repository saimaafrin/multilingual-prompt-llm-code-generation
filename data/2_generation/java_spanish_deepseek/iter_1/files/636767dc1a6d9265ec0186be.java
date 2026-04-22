import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo reformateado 20000123 es 20000123.
     */
    public static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Convertir el bucket de tiempo a una cadena para facilitar el manejo
        String bucketStr = Long.toString(bucketDeTiempo);
        
        // Crear un LocalDate a partir del bucket de tiempo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(bucketStr, formatter);
        
        // Obtener el día del mes
        int dayOfMonth = date.getDayOfMonth();
        
        // Calcular el nuevo día basado en el pasoDiario
        int newDay = ((dayOfMonth - 1) / pasoDiario) * pasoDiario + 1;
        
        // Crear una nueva fecha con el día ajustado
        LocalDate newDate = date.withDayOfMonth(newDay);
        
        // Convertir la nueva fecha de vuelta a un long
        String newBucketStr = newDate.format(formatter);
        return Long.parseLong(newBucketStr);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(comprimirBucketDeTiempo(20000105L, 11)); // 20000101
        System.out.println(comprimirBucketDeTiempo(20000115L, 11)); // 20000112
        System.out.println(comprimirBucketDeTiempo(20000123L, 11)); // 20000123
    }
}