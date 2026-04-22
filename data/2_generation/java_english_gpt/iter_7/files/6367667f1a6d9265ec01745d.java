import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentDecoder {

    /** 
     * Decode the path component of a URI as path segments.
     * @param u the URI. If the path component is an absolute path component then the leading '/' is ignored and is not considered a delimiter of a path segment.
     * @param decode true if the path segments of the path component should be in decoded form.
     * @return the list of path segments.
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();
        
        // Remove leading '/' if it's an absolute path
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        
        // Split the path into segments
        String[] pathSegments = path.split("/");
        
        for (String segment : pathSegments) {
            if (decode) {
                segment = decodeSegment(segment);
            }
            segments.add(new PathSegmentImpl(segment));
        }
        
        return segments;
    }

    private static String decodeSegment(String segment) {
        try {
            return java.net.URLDecoder.decode(segment, "UTF-8");
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            return segment; // Return the original segment if decoding fails
        }
    }

    // Dummy PathSegmentImpl class for demonstration purposes
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