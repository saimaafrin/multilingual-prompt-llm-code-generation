import java.io.File;

public class DirectoryCreator {
    
    public void createMRUDirectoryIfNeeded() {
        String userHome = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String os = System.getProperty("os.name").toLowerCase();
        
        String mruDirectory;
        
        // Check if Windows 2000
        if (os.contains("windows") && os.contains("2000")) {
            mruDirectory = System.getenv("USERPROFILE") + fileSeparator + 
                          "Documents and Settings" + fileSeparator + "lf5";
        } else {
            mruDirectory = userHome + fileSeparator + "lf5";
        }
        
        File directory = new File(mruDirectory);
        
        // Create directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}