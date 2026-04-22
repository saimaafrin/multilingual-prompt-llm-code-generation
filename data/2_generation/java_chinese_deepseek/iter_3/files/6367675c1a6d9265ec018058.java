import java.util.function.Supplier;

public class StringSupplierExample {

    /**
     * 创建一个字符串供应者，该供应者返回唯一的字符串。返回的字符串实际上是从起始值开始的整数。
     * @param start 序列的起始值
     * @return 一个字符串供应者
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        return new Supplier<String>() {
            private int current = start;

            @Override
            public String get() {
                return String.valueOf(current++);
            }
        };
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(10);
        System.out.println(supplier.get()); // 输出: 10
        System.out.println(supplier.get()); // 输出: 11
        System.out.println(supplier.get()); // 输出: 12
    }
}