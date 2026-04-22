import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * 初始化配置，例如检查分发路径
     */
    public void init() {
        // 假设分发路径为 "dist"
        String distributionPath = "dist";
        Path path = Paths.get(distributionPath);

        // 检查路径是否存在
        if (Files.exists(path)) {
            System.out.println("分发路径存在: " + path.toAbsolutePath());
        } else {
            System.out.println("分发路径不存在，创建路径: " + path.toAbsolutePath());
            try {
                Files.createDirectories(path);
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