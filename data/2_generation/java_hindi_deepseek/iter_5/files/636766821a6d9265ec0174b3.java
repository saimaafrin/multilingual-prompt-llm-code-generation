import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastFilter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the broadcast
    }

    protected Object filter(Object msg) {
        // Implement your filtering logic here
        // For example, you can check the message and decide whether to process it or not
        if (msg instanceof String) {
            String message = (String) msg;
            if (message.contains("important")) {
                return message; // Return the message if it contains the word "important"
            }
        }
        return null; // Return null if the message does not meet the criteria
    }
}