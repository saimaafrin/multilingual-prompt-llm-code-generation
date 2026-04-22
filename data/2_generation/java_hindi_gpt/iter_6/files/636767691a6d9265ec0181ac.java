import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    /** 
     * दिए गए पथ पर दिए गए सापेक्ष पथ को लागू करें, मानते हुए कि मानक जावा फ़ोल्डर विभाजन (यानी "/" विभाजक) है।
     * @param path वह पथ जिससे शुरू करना है (आमतौर पर एक पूर्ण फ़ाइल पथ)
     * @param relativePath लागू करने के लिए सापेक्ष पथ (ऊपर दिए गए पूर्ण फ़ाइल पथ के सापेक्ष)
     * @return वह पूर्ण फ़ाइल पथ जो सापेक्ष पथ को लागू करने से प्राप्त होता है
     */
    public static String applyRelativePath(String path, String relativePath) {
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolveSibling(relativePath);
        return resolvedPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/documents";
        String relativePath = "../pictures/image.png";
        String result = applyRelativePath(path, relativePath);
        System.out.println(result); // Output: /home/user/pictures/image.png
    }
}