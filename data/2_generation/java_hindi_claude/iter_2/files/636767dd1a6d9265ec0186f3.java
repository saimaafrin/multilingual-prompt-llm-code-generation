import java.util.Objects;

public class ColumnName {

    private String name;

    public ColumnName(String name) {
        this.name = name;
    }

    /**
     * Keep the same name replacement as {@link ColumnName#overrideName(String,String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        if (Objects.equals(this.name, oldName)) {
            this.name = newName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}