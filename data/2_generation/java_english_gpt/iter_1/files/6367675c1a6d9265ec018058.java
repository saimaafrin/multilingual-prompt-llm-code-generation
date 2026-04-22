import java.util.function.Supplier;

public class UniqueStringSupplier {

    /**
     * Create a string supplier which returns unique strings. The returns strings are simply integers starting from start.
     * @param start where to start the sequence
     * @return a string supplier
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        final int[] current = {start}; // Using an array to hold the current value

        return () -> {
            return String.valueOf(current[0]++); // Return the current value and increment
        };
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(5);
        System.out.println(supplier.get()); // Outputs: 5
        System.out.println(supplier.get()); // Outputs: 6
        System.out.println(supplier.get()); // Outputs: 7
    }
}