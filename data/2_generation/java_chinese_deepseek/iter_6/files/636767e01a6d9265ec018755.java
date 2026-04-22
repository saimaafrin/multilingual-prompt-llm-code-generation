import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

public class ContentBuilder {

    /**
     * 构建内容，如果包含 @ 某人，则设置 @ 信息。
     *
     * @param jsonObject 包含内容的JSON对象
     * @return 包含构建内容的Map
     */
    private Map<String, Object> buildContent(JsonObject jsonObject) {
        Map<String, Object> contentMap = new HashMap<>();

        // 假设JSON对象中有一个字段 "content" 包含文本内容
        String content = jsonObject.get("content").getAsString();

        // 检查内容中是否包含 "@" 符号
        if (content.contains("@")) {
            // 提取 "@" 后面的用户名
            String[] parts = content.split("@");
            if (parts.length > 1) {
                String mentionedUser = parts[1].split("\\s+")[0]; // 获取第一个空格前的部分
                contentMap.put("mentionedUser", mentionedUser);
            }
        }

        // 将原始内容放入Map
        contentMap.put("content", content);

        return contentMap;
    }
}