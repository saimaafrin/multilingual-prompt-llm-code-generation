import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardKeyChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        // 假设分片键的格式为 "modelName_shardIndex"
        Pattern pattern = Pattern.compile("(.+)_(\\d+)");
        Matcher matcher = pattern.matcher(modelName);

        if (!matcher.matches()) {
            throw new IllegalStateException("Invalid model name format: " + modelName);
        }

        String baseName = matcher.group(1);
        int shardIndex = Integer.parseInt(matcher.group(2));

        // 假设我们有一个方法来获取当前分片的总数
        int totalShards = getTotalShards(baseName);

        // 检查分片索引是否连续
        if (shardIndex < 0 || shardIndex >= totalShards) {
            throw new IllegalStateException("Shard index is out of bounds: " + shardIndex);
        }

        // 这里可以添加更多的逻辑来检查分片键的连续性
        // 例如，检查是否存在缺失的分片索引
    }

    // 假设这个方法返回给定模型名称的总分片数
    private int getTotalShards(String baseName) {
        // 这里只是一个示例，实际实现可能依赖于具体的业务逻辑
        return 10; // 假设总共有10个分片
    }

    public static void main(String[] args) {
        ShardKeyChecker checker = new ShardKeyChecker();
        try {
            checker.check("model_5");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}