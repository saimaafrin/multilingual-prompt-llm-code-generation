/**
 * Build the 'Content-Range' HTTP Header value.
 * @return 'Content-Range' value
 */
private String buildContentRange() {
    // Assuming the range and total size are known or calculated elsewhere in the class
    long start = 0; // Example start byte
    long end = 1023; // Example end byte
    long total = 2048; // Example total size

    return String.format("bytes %d-%d/%d", start, end, total);
}