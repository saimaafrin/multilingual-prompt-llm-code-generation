public class ColumnNameOverride {

    /**
     * Keep the same name replacement as  {@link ColumnName#overrideName(String,String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        // Assuming we have a map to store the column names
        java.util.Map<String, String> columnNames = new java.util.HashMap<>();

        // Replace the old name with the new name in the map
        if (columnNames.containsKey(oldName)) {
            String value = columnNames.remove(oldName);
            columnNames.put(newName, value);
        }
    }
}