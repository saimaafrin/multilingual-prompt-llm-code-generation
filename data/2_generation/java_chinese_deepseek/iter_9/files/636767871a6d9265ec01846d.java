import java.io.File;

public class MRUDirectoryCreator {

    /**
     * 创建将要写入MRU文件列表的目录。在Windows 2000机器上，"lf5"目录会在“文档和设置”目录中创建，而在其他平台上则会在user.home变量指向的位置创建。
     */
    public static void createConfigurationDirectory() {
        String osName = System.getProperty("os.name").toLowerCase();
        String directoryPath;

        if (osName.contains("windows 2000")) {
            // 对于Windows 2000，假设“文档和设置”目录在C盘
            directoryPath = "C:\\Documents and Settings\\" + System.getProperty("user.name") + "\\lf5";
        } else {
            // 对于其他平台，使用user.home变量指向的位置
            directoryPath = System.getProperty("user.home") + File.separator + "lf5";
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