import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PathDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        
        String path = u.getRawPath();
        if (path == null || path.isEmpty()) {
            return segments;
        }

        // Remove leading slash for absolute paths
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        // Handle empty path
        if (path.isEmpty()) {
            return segments;
        }

        // Split path into segments
        String[] rawSegments = path.split("/");

        for (String segment : rawSegments) {
            if (decode) {
                try {
                    // Decode segment using UTF-8 encoding
                    segment = URLDecoder.decode(segment, StandardCharsets.UTF_8.name());
                } catch (Exception e) {
                    // Keep original segment if decoding fails
                }
            }
            segments.add(new PathSegmentImpl(segment));
        }

        return segments;
    }

    // Inner class to represent path segments
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
}