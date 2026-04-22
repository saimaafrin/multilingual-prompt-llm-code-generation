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

        // Ignora il '/' iniziale se il percorso è assoluto
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] rawSegments = path.split("/");
        for (String rawSegment : rawSegments) {
            String segment = decode ? decodeURIComponent(rawSegment) : rawSegment;
            segments.add(new PathSegmentImpl(segment));
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