import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolver {
    /**
     * दिए गए पथ पर दिए गए सापेक्ष पथ को लागू करें, मानते हुए कि मानक जावा फ़ोल्डर विभाजन (यानी "/" विभाजक) है।
     * @param path वह पथ जिससे शुरू करना है (आमतौर पर एक पूर्ण फ़ाइल पथ)
     * @param relativePath लागू करने के लिए सापेक्ष पथ (ऊपर दिए गए पूर्ण फ़ाइल पथ के सापेक्ष)
     * @return वह पूर्ण फ़ाइल पथ जो सापेक्ष पथ को लागू करने से प्राप्त होता है
     */
    public static String applyRelativePath(String path, String relativePath) {
        // Convert the base path to a Path object
        Path basePath = Paths.get(path);
        
        // Resolve the relative path against the base path
        Path resolvedPath = basePath.resolve(relativePath);
        
        // Normalize the path to remove any redundant elements
        Path normalizedPath = resolvedPath.normalize();
        
        // Convert the normalized path back to a string
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String basePath = "/home/user/documents";
        String relativePath = "../images/photo.jpg";
        String result = applyRelativePath(basePath, relativePath);
        System.out.println(result);  // Output: /home/user/images/photo.jpg
    }
}