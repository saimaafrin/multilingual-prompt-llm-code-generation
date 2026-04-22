import org.apache.camel.BroadcastFilter;

public class MyBroadcastFilter {

    /** 
     * Invoke the  {@link BroadcastFilter}
     * @param msg
     * @return
     */
    protected Object filter(Object msg) {
        BroadcastFilter broadcastFilter = new BroadcastFilter();
        // Assuming some filtering logic is applied here
        return broadcastFilter.filter(msg);
    }
}