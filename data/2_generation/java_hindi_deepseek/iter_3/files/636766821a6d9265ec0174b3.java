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
        // For example, you can check if the message meets certain criteria
        if (msg instanceof String) {
            String message = (String) msg;
            if (message.contains("important")) {
                return message; // Return the message if it contains the word "important"
            }
        }
        return null; // Return null if the message does not meet the criteria
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // You can call the filter method here if needed.
        Object msg = intent.getSerializableExtra("message");
        Object filteredMsg = filter(msg);
        if (filteredMsg != null) {
            // Handle the filtered message
        }
    }
}