import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class URIUtils {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return segments;
        }

        // Ignore the leading '/' if it's an absolute path
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] parts = path.split("/");
        for (String part : parts) {
            if (decode) {
                part = java.net.URLDecoder.decode(part, java.nio.charset.StandardCharsets.UTF_8);
            }
            segments.add(new PathSegmentImpl(part));
        }

        return segments;
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
            return "PathSegmentImpl{" +
                    "path='" + path + '\'' +
                    '}';
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