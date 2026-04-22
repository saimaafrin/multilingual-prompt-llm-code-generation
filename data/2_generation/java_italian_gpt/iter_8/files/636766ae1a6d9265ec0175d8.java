private String buildContentRange() {
    // Example values for demonstration purposes
    long start = 0;
    long end = 99;
    long totalSize = 1000;

    // Constructing the Content-Range header value
    return String.format("bytes %d-%d/%d", start, end, totalSize);
}