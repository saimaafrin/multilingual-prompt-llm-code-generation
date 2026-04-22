import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * 初始化配置，例如检查分发路径
     */
    public void init() {
        // 假设分发路径为 "/path/to/distribution"
        String distributionPath = "/path/to/distribution";
        Path path = Paths.get(distributionPath);

        // 检查路径是否存在
        if (Files.exists(path)) {
            System.out.println("分发路径存在: " + distributionPath);
        } else {
            System.out.println("分发路径不存在: " + distributionPath);
            // 可以在这里创建路径或抛出异常
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}