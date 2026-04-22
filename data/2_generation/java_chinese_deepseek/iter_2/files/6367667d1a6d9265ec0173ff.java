import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor is a class with some properties and methods
    // For the sake of this example, let's assume it has a default constructor
    public Meteor() {
        // Constructor logic here
    }
}

public class MeteorLookupUtil {

    /**
     * 根据 {@link HttpServletRequest} 获取 {@link Meteor} 的实例。
     * @param r {@link HttpServletRequest}
     * @return 一个 {@link Meteor} 实例，如果未找到则返回空
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming the Meteor instance is stored as an attribute in the request
        Object meteorObj = r.getAttribute("meteor");

        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        } else {
            return null;
        }
    }
}