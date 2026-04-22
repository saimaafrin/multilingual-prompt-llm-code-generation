import java.io.File;

public class ConfigurationDirectoryCreator {

    /** 
     * वह निर्देशिका बनाता है जहाँ MRU फ़ाइल सूची लिखी जाएगी। "lf5" निर्देशिका Windows 2000 मशीनों पर Documents और Settings निर्देशिका में बनाई जाती है और सभी अन्य प्लेटफार्मों पर जहाँ भी user.home वेरिएबल इंगित करता है।
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        String directoryPath;

        if (osName.contains("win") && osName.contains("2000")) {
            directoryPath = System.getenv("USERPROFILE") + "\\Documents and Settings\\lf5";
        } else {
            directoryPath = userHome + File.separator + "lf5";
        }

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Configuration directory created at: " + directoryPath);
            } else {
                System.out.println("Failed to create configuration directory at: " + directoryPath);
            }
        } else {
            System.out.println("Configuration directory already exists at: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}