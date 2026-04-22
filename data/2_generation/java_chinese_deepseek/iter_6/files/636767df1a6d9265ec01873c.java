import java.util.UUID;

public class EntityIdGenerator {

    /**
     * Generates a unique ID for an entity.
     * 
     * @param entityId The entity identifier (not used in this implementation).
     * @return A unique ID as a String.
     */
    public String id(String entityId) {
        // Generate a random UUID and convert it to a string
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        EntityIdGenerator generator = new EntityIdGenerator();
        String uniqueId = generator.id("exampleEntityId");
        System.out.println("Generated ID: " + uniqueId);
    }
}