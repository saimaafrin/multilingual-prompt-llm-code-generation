import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;

public class MeteorLookup {

    /**
     * 根据 {@link HttpServletRequest} 获取 {@link Meteor} 的实例。
     * @param r {@link HttpServletRequest}
     * @return 一个 {@link Meteor} 实例，如果未找到则返回空
     */
    public static Meteor lookup(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        // Try to get existing Meteor instance
        Meteor meteor = (Meteor) r.getAttribute(Meteor.class.getName());
        
        if (meteor != null) {
            return meteor;
        }
        
        // Try to get from AtmosphereResource
        AtmosphereResource resource = (AtmosphereResource) 
            r.getAttribute(AtmosphereResource.class.getName());
            
        if (resource != null) {
            return Meteor.build(resource);
        }
        
        return null;
    }
}