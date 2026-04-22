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
        UniqueStringSupplier supplier = new UniqueStringSupplier(start);
        return supplier::get;
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(10);
        System.out.println(supplier.get()); // 10
        System.out.println(supplier.get()); // 11
        System.out.println(supplier.get()); // 12
    }
}