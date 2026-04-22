import java.util.UUID;

public class Main {
    /**
     * @param entityId the entity ID to generate a row ID for
     * @return the generated row ID as a string
     */
    public static String id(String entityId) {
        // Concatenate the entityId with a UUID to create a unique row ID
        return entityId + "-" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        // Example usage
        String entityId = "exampleEntity";
        String rowId = id(entityId);
        System.out.println("Generated Row ID: " + rowId);
    }
}