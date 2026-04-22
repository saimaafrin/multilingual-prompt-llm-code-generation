import java.util.UUID;

public class EntityIdGenerator {

    /**
     * Generates a unique row ID based on the provided entity ID.
     * 
     * @param entityId the entity ID to be used in generating the row ID
     * @return the row ID as a String
     */
    public String id(String entityId) {
        // Concatenate the entity ID with a UUID to ensure uniqueness
        String uniqueId = entityId + "-" + UUID.randomUUID().toString();
        return uniqueId;
    }

    public static void main(String[] args) {
        EntityIdGenerator generator = new EntityIdGenerator();
        String entityId = "exampleEntity";
        String rowId = generator.id(entityId);
        System.out.println("Generated Row ID: " + rowId);
    }
}