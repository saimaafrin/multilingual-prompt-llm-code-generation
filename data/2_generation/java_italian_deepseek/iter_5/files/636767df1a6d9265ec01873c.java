public class EntityIdHandler {

    /**
     * @param entityId the entity ID to process
     * @return the ID of the row
     */
    public String id(String entityId) {
        // Assuming the entityId is already the row ID or needs to be processed
        // For example, if the entityId is in the format "row-123", we extract "123"
        // This is just a placeholder implementation
        if (entityId != null && entityId.startsWith("row-")) {
            return entityId.substring(4);
        }
        return entityId; // Return the entityId as is if no processing is needed
    }

    public static void main(String[] args) {
        EntityIdHandler handler = new EntityIdHandler();
        String entityId = "row-123";
        String rowId = handler.id(entityId);
        System.out.println("Row ID: " + rowId);
    }
}