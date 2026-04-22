public class Entity {
    
    /** 
     * @return the row id
     */
    public String id(String entityId) {
        // Assuming the row id is simply the entityId prefixed with "row_"
        return "row_" + entityId;
    }

    public static void main(String[] args) {
        Entity entity = new Entity();
        String result = entity.id("12345");
        System.out.println(result); // Output: row_12345
    }
}