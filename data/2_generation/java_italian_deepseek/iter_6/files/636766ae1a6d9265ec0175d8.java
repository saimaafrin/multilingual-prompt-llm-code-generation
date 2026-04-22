/**
 * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
 * @return valore 'Content-Range'
 */
private String buildContentRange() {
    // Assuming these values are defined somewhere in the class
    long start = 0; // Example start byte
    long end = 1023; // Example end byte
    long totalSize = 2048; // Example total size

    return String.format("bytes %d-%d/%d", start, end, totalSize);
}