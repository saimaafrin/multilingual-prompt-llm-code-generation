import java.util.UUID;

public class EntityIdentifier {
    
    /**
     * @return the row id
     */
    public String id(String entityId) {
        if (entityId == null || entityId.trim().isEmpty()) {
            return UUID.randomUUID().toString();
        }
        return entityId.trim();
    }
}