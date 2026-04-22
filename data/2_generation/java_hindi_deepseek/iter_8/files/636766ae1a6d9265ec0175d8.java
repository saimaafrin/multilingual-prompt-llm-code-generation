import java.util.Objects;

public class ContentRangeBuilder {

    /**
     * 'Content-Range' HTTP हेडर मान बनाएं।
     * @return 'Content-Range' मान
     */
    private String buildContentRange() {
        // यहां आप 'Content-Range' हेडर का मान बना सकते हैं।
        // उदाहरण के लिए, यह एक साधारण रेंज दिखाता है।
        long start = 0;
        long end = 1023;
        long total = 2048;

        return String.format("bytes %d-%d/%d", start, end, total);
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}