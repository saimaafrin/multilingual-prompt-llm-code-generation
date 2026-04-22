import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentImpl {
    private final String path;
    private final boolean decoded;

    public PathSegmentImpl(String path, boolean decoded) {
        this.path = path;
        this.decoded = decoded;
    }

    public String getPath() {
        return path;
    }

    public boolean isDecoded() {
        return decoded;
    }

    @Override
    public String toString() {
        return "PathSegmentImpl{" +
                "path='" + path + '\'' +
                ", decoded=" + decoded +
                '}';
    }
}

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
            String segment = decode ? decodeURIComponent(rawSegment) : rawSegment;
            segments.add(new PathSegmentImpl(segment, decode));
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

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource%20with%20spaces");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}