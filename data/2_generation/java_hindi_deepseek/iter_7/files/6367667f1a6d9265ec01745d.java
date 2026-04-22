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

        // Remove leading '/' if present
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] segments = path.split("/");
        for (String segment : segments) {
            if (decode) {
                segment = java.net.URLDecoder.decode(segment, java.nio.charset.StandardCharsets.UTF_8);
            }
            pathSegments.add(new PathSegmentImpl(segment));
        }

        return pathSegments;
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

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}