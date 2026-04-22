import java.util.function.Supplier;

public class StringSupplier {
    private int current;

    public StringSupplier(int start) {
        this.current = start;
    }

    public String get() {
        return String.valueOf(current++);
    }

    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        StringSupplier supplier = new StringSupplier(start);
        return supplier::get;
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(5);
        System.out.println(supplier.get()); // Output: 5
        System.out.println(supplier.get()); // Output: 6
        System.out.println(supplier.get()); // Output: 7
    }
}