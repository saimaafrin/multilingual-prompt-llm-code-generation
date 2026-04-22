import java.util.function.Supplier;

public class StringSupplier {
    /**
     * 创建一个字符串供应者，该供应者返回唯一的字符串。返回的字符串实际上是从起始值开始的整数。
     * @param start 序列的起始值
     * @return 一个字符串供应者
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        final int[] current = {start}; // 使用数组来保持可变性
        return () -> Integer.toString(current[0]++);
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(5);
        System.out.println(supplier.get()); // 输出: 5
        System.out.println(supplier.get()); // 输出: 6
        System.out.println(supplier.get()); // 输出: 7
    }
}