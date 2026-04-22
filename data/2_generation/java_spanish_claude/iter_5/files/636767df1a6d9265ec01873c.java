import java.util.UUID;

public class EntityIdentifier {

    /**
     * @return el id de la fila
     */
    public String id(String entityId) {
        if (entityId == null || entityId.trim().isEmpty()) {
            return UUID.randomUUID().toString();
        }
        return entityId.trim();
    }

}