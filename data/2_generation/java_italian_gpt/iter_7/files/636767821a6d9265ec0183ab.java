public class Example {
    
    private Throwable thrown;

    /** 
     * @return true se getThrown().toString() è una stringa non vuota.
     */
    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public Throwable getThrown() {
        return thrown;
    }

    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.setThrown(new Exception("An error occurred"));
        System.out.println(example.hasThrown()); // Output: true

        example.setThrown(null);
        System.out.println(example.hasThrown()); // Output: false
    }
}