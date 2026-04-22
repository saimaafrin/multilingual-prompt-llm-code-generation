public class FieldChecker {
    
    private Fields storedFields;

    public FieldChecker(Fields storedFields) {
        this.storedFields = storedFields;
    }

    /**
     * 当输入字段已经存储在属性中时返回真。
     */
    private boolean containsAllFields(Fields fields) {
        for (Field field : fields.getAllFields()) {
            if (!storedFields.contains(field)) {
                return false;
            }
        }
        return true;
    }
}

class Fields {
    private Set<Field> fieldSet;

    public Fields(Set<Field> fieldSet) {
        this.fieldSet = fieldSet;
    }

    public Set<Field> getAllFields() {
        return fieldSet;
    }

    public boolean contains(Field field) {
        return fieldSet.contains(field);
    }
}

class Field {
    private String name;

    public Field(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Field)) return false;
        Field other = (Field) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}