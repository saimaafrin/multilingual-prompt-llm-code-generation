/**
 * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
 * @return valore 'Content-Range'
 */
private String buildContentRange() {
    // Assuming you have the following variables defined in your class:
    // private long start; // The start byte of the range
    // private long end;   // The end byte of the range
    // private long total; // The total size of the file or resource

    // Example values for start, end, and total
    long start = 0;
    long end = 1023;
    long total = 2048;

    // Construct the Content-Range header value
    return String.format("bytes %d-%d/%d", start, end, total);
}