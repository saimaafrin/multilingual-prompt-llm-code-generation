public class Example {
    private Throwable thrown;

    public Example(Throwable thrown) {
        this.thrown = thrown;
    }

    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        Example example = new Example(new RuntimeException("Error occurred"));
        System.out.println(example.hasThrown()); // Output: true

        Example example2 = new Example(null);
        System.out.println(example2.hasThrown()); // Output: false
    }
}