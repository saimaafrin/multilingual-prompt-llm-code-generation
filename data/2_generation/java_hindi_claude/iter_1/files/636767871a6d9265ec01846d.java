import java.io.File;

public class DirectoryCreator {
    
    public void createMRUDirectoryIfNeeded() {
        String userHome = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String os = System.getProperty("os.name").toLowerCase();
        
        File mruDirectory;
        
        if (os.contains("windows") && os.contains("2000")) {
            // For Windows 2000, create in Documents and Settings
            mruDirectory = new File(userHome + fileSeparator + 
                "Documents and Settings" + fileSeparator + "lf5");
        } else {
            // For all other platforms, create in user home directory
            mruDirectory = new File(userHome + fileSeparator + "lf5");
        }

        // Create directory if it doesn't exist
        if (!mruDirectory.exists()) {
            mruDirectory.mkdirs();
        }
    }
}