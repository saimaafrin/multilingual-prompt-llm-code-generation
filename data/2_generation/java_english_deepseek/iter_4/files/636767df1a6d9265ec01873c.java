public class EntityIdHandler {

    /**
     * @param entityId the entity id to process
     * @return the row id
     */
    public String id(String entityId) {
        // Assuming the row id is derived from the entity id by adding a prefix
        return "row_" + entityId;
    }

    public static void main(String[] args) {
        EntityIdHandler handler = new EntityIdHandler();
        String entityId = "12345";
        String rowId = handler.id(entityId);
        System.out.println("Row ID: " + rowId);
    }
}