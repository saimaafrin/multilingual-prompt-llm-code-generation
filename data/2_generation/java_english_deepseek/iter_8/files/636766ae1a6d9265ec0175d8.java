/**
 * Build the 'Content-Range' HTTP Header value.
 * @return 'Content-Range' value
 */
private String buildContentRange() {
    // Assuming the range is from 0 to 100 and the total size is 500
    int start = 0;
    int end = 100;
    int totalSize = 500;
    
    return String.format("bytes %d-%d/%d", start, end, totalSize);
}