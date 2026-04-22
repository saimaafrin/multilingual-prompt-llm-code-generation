public class BooleanUtils {

    /** 
     * <p>检查一个 <code>Boolean</code> 值是否 <i>不</i> 为 <code>true</code>，对于 <code>null</code> 的处理是返回 <code>true</code>。</p> 
     * <pre> 
     *  BooleanUtils.isNotTrue(Boolean.TRUE)  = false 
     *  BooleanUtils.isNotTrue(Boolean.FALSE) = true 
     *  BooleanUtils.isNotTrue(null)          = true 
     * </pre>
     * @param bool  要检查的布尔值，如果为空则返回 <code>true</code>
     * @return 如果输入为空或假，则返回 <code>true</code>
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return bool == null || !bool;
    }

    public static void main(String[] args) {
        System.out.println(isNotTrue(Boolean.TRUE));  // false
        System.out.println(isNotTrue(Boolean.FALSE)); // true
        System.out.println(isNotTrue(null));           // true
    }
}