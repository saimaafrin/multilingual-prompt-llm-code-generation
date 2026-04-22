public class ColumnNameOverride {

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
            // If old name does not exist, we can add the new name directly
            columnNames.put(newName, null); // Assuming null value for new name
        }
    }
}