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
        // For example, you can check if the message is of a certain type
        // and return a filtered result accordingly.
        if (msg instanceof String) {
            String message = (String) msg;
            if (message.contains("filter")) {
                return "Filtered: " + message;
            }
        }
        return msg;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the broadcast here
        Object msg = intent.getSerializableExtra("message");
        Object filteredMsg = filter(msg);
        // You can now use the filtered message as needed
    }
}