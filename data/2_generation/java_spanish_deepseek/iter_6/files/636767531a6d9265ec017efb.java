class Bucket {
    Bucket next;

    // Constructor and other methods can be added here

    /**
     * Inserta este "bucket" en la estructura de datos antes del {@code bucket}.
     * @param bucket el "bucket", que será el siguiente a este "bucket".
     */
    void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("El bucket no puede ser nulo");
        }

        // Guardar la referencia al siguiente bucket del bucket dado
        Bucket nextBucket = bucket.next;

        // Hacer que el bucket dado apunte a este bucket
        bucket.next = this;

        // Hacer que este bucket apunte al siguiente bucket del bucket dado
        this.next = nextBucket;
    }
}