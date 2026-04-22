import java.util.function.Supplier;

public class UniqueStringSupplier {
    private int current;

    public UniqueStringSupplier(int start) {
        this.current = start;
    }

    public String get() {
        return String.valueOf(current++);
    }

    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        return new UniqueStringSupplier(start)::get;
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(10);
        System.out.println(supplier.get()); // Output: 10
        System.out.println(supplier.get()); // Output: 11
        System.out.println(supplier.get()); // Output: 12
    }
}