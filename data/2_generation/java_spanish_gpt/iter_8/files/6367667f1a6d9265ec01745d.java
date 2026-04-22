import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PathSegmentDecoder {

    /** 
     * Decodifica el componente de ruta de una URI como segmentos de ruta.
     * @param u la URI. Si el componente de ruta es un componente de ruta absoluto, el '/' inicial se ignora y no se considera un delimitador de un segmento de ruta.
     * @param decode verdadero si los segmentos de ruta del componente de ruta deben estar en forma decodificada.
     * @return la lista de segmentos de ruta.
     */
    public static List<PathSegmentImpl> decodePath(URI u, boolean decode) {
        List<PathSegmentImpl> segments = new ArrayList<>();
        String path = u.getPath();
        
        // Ignorar el '/' inicial si es un componente de ruta absoluto
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
            // En caso de error, devolver el segmento original
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
}