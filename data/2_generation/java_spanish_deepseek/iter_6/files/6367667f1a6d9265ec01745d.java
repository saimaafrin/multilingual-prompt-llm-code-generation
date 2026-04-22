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
            if (decode) {
                part = java.net.URLDecoder.decode(part, java.nio.charset.StandardCharsets.UTF_8);
            }
            segments.add(new PathSegmentImpl(part, decode));
        }

        return segments;
    }
}