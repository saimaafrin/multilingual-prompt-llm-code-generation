import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * 根据 {@link HttpServletRequest} 获取 {@link Meteor} 的实例。
     * @param r {@link HttpServletRequest}
     * @return 一个 {@link Meteor} 实例，如果未找到则返回空
     */
    public static Meteor lookup(HttpServletRequest r) {
        // 假设 Meteor 实例存储在请求属性中
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        return null;
    }
}

// 假设 Meteor 类已经定义
class Meteor {
    // Meteor 类的具体实现
}