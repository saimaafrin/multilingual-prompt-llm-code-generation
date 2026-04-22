import java.util.function.Supplier;

public class StringSupplier {
    private int current;

    public StringSupplier(int start) {
        this.current = start;
    }

    public String get() {
        return String.valueOf(current++);
    }

    public static Supplier<String> createStringSupplier(int start) {
        StringSupplier supplier = new StringSupplier(start);
        return supplier::get;
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(10);
        System.out.println(supplier.get()); // 输出 "10"
        System.out.println(supplier.get()); // 输出 "11"
        System.out.println(supplier.get()); // 输出 "12"
    }
}