import java.util.UUID;

public class EntityIdentifier {
    /**
     * @return l'id della riga
     */
    public String id(String entityId) {
        if (entityId == null || entityId.trim().isEmpty()) {
            return UUID.randomUUID().toString();
        }
        return entityId.trim();
    }
}