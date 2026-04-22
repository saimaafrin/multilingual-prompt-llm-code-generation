/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // Assuming the content length is known and the range is from start to end
    long start = 0; // Starting byte position
    long end = 1023; // Ending byte position
    long totalLength = 2048; // Total length of the content

    // Format: "bytes start-end/totalLength"
    return String.format("bytes %d-%d/%d", start, end, totalLength);
}