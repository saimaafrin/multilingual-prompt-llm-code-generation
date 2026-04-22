public class ConfigInitializer {

    private String distPath;

    public ConfigInitializer(String distPath) {
        this.distPath = distPath;
    }

    /** 
     * initialize config, such as check dist path
     */
    public void init() {
        if (distPath == null || distPath.isEmpty()) {
            throw new IllegalArgumentException("Distribution path cannot be null or empty");
        }
        
        File distDir = new File(distPath);
        if (!distDir.exists()) {
            throw new IllegalArgumentException("Distribution path does not exist: " + distPath);
        }
        
        if (!distDir.isDirectory()) {
            throw new IllegalArgumentException("Distribution path is not a directory: " + distPath);
        }

        System.out.println("Configuration initialized successfully with distribution path: " + distPath);
    }

    public static void main(String[] args) {
        ConfigInitializer configInitializer = new ConfigInitializer("path/to/dist");
        configInitializer.init();
    }
}