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

        // Remove the leading '/' if it exists and the path is absolute
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] segments = path.split("/");
        for (String segment : segments) {
            if (!segment.isEmpty()) {
                String decodedSegment = decode ? decodeSegment(segment) : segment;
                pathSegments.add(new PathSegmentImpl(decodedSegment));
            }
        }

        return pathSegments;
    }

    private static String decodeSegment(String segment) {
        // Implement URI decoding logic here
        // This is a placeholder for actual URI decoding
        return java.net.URLDecoder.decode(segment, java.nio.charset.StandardCharsets.UTF_8);
    }

    public static class PathSegmentImpl {
        private final String path;

        public PathSegmentImpl(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        @Override
        public String toString() {
            return path;
        }
    }

    public static void main(String[] args) {
        // Example usage
        URI uri = URI.create("http://example.com/path/to/resource");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}