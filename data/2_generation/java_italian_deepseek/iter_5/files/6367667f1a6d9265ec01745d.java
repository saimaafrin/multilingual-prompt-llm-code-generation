import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URIDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return segments;
        }

        // Remove the leading '/' if it's an absolute path
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] rawSegments = path.split("/");
        for (String rawSegment : rawSegments) {
            if (rawSegment.isEmpty()) {
                continue;
            }

            String segment = rawSegment;
            if (decode) {
                try {
                    segment = URLDecoder.decode(rawSegment, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // If decoding fails, use the raw segment
                    segment = rawSegment;
                }
            }

            segments.add(new PathSegmentImpl(segment));
        }

        return segments;
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