import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class URIDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return segments;
        }

        // Remove the leading '/' if it exists and the path is absolute
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] parts = path.split("/");
        for (String part : parts) {
            if (!part.isEmpty()) {
                String decodedPart = decode ? decodeURIComponent(part) : part;
                segments.add(new PathSegmentImpl(decodedPart));
            }
        }

        return segments;
    }

    private static String decodeURIComponent(String encoded) {
        try {
            return java.net.URLDecoder.decode(encoded, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
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
}