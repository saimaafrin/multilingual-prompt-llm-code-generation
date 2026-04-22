/**
 * Construye el valor del encabezado HTTP 'Content-Range'.
 * @return valor de 'Content-Range'
 */
private String buildContentRange() {
    // Supongamos que tenemos los siguientes valores para el rango y el tamaño total
    long start = 0; // Inicio del rango
    long end = 1023; // Fin del rango
    long totalSize = 2048; // Tamaño total del recurso

    // Construir el valor del encabezado Content-Range
    String contentRange = String.format("bytes %d-%d/%d", start, end, totalSize);
    return contentRange;
}