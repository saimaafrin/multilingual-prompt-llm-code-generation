public class ConfigInitializer {

    /**
     * initialize config, such as check dist path
     */
    public void init() {
        String distPath = System.getProperty("dist.path");
        if (distPath == null || distPath.isEmpty()) {
            throw new IllegalArgumentException("Distribution path is not set.");
        }
        System.out.println("Configuration initialized with distribution path: " + distPath);
    }

    public static void main(String[] args) {
        ConfigInitializer configInitializer = new ConfigInitializer();
        configInitializer.init();
    }
}