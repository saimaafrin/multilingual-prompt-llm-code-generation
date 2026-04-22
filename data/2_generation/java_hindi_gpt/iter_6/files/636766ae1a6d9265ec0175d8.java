public class ContentRangeBuilder {

    /**
     * 'Content-Range' HTTP हेडर मान बनाएं।
     * @return 'Content-Range' मान
     */
    private String buildContentRange() {
        long start = 0; // प्रारंभ बाइट
        long end = 499; // समाप्त बाइट
        long total = 1234; // कुल बाइट

        return String.format("bytes %d-%d/%d", start, end, total);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}