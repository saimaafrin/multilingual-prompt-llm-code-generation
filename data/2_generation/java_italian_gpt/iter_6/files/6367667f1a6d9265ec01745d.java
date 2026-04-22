import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PathDecoder {

    /** 
     * Decodifica il componente di percorso di un URI come segmenti di percorso.
     * @param u l'URI. Se il componente di percorso è un componente di percorso assoluto, il '/' iniziale viene ignorato e non è considerato un delimitatore di un segmento di percorso.
     * @param decode vero se i segmenti di percorso del componente di percorso devono essere in forma decodificata.
     * @return la lista dei segmenti di percorso.
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();

        // Ignora il primo '/' se presente
        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        String[] pathSegments = path.split("/");

        for (String segment : pathSegments) {
            if (decode) {
                segment = decodeSegment(segment);
            }
            segments.add(new PathSegmentImpl(segment));
        }

        return segments;
    }

    private static String decodeSegment(String segment) {
        try {
            return java.net.URLDecoder.decode(segment, "UTF-8");
        } catch (Exception e) {
            // In caso di errore di decodifica, restituisce il segmento originale
            return segment;
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