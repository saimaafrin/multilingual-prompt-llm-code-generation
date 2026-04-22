import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class URIPathDecoder {
    
    public static List<String> decodePath(URI u, boolean decode) {
        String path = u.getPath();
        List<String> segments = new ArrayList<>();
        
        // Handle empty or null path
        if (path == null || path.isEmpty()) {
            return segments;
        }

        // Remove leading '/' for absolute paths
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        // Split path into segments
        String[] rawSegments = path.split("/");
        
        // Process each segment
        for (String segment : rawSegments) {
            if (segment.isEmpty()) {
                continue;
            }
            
            if (decode) {
                try {
                    // Decode segment using UTF-8 encoding
                    segment = URLDecoder.decode(segment, StandardCharsets.UTF_8.toString());
                } catch (Exception e) {
                    // If decoding fails, use raw segment
                }
            }
            segments.add(segment);
        }
        
        return segments;
    }
}