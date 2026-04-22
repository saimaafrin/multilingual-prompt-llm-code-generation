public class Bucket {
    // Assuming Bucket has some properties and methods
    private String data;
    private Bucket next;

    public Bucket(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }

    /**
     * Inserta este "bucket" en la estructura de datos antes del {@code bucket}.
     * @param bucket el "bucket", que será el siguiente a este "bucket".
     */
    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("El bucket no puede ser nulo");
        }

        // Create a new bucket to insert
        Bucket newBucket = new Bucket(this.data);
        
        // Find the previous bucket
        Bucket current = this;
        while (current.next != null && current.next != bucket) {
            current = current.next;
        }

        // Insert the new bucket before the specified bucket
        newBucket.next = bucket;
        current.next = newBucket;
    }
}