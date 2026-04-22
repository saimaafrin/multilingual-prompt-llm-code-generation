import com.google.gson.JsonObject;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentBuilder {

    /**
     * 构建内容，如果包含 @ 某人，则设置 @ 信息。
     */
    private Map<String,Object> buildContent(JsonObject jsonObject) {
        Map<String,Object> content = new HashMap<>();
        
        if (jsonObject == null) {
            return content;
        }

        // 获取消息内容
        String message = jsonObject.has("content") ? 
                        jsonObject.get("content").getAsString() : "";
        
        content.put("content", message);

        // 解析@信息
        List<String> atList = new ArrayList<>();
        Pattern pattern = Pattern.compile("@([\\w\\-]+)");
        Matcher matcher = pattern.matcher(message);
        
        while (matcher.find()) {
            String atUser = matcher.group(1);
            atList.add(atUser);
        }
        
        if (!atList.isEmpty()) {
            content.put("mentions", atList);
        }

        return content;
    }
}