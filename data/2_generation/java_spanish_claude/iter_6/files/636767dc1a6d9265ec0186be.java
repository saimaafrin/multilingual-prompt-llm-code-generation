import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BucketTiempoUtil {
    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. 
     * Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, 
     * el "bucket" de tiempo reformateado 20000115 es 20000112, y el "bucket" de tiempo 
     * reformateado 20000123 es 20000123.
     */
    static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Convertir el bucket de tiempo a string con formato YYYYMMDD
        String fechaStr = String.valueOf(bucketDeTiempo);
        
        // Parsear la fecha usando LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate fecha = LocalDate.parse(fechaStr, formatter);
        
        // Obtener el día del mes
        int dia = fecha.getDayOfMonth();
        
        // Calcular el nuevo día basado en el paso diario
        int nuevoDia;
        if (dia % pasoDiario == 0) {
            nuevoDia = dia;
        } else {
            nuevoDia = ((dia - 1) / pasoDiario) * pasoDiario + 1;
        }
        
        // Crear nueva fecha con el día ajustado
        LocalDate nuevaFecha = fecha.withDayOfMonth(nuevoDia);
        
        // Convertir la fecha de vuelta a long
        return Long.parseLong(nuevaFecha.format(formatter));
    }
}