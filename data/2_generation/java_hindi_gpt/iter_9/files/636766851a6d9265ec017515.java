import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class MyAtmosphereHandler {

    /**
     * {@link AtmosphereResource} को {@link AtmosphereResource.TRANSPORT} मान के आधार पर स्वचालित रूप से निलंबित करें।
     * @param r एक {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        if (r.getTransport() != null) {
            // Logic to suspend the resource based on the transport type
            // For example, if the transport is "LONG_POLLING", we can suspend it
            if (r.getTransport().equals(AtmosphereResource.TRANSPORT.LONG_POLLING)) {
                r.suspend();
            }
        }
        return Action.CONTINUE;
    }
}