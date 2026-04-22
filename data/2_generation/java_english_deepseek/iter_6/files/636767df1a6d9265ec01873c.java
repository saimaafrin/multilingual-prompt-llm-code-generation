public class EntityIdHandler {

    /**
     * @param entityId the entity id to process
     * @return the row id
     */
    public String id(String entityId) {
        // Assuming the row id is derived from the entityId by some logic
        // For example, extracting a substring or applying a transformation
        // Here, we simply return the entityId as the row id for demonstration purposes
        return entityId;
    }

    public static void main(String[] args) {
        EntityIdHandler handler = new EntityIdHandler();
        String entityId = "exampleEntityId123";
        String rowId = handler.id(entityId);
        System.out.println("Row ID: " + rowId);
    }
}