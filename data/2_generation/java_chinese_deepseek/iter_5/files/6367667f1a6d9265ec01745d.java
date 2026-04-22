import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class URIDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> pathSegments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return pathSegments;
        }

        // Remove leading '/' if the path is absolute
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] segments = path.split("/");
        for (String segment : segments) {
            if (segment.isEmpty()) {
                continue;
            }
            String decodedSegment = decode ? decodeSegment(segment) : segment;
            pathSegments.add(new PathSegmentImpl(decodedSegment));
        }

        return pathSegments;
    }

    private static String decodeSegment(String segment) {
        // Implement URI decoding logic here
        // For simplicity, we'll use java.net.URLDecoder
        try {
            return java.net.URLDecoder.decode(segment, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }

    public static class PathSegmentImpl {
        private final String segment;

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
}