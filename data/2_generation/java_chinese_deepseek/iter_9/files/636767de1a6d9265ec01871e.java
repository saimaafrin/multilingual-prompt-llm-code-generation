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

        // 检查分片键索引是否连续
        // 这里假设有一个方法来获取下一个分片键的索引
        int nextShardIndex = getNextShardIndex(baseName);

        if (nextShardIndex != shardIndex + 1) {
            throw new IllegalStateException("Shard key index is not continuous: " + modelName);
        }
    }

    // 假设这个方法用于获取下一个分片键的索引
    private int getNextShardIndex(String baseName) {
        // 这里应该实现获取下一个分片键索引的逻辑
        // 例如从数据库或缓存中获取
        // 这里返回一个假设值
        return 1; // 假设下一个分片键的索引是1
    }

    public static void main(String[] args) {
        ShardKeyChecker checker = new ShardKeyChecker();
        try {
            checker.check("model_0");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}