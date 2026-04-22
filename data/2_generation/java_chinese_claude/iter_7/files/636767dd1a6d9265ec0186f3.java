import java.util.Objects;

public class ColumnNameOverride {

    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        // Validate input parameters
        Objects.requireNonNull(oldName, "oldName cannot be null");
        Objects.requireNonNull(newName, "newName cannot be null");
        
        if (oldName.isEmpty()) {
            throw new IllegalArgumentException("oldName cannot be empty");
        }
        
        if (newName.isEmpty()) {
            throw new IllegalArgumentException("newName cannot be empty");
        }

        // Here we would typically have some internal data structure 
        // to store the name mappings, for example a Map<String,String>
        // For demonstration, we'll just print the override
        System.out.println("Overriding name: " + oldName + " -> " + newName);
    }
}