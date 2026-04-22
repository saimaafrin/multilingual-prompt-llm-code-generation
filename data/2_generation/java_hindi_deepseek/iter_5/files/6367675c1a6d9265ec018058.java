import java.util.function.Supplier;

public class UniqueStringSupplier {

    private int current;

    public UniqueStringSupplier(int start) {
        this.current = start;
    }

    public Supplier<String> createStringSupplier() {
        return () -> {
            String result = Integer.toString(current);
            current++;
            return result;
        };
    }

    public static void main(String[] args) {
        UniqueStringSupplier supplier = new UniqueStringSupplier(10);
        Supplier<String> stringSupplier = supplier.createStringSupplier();

        System.out.println(stringSupplier.get()); // Output: "10"
        System.out.println(stringSupplier.get()); // Output: "11"
        System.out.println(stringSupplier.get()); // Output: "12"
    }
}