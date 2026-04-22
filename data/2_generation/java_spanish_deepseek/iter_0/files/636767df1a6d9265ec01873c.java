import java.util.UUID;

public class Example {
    /**
     * @param entityId the entity ID to be used in generating the row ID
     * @return the ID of the row
     */
    public String id(String entityId) {
        // Generate a unique row ID by combining the entity ID with a UUID
        return entityId + "-" + UUID.randomUUID().toString();
    }
}