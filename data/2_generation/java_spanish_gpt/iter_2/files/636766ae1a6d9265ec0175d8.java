public class ContentRangeBuilder {

    /**
     * Construye el valor del encabezado HTTP 'Content-Range'.
     * @return valor de 'Content-Range'
     */
    private String buildContentRange() {
        // Ejemplo de valores para el rango y el tamaño total
        long start = 0;
        long end = 99;
        long totalSize = 200;

        return String.format("bytes %d-%d/%d", start, end, totalSize);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}