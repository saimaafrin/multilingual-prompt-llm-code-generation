/**
 * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
 * @return valore 'Content-Range'
 */
private String buildContentRange() {
    // Assuming you have the following variables defined in your class:
    // long startRange: the start of the range
    // long endRange: the end of the range
    // long totalLength: the total length of the content

    // Example values (you should replace these with actual values):
    long startRange = 0;
    long endRange = 1023;
    long totalLength = 2048;

    // Construct the Content-Range header value
    String contentRange = String.format("bytes %d-%d/%d", startRange, endRange, totalLength);
    return contentRange;
}