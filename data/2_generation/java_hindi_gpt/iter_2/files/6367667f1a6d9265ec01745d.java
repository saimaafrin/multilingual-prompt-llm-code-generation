import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentImpl {
    private String segment;

    public PathSegmentImpl(String segment) {
        this.segment = segment;
    }

    public String getSegment() {
        return segment;
    }

    @Override
    public String toString() {
        return segment;
    }
}

public class PathDecoder {
    /** 
     * URI के पथ घटक को पथ खंडों के रूप में डिकोड करें।
     * @param u URI। यदि पथ घटक एक पूर्ण पथ घटक है, तो अग्रणी '/' को अनदेखा किया जाता है और इसे पथ खंड के विभाजक के रूप में नहीं माना जाता है।
     * @param decode यदि पथ घटक के पथ खंडों को डिकोडेड रूप में होना चाहिए तो true।
     * @return पथ खंडों की सूची।
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return segments;
        }

        String[] parts = path.split("/");
        for (String part : parts) {
            if (!part.isEmpty()) {
                String segment = decode ? decodeURIComponent(part) : part;
                segments.add(new PathSegmentImpl(segment));
            }
        }

        return segments;
    }

    private static String decodeURIComponent(String component) {
        try {
            return java.net.URLDecoder.decode(component, "UTF-8");
        } catch (Exception e) {
            return component; // Return the original if decoding fails
        }
    }

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}