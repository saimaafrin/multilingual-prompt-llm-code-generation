import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentDecoder {

    /** 
     * 将URI的路径组件解码为路径段。
     * @param u URI。如果路径组件是绝对路径组件，则忽略前导'/'，并且不将其视为路径段的分隔符。
     * @param decode 如果路径组件的路径段应该以解码形式返回，则为真。
     * @return 路径段的列表。
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        // 如果是绝对路径，忽略前导'/'
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] pathParts = path.split("/");
        for (String part : pathParts) {
            if (decode) {
                part = decodeURIComponent(part);
            }
            segments.add(new PathSegmentImpl(part));
        }

        return segments;
    }

    private static String decodeURIComponent(String component) {
        try {
            return java.net.URLDecoder.decode(component, "UTF-8");
        } catch (Exception e) {
            return component; // 返回原始组件以防解码失败
        }
    }

    public static class PathSegmentImpl {
        private String segment;

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

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://example.com/path/to/resource");
            List<PathSegmentImpl> segments = decodePath(uri, true);
            for (PathSegmentImpl segment : segments) {
                System.out.println(segment);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}