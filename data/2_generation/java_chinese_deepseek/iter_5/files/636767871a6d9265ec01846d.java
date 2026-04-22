import java.io.File;

public class MRUDirectoryCreator {

    /**
     * 创建将要写入MRU文件列表的目录。在Windows 2000机器上，"lf5"目录会在“文档和设置”目录中创建，而在其他平台上则会在user.home变量指向的位置创建。
     */
    public static void createConfigurationDirectory() {
        String osName = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        String configDirPath;

        if (osName.contains("windows 2000")) {
            // 对于Windows 2000，假设“文档和设置”目录在C盘
            configDirPath = "C:\\Documents and Settings\\" + System.getProperty("user.name") + "\\lf5";
        } else {
            // 对于其他平台，使用user.home目录
            configDirPath = userHome + File.separator + "lf5";
        }

        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Configuration directory created at: " + configDirPath);
            } else {
                System.out.println("Failed to create configuration directory at: " + configDirPath);
            }
        } else {
            System.out.println("Configuration directory already exists at: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}