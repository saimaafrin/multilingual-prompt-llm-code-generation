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
            if (!part.isEmpty()) {
                String decodedPath = decode ? decodeURIComponent(part) : part;
                segments.add(new PathSegmentImpl(decodedPath, decode));
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

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}