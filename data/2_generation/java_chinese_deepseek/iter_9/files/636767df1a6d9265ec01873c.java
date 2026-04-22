import java.util.UUID;

public class EntityIdGenerator {
    /**
     * Generates a unique row ID based on the provided entity ID.
     *
     * @param entityId The entity ID to be used in generating the row ID.
     * @return A unique row ID as a String.
     */
    public String id(String entityId) {
        // Concatenate the entity ID with a UUID to ensure uniqueness
        return entityId + "-" + UUID.randomUUID().toString();
    }
}