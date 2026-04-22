import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardKeyChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        // 假设分片键的格式为 "shard_<index>"
        Pattern pattern = Pattern.compile("shard_(\\d+)");
        Matcher matcher = pattern.matcher(modelName);

        if (!matcher.find()) {
            throw new IllegalStateException("Invalid model name format: " + modelName);
        }

        int currentIndex = Integer.parseInt(matcher.group(1));
        int expectedIndex = getExpectedShardIndex(modelName);

        if (currentIndex != expectedIndex) {
            throw new IllegalStateException("Shard key index is not continuous. Expected: " + expectedIndex + ", Found: " + currentIndex);
        }
    }

    private int getExpectedShardIndex(String modelName) {
        // 这里假设有一个方法来获取预期的分片键索引
        // 例如，从数据库或其他存储中获取最后一个分片键索引并加1
        // 这里只是一个示例，返回一个固定值
        return 1; // 假设预期的索引是1
    }

    public static void main(String[] args) {
        ShardKeyChecker checker = new ShardKeyChecker();
        try {
            checker.check("shard_1");
            System.out.println("Shard key index is continuous.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}