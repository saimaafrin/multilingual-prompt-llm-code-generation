import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * 调用 {@link BroadcastFilter}
 * @param msg 要过滤的消息
 * @return 过滤后的消息
 */
protected Object filter(Object msg) {
    // 假设msg是一个Intent对象
    if (msg instanceof Intent) {
        Intent intent = (Intent) msg;
        Bundle extras = intent.getExtras();
        
        // 这里可以添加自定义的过滤逻辑
        if (extras != null && extras.containsKey("key_to_filter")) {
            // 如果包含特定的key，则返回过滤后的消息
            return "Filtered Message";
        }
    }
    
    // 如果没有过滤条件，则返回原始消息
    return msg;
}