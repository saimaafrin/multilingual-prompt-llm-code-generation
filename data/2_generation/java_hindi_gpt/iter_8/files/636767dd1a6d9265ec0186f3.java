public class ColumnNameOverride {

    /**
     * {@link ColumnName#overrideName(String,String)} के समान नाम प्रतिस्थापन बनाए रखें।
     * @param oldName जिसे प्रतिस्थापित किया जाना है।
     * @param newName जिसे संग्रहण स्तर में उपयोग करना है।
     */
    public void overrideName(String oldName, String newName) {
        // Assuming we have a map to store the column names
        java.util.Map<String, String> columnNames = new java.util.HashMap<>();

        // Replace the old name with the new name
        if (columnNames.containsKey(oldName)) {
            String value = columnNames.remove(oldName);
            columnNames.put(newName, value);
        }
    }
}