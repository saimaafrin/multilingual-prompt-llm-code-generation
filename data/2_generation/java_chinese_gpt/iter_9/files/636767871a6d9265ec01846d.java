import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * 创建将要写入MRU文件列表的目录。在Windows 2000机器上，"lf5"目录会在“文档和设置”目录中创建，而在其他平台上则会在user.home变量指向的位置创建。
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        String directoryPath;

        if (osName.contains("windows") && osName.contains("2000")) {
            directoryPath = System.getenv("USERPROFILE") + "\\lf5";
        } else {
            directoryPath = userHome + File.separator + "lf5";
        }

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory already exists: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}