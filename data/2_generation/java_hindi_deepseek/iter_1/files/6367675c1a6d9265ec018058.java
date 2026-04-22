import java.util.function.Supplier;

public class UniqueStringSupplier {

    private int counter;

    public UniqueStringSupplier(int start) {
        this.counter = start;
    }

    public Supplier<String> createStringSupplier() {
        return () -> {
            String uniqueString = Integer.toString(counter);
            counter++;
            return uniqueString;
        };
    }

    public static void main(String[] args) {
        UniqueStringSupplier supplier = new UniqueStringSupplier(10);
        Supplier<String> stringSupplier = supplier.createStringSupplier();

        System.out.println(stringSupplier.get()); // Output: 10
        System.out.println(stringSupplier.get()); // Output: 11
        System.out.println(stringSupplier.get()); // Output: 12
    }
}