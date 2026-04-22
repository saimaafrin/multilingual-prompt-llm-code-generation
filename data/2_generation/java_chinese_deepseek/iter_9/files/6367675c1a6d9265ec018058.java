import java.util.function.Supplier;

public class StringSupplier {
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
        Supplier<String> supplier = createStringSupplier(5);
        System.out.println(supplier.get()); // 输出: 5
        System.out.println(supplier.get()); // 输出: 6
        System.out.println(supplier.get()); // 输出: 7
    }
}