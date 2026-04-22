import java.util.Objects;

public class ContentRangeBuilder {

    /**
     * 'Content-Range' HTTP हेडर मान बनाएं।
     * @return 'Content-Range' मान
     */
    private String buildContentRange() {
        // Assuming some default values for the range and total size
        long start = 0;
        long end = 1023; // Example end range
        long totalSize = 2048; // Example total size

        // Format the Content-Range header value
        return String.format("bytes %d-%d/%d", start, end, totalSize);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}