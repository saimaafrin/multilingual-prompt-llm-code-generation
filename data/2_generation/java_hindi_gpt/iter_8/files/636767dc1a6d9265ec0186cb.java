public class ConfigurationInitializer {

    /**
     * कॉन्फ़िगरेशन को प्रारंभ करें, जैसे कि वितरण पथ की जांच करें
     */
    public void init() {
        String distributionPath = System.getProperty("distribution.path");
        
        if (distributionPath == null || distributionPath.isEmpty()) {
            throw new IllegalArgumentException("Distribution path is not set.");
        }
        
        // Perform additional initialization logic here
        System.out.println("Configuration initialized with distribution path: " + distributionPath);
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}