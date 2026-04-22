import java.util.UUID;

public class Main {
    /**
     * @param entityId the entity identifier
     * @return the row ID
     */
    public static String id(String entityId) {
        // Generate a unique row ID based on the entity ID
        return entityId + "-" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        // Example usage
        String entityId = "exampleEntity";
        String rowId = id(entityId);
        System.out.println("Generated Row ID: " + rowId);
    }
}