public class TimeBucketCompressor {

    /**
     * Sigue el "dayStep" para reformatear el valor literal largo del bucket de tiempo. 
     * Por ejemplo, en dayStep == 11, el "bucket" de tiempo reformateado 20000105 es 20000101, 
     * el "bucket" de tiempo reformateado 20000115 es 20000112, 
     * y el "bucket" de tiempo reformateado 20000123 es 20000123.
     */
    static long comprimirBucketDeTiempo(long bucketDeTiempo, int pasoDiario) {
        // Extraer el año, mes y día del bucket de tiempo
        int year = (int) (bucketDeTiempo / 10000);
        int month = (int) ((bucketDeTiempo % 10000) / 100);
        int day = (int) (bucketDeTiempo % 100);
        
        // Calcular el día del año
        java.time.LocalDate date = java.time.LocalDate.of(year, month, day);
        int dayOfYear = date.getDayOfYear();
        
        // Calcular el nuevo día del año basado en el paso diario
        int newDayOfYear = (dayOfYear / pasoDiario) * pasoDiario;
        
        // Obtener la nueva fecha a partir del nuevo día del año
        java.time.LocalDate newDate = java.time.LocalDate.ofYearDay(year, newDayOfYear);
        
        // Reformatear la nueva fecha a formato largo
        long nuevoBucketDeTiempo = newDate.getYear() * 10000 + newDate.getMonthValue() * 100 + newDate.getDayOfMonth();
        
        return nuevoBucketDeTiempo;
    }

    public static void main(String[] args) {
        long bucketDeTiempo = 20000115;
        int pasoDiario = 11;
        long resultado = comprimirBucketDeTiempo(bucketDeTiempo, pasoDiario);
        System.out.println("Bucket de tiempo reformateado: " + resultado);
    }
}