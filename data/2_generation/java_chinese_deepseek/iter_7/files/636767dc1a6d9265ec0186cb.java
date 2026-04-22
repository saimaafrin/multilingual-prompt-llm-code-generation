import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * 初始化配置，例如检查分发路径
     */
    public void init() {
        // 假设分发路径为 "dist"
        Path distPath = Paths.get("dist");

        // 检查路径是否存在
        if (!Files.exists(distPath)) {
            System.out.println("分发路径不存在，正在创建...");
            try {
                Files.createDirectories(distPath);
                System.out.println("分发路径创建成功。");
            } catch (Exception e) {
                System.err.println("创建分发路径时出错: " + e.getMessage());
            }
        } else {
            System.out.println("分发路径已存在。");
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}