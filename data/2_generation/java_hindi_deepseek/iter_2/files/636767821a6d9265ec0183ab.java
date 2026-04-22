import java.util.Objects;

public class Example {
    private Throwable thrown;

    public Example(Throwable thrown) {
        this.thrown = thrown;
    }

    public Throwable getThrown() {
        return thrown;
    }

    /**
     * @return यदि getThrown().toString() एक गैर-खाली स्ट्रिंग है तो true लौटाता है।
     */
    public boolean hasThrown() {
        return thrown != null && !Objects.toString(thrown).isEmpty();
    }

    public static void main(String[] args) {
        Example example = new Example(new RuntimeException("Error occurred"));
        System.out.println(example.hasThrown()); // Output: true
    }
}