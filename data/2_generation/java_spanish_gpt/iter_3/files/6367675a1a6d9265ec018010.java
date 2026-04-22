public class Bucket {
    // Assuming there is a structure to hold the bucket's data
    private Object data; // Replace Object with the actual data type
    private Bucket next; // Reference to the next bucket in the structure

    public Bucket(Object data) {
        this.data = data;
        this.next = null;
    }

    /** 
     * Elimina este bucket de la estructura de datos.
     */
    void removeSelf() {
        if (this.next != null) {
            this.data = this.next.data;
            this.next = this.next.next;
        } else {
            this.data = null; // Clear the data
            // Optionally, handle the case where this is the last bucket
        }
    }
}