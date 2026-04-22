import java.io.File;

public class ConfigInitializer {

    /** 
     * initialize config, such as check dist path
     */
    public void init() {
        String distPath = "path/to/dist"; // Specify your distribution path here
        File distDir = new File(distPath);
        
        if (!distDir.exists()) {
            System.out.println("Distribution path does not exist: " + distPath);
            // You can add code here to create the directory if needed
            // distDir.mkdirs();
        } else {
            System.out.println("Distribution path is valid: " + distPath);
        }
    }

    public static void main(String[] args) {
        ConfigInitializer configInitializer = new ConfigInitializer();
        configInitializer.init();
    }
}