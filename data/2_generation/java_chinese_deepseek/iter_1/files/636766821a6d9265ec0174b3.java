import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastFilter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the broadcast message here
        Object msg = intent.getSerializableExtra("msg");
        filter(msg);
    }

    /**
     * 调用 {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        // Implement your filtering logic here
        // For example, you can check the message content and decide whether to process it or not
        if (msg != null) {
            // Process the message
            System.out.println("Filtered message: " + msg.toString());
            return msg;
        } else {
            System.out.println("No message to filter.");
            return null;
        }
    }
}