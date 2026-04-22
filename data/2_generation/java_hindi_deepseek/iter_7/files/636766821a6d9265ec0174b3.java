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
        // For example, you can check the type of msg and perform actions accordingly
        if (msg instanceof Intent) {
            Intent intent = (Intent) msg;
            // Perform some action based on the intent
            return intent.getAction();
        }
        return null;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // You can call the filter method here if needed
        Object result = filter(intent);
        // Handle the result as needed
    }
}