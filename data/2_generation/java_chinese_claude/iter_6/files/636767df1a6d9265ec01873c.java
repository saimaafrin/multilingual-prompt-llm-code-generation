import java.util.UUID;

public class EntityIdGenerator {
    /**
     * @return 行 ID
     */
    public String id(String entityId) {
        if (entityId == null || entityId.trim().isEmpty()) {
            return UUID.randomUUID().toString().replace("-", "");
        }
        return entityId;
    }
}