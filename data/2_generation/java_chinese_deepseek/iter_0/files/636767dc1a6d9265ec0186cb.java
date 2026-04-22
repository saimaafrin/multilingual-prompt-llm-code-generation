import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * 初始化配置，例如检查分发路径
     */
    public void init() {
        // 假设分发路径为 "/path/to/distribution"
        Path distributionPath = Paths.get("/path/to/distribution");

        // 检查路径是否存在
        if (Files.exists(distributionPath)) {
            System.out.println("分发路径存在: " + distributionPath);
        } else {
            System.out.println("分发路径不存在: " + distributionPath);
            // 可以选择创建路径
            try {
                Files.createDirectories(distributionPath);
                System.out.println("已创建分发路径: " + distributionPath);
            } catch (Exception e) {
                System.err.println("无法创建分发路径: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}