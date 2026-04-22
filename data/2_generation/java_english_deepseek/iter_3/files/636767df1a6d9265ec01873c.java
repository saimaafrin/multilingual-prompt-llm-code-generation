import java.util.UUID;

public class EntityIdGenerator {

    /**
     * Generates a unique row ID based on the provided entity ID.
     * 
     * @param entityId the entity ID to be used in generating the row ID
     * @return the row ID as a String
     */
    public String id(String entityId) {
        // Combine the entityId with a UUID to ensure uniqueness
        String uniqueId = entityId + "-" + UUID.randomUUID().toString();
        return uniqueId;
    }
}