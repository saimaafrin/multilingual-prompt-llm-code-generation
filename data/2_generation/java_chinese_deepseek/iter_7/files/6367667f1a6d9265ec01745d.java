import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentImpl {
    private String path;
    private boolean decoded;

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
}

public class URIDecoder {

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> pathSegments = new ArrayList<>();
        String path = u.getPath();

        if (path == null || path.isEmpty()) {
            return pathSegments;
        }

        // Remove leading '/' if the path is absolute
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] segments = path.split("/");
        for (String segment : segments) {
            if (decode) {
                segment = java.net.URLDecoder.decode(segment, java.nio.charset.StandardCharsets.UTF_8);
            }
            pathSegments.add(new PathSegmentImpl(segment, decode));
        }

        return pathSegments;
    }

    public static void main(String[] args) {
        URI uri = URI.create("http://example.com/path%20to%20something/another%20path");
        List<PathSegmentImpl> segments = decodePath(uri, true);
        for (PathSegmentImpl segment : segments) {
            System.out.println(segment.getPath());
        }
    }
}