import java.util.Objects;

public class ContentRangeBuilder {

    /**
     * 'Content-Range' HTTP हेडर मान बनाएं।
     * @return 'Content-Range' मान
     */
    private String buildContentRange() {
        // यहां आप 'Content-Range' हेडर का मान बना सकते हैं।
        // उदाहरण के लिए, एक साधारण 'Content-Range' मान बनाया जा रहा है।
        String unit = "bytes";
        int start = 0;
        int end = 1023;
        int total = 2048;

        // 'Content-Range' मान बनाएं
        String contentRange = String.format("%s %d-%d/%d", unit, start, end, total);

        // मान को वापस करें
        return contentRange;
    }

    public static void main(String[] args) {
        ContentRangeBuilder builder = new ContentRangeBuilder();
        String contentRange = builder.buildContentRange();
        System.out.println(contentRange);
    }
}