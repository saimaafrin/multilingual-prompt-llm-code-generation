import java.util.UUID;

public class Main {
    /**
     * Generates a unique row ID based on the given entity ID.
     * 
     * @param entityId The entity ID to be used in generating the row ID.
     * @return A unique row ID as a String.
     */
    public static String id(String entityId) {
        // Concatenate the entity ID with a UUID to ensure uniqueness
        return entityId + "-" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        // Example usage
        String entityId = "exampleEntity";
        String rowId = id(entityId);
        System.out.println("Generated Row ID: " + rowId);
    }
}