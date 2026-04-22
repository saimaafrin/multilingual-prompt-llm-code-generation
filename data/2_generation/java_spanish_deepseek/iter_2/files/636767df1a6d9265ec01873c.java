import java.util.UUID;

public class Main {
    /**
     * Generates a unique row ID based on the provided entity ID.
     * 
     * @param entityId The entity ID to be used in generating the row ID.
     * @return The generated row ID as a String.
     */
    public static String id(String entityId) {
        // Concatenate the entity ID with a UUID to ensure uniqueness
        return entityId + "_" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        // Example usage
        String entityId = "user123";
        String rowId = id(entityId);
        System.out.println("Generated Row ID: " + rowId);
    }
}