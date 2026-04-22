public class ConfigurationInitializer {

    /**
     * कॉन्फ़िगरेशन को प्रारंभ करें, जैसे कि वितरण पथ की जांच करें
     */
    public void init() {
        // Check the distribution path
        String distributionPath = System.getProperty("distribution.path");
        
        if (distributionPath == null || distributionPath.isEmpty()) {
            throw new IllegalArgumentException("Distribution path is not set.");
        } else {
            System.out.println("Distribution path is set to: " + distributionPath);
        }

        // Additional initialization logic can be added here
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}