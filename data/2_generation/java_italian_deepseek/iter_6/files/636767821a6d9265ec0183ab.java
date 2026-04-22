public class Example {
    /**
     * @return true se getThrown().toString() è una stringa non vuota.
     */
    public boolean hasThrown() {
        String thrownString = getThrown().toString();
        return !thrownString.isEmpty();
    }

    // Dummy implementation of getThrown() for demonstration purposes
    private Object getThrown() {
        // This is a placeholder. Replace with actual logic to get the thrown object.
        return new Object(); // Example: return an object with a non-empty toString()
    }

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.hasThrown());
    }
}