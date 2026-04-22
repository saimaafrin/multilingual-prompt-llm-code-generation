/**
 * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
 * @return valore 'Content-Range'
 */
private String buildContentRange() {
    // Assuming you have the following variables defined in your class:
    // long start: the start byte of the range
    // long end: the end byte of the range
    // long totalSize: the total size of the resource

    // Example values (you should replace these with actual values)
    long start = 0;
    long end = 1023;
    long totalSize = 2048;

    // Construct the Content-Range header value
    String contentRange = String.format("bytes %d-%d/%d", start, end, totalSize);
    return contentRange;
}