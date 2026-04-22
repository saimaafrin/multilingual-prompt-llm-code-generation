import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastFilter extends BroadcastReceiver {

    /**
     * {@link BroadcastFilter} को कॉल करें
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        // Implement your filtering logic here
        // For example, you can check the type of msg and return a filtered result
        if (msg instanceof String) {
            String message = (String) msg;
            // Example: Filter out messages containing "test"
            if (message.contains("test")) {
                return null; // Filter out the message
            }
        }
        return msg; // Return the original message if no filtering is needed
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the broadcast here
        Object msg = intent.getSerializableExtra("message");
        Object filteredMsg = filter(msg);
        if (filteredMsg != null) {
            // Process the filtered message
        }
    }
}