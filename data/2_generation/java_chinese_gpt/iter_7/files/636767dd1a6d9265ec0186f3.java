public class ColumnName {

    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        // Implementation of the name override logic
        // This is a placeholder for the actual logic to replace oldName with newName
        System.out.println("Replacing name: " + oldName + " with new name: " + newName);
        
        // Here you would typically update a data structure or database with the new name
        // For example, if you have a map of column names:
        // columnNameMap.put(newName, columnNameMap.remove(oldName));
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("old_column", "new_column");
    }
}