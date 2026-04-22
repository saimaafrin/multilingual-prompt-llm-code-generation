import com.google.gson.JsonObject;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

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
        String text = jsonObject.has("text") ? jsonObject.get("text").getAsString() : "";
        content.put("text", text);

        // 处理@信息
        if (text.contains("@")) {
            List<Map<String,String>> atList = new ArrayList<>();
            
            // 解析@的用户
            String[] parts = text.split("@");
            for (int i = 1; i < parts.length; i++) {
                String name = parts[i].split("\\s+")[0];
                if (!name.isEmpty()) {
                    Map<String,String> atInfo = new HashMap<>();
                    atInfo.put("name", name);
                    atList.add(atInfo);
                }
            }
            
            if (!atList.isEmpty()) {
                content.put("at", atList);
            }
        }

        return content;
    }
}