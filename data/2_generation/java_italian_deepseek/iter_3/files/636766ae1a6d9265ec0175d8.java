/**
 * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
 * @return valore 'Content-Range'
 */
private String buildContentRange() {
    // Assuming you have the following variables defined in your class:
    // long startRange, endRange, totalSize;
    
    // Example values for startRange, endRange, and totalSize
    long startRange = 0; // Example start range
    long endRange = 1023; // Example end range
    long totalSize = 2048; // Example total size

    // Construct the Content-Range header value
    String contentRange = String.format("bytes %d-%d/%d", startRange, endRange, totalSize);
    
    return contentRange;
}