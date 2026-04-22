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
        // This is a placeholder. Replace with actual logic.
        return new Object() {
            @Override
            public String toString() {
                return "Example thrown object";
            }
        };
    }

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.hasThrown()); // Output: true
    }
}