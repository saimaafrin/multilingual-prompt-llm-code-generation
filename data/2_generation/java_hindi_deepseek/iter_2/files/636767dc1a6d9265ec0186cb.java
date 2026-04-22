import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigurationInitializer {

    /**
     * कॉन्फ़िगरेशन को प्रारंभ करें, जैसे कि वितरण पथ की जांच करें
     */
    public void init() {
        // Define the distribution path
        String distributionPath = "/path/to/distribution";
        Path path = Paths.get(distributionPath);

        // Check if the path exists
        if (Files.exists(path)) {
            System.out.println("Distribution path exists: " + path.toAbsolutePath());
        } else {
            System.out.println("Distribution path does not exist: " + path.toAbsolutePath());
        }
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}