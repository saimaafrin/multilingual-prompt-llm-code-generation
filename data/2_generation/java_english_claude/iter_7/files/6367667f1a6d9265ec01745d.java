import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class URIPathDecoder {

    public static class PathSegmentImpl {
        private final String path;
        
        public PathSegmentImpl(String path) {
            this.path = path;
        }
        
        public String getPath() {
            return path;
        }
    }

    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        
        if (u == null || u.getPath() == null || u.getPath().isEmpty()) {
            return segments;
        }

        String path = u.getPath();
        
        // Remove leading '/' for absolute paths
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
            if (segment.isEmpty()) {
                continue;
            }
            
            try {
                // Decode segment if requested
                String decodedSegment = decode ? 
                    URLDecoder.decode(segment, StandardCharsets.UTF_8.toString()) : 
                    segment;
                    
                segments.add(new PathSegmentImpl(decodedSegment));
            } catch (Exception e) {
                // If decoding fails, add raw segment
                segments.add(new PathSegmentImpl(segment));
            }
        }

        return segments;
    }
}