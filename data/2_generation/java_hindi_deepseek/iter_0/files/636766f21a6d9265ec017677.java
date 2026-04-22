/**
 * <p>जांचता है कि <code>Boolean</code> मान <i>नहीं</i> है <code>true</code>, <code>null</code> को संभालते हुए <code>true</code> लौटाता है।</p> <pre> BooleanUtils.isNotTrue(Boolean.TRUE)  = false BooleanUtils.isNotTrue(Boolean.FALSE) = true BooleanUtils.isNotTrue(null)          = true </pre>
 * @param bool  वह बूलियन जिसे जांचना है, null <code>true</code> लौटाता है
 * @return <code>true</code> यदि इनपुट null या false है
 * @since 2.3
 */
public class BooleanUtils {

    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));  // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));          // true
    }
}