public class StringUtils {

    /**
     * 如果给定的对象是字符串，则将其转换为带单引号的字符串；否则保持对象不变。
     * @param obj 输入对象（例如："myString"）
     * @return 带引号的字符串（例如："‘myString’"），如果不是字符串，则返回输入对象本身
     */
    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(quoteIfString("myString")); // 输出: 'myString'
        System.out.println(quoteIfString(123));       // 输出: 123
        System.out.println(quoteIfString(null));       // 输出: null
    }
}