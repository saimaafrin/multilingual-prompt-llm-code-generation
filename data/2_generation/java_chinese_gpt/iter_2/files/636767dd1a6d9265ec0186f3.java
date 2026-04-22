public class ColumnName {

    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        // Implementation of the name override logic
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Old name and new name cannot be null");
        }
        
        // Here you would typically have logic to replace the old name with the new name
        // For demonstration purposes, we will just print the action
        System.out.println("Replacing old name: " + oldName + " with new name: " + newName);
        
        // Actual replacement logic would go here, e.g., updating a database or a map
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("old_column", "new_column");
    }
}