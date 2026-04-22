public class ColumnName {
    
    // Method to override the name
    /** 
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        // Logic to replace oldName with newName in the storage
        // This is a placeholder for the actual implementation
        System.out.println("Replacing " + oldName + " with " + newName);
        
        // Here you would typically update a data structure or database
        // For example, if you had a map of column names:
        // columnMap.put(newName, columnMap.remove(oldName));
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("old_column", "new_column");
    }
}