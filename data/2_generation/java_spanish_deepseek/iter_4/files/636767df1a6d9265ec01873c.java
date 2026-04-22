import java.util.UUID;

public class Example {

    /**
     * Generates a unique ID for a row based on the provided entity ID.
     * 
     * @param entityId The ID of the entity to generate a row ID for.
     * @return The generated row ID as a String.
     */
    public String id(String entityId) {
        // Concatenate the entity ID with a UUID to ensure uniqueness
        return entityId + "-" + UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        Example example = new Example();
        String rowId = example.id("entity123");
        System.out.println("Generated Row ID: " + rowId);
    }
}