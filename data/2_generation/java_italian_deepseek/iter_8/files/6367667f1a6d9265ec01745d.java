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

        // Remove the leading '/' if it's an absolute path
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] pathSegments = path.split("/");
        for (String segment : pathSegments) {
            if (decode) {
                segment = java.net.URLDecoder.decode(segment, java.nio.charset.StandardCharsets.UTF_8);
            }
            segments.add(new PathSegmentImpl(segment, decode));
        }

        return segments;
    }

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path/to/resource%20with%20spaces");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment);
        }
    }
}