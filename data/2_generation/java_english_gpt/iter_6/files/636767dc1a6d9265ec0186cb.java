import java.io.File;

public class ConfigInitializer {

    /** 
     * initialize config, such as check dist path
     */
    public void init() {
        String distPath = "path/to/dist"; // Specify your distribution path here
        File distDirectory = new File(distPath);
        
        if (!distDirectory.exists()) {
            System.out.println("Distribution path does not exist: " + distPath);
            // You can add code here to create the directory or handle the error
        } else {
            System.out.println("Distribution path is valid: " + distPath);
        }
    }

    public static void main(String[] args) {
        ConfigInitializer configInitializer = new ConfigInitializer();
        configInitializer.init();
    }
}