import java.util.Optional;

public class Example {

    private Optional<Throwable> thrown;

    public Example(Optional<Throwable> thrown) {
        this.thrown = thrown;
    }

    /**
     * @return true if getThrown().toString() is a non-empty string.
     */
    public boolean hasThrown() {
        return thrown.isPresent() && !thrown.get().toString().isEmpty();
    }

    public Optional<Throwable> getThrown() {
        return thrown;
    }

    public static void main(String[] args) {
        // Example usage
        Example example1 = new Example(Optional.of(new RuntimeException("Error occurred")));
        System.out.println(example1.hasThrown()); // true

        Example example2 = new Example(Optional.empty());
        System.out.println(example2.hasThrown()); // false
    }
}