/**
 * Build the 'Content-Range' HTTP Header value.
 * @return 'Content-Range' value
 */
private String buildContentRange(long start, long end, long total) {
    return String.format("bytes %d-%d/%d", start, end, total);
}