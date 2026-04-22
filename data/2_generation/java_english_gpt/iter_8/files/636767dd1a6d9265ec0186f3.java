public class ColumnName {
    
    /**
     * Keep the same name replacement as  {@link ColumnName#overrideName(String,String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        // Assuming we have a map to store column names
        Map<String, String> columnNames = new HashMap<>();
        
        // Check if the old name exists in the map
        if (columnNames.containsKey(oldName)) {
            // Replace the old name with the new name
            String value = columnNames.remove(oldName);
            columnNames.put(newName, value);
        } else {
            // If old name does not exist, you might want to handle it
            System.out.println("Old name does not exist.");
        }
    }
    
    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("oldColumn", "newColumn");
    }
}