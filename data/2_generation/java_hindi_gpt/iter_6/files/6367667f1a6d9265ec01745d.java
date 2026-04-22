import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentDecoder {

    /** 
     * URI के पथ घटक को पथ खंडों के रूप में डिकोड करें।
     * @param u URI। यदि पथ घटक एक पूर्ण पथ घटक है, तो अग्रणी '/' को अनदेखा किया जाता है और इसे पथ खंड के विभाजक के रूप में नहीं माना जाता है।
     * @param decode यदि पथ घटक के पथ खंडों को डिकोडेड रूप में होना चाहिए तो true।
     * @return पथ खंडों की सूची।
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();
        
        // Remove leading '/' if present
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        
        // Split the path into segments
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (decode) {
                part = decodeURIComponent(part);
            }
            segments.add(new PathSegmentImpl(part));
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

    // Dummy implementation of PathSegmentImpl for demonstration purposes
    public static class PathSegmentImpl {
        private String segment;

        public PathSegmentImpl(String segment) {
            this.segment = segment;
        }

        @Override
        public String toString() {
            return segment;
        }
    }
}