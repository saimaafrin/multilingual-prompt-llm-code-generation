import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // 假设我们有一个方法来获取所有分片键的索引
        int[] shardIndices = getAllShardIndices(baseName);

        // 检查分片键索引是否连续
        for (int i = 0; i < shardIndices.length; i++) {
            if (shardIndices[i] != i) {
                throw new IllegalStateException("Shard indices are not continuous for model: " + baseName);
            }
        }
    }

    // 假设这个方法返回所有分片键的索引
    private int[] getAllShardIndices(String baseName) {
        // 这里应该是从数据库或其他存储中获取所有分片键的索引
        // 这里我们返回一个示例数组
        return new int[]{0, 1, 2, 3};
    }

    public static void main(String[] args) {
        ShardKeyChecker checker = new ShardKeyChecker();
        try {
            checker.check("exampleModel_2");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}