import java.util.Objects;

public class FieldChecker {

    private Properties properties;

    public FieldChecker(Properties properties) {
        this.properties = properties;
    }

    /**
     * Devuelve verdadero cuando los campos de entrada ya han sido almacenados en las propiedades.
     */
    private boolean containsAllFields(Fields fields) {
        for (Field field : fields) {
            if (!properties.containsKey(field.getName())) {
                return false;
            }
        }
        return true;
    }

    // Assuming Fields and Field classes are defined as follows:
    public static class Fields implements Iterable<Field> {
        private final java.util.List<Field> fields;

        public Fields(java.util.List<Field> fields) {
            this.fields = fields;
        }

        @Override
        public java.util.Iterator<Field> iterator() {
            return fields.iterator();
        }
    }

    public static class Field {
        private final String name;

        public Field(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Field field = (Field) o;
            return Objects.equals(name, field.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    // Assuming Properties is a standard java.util.Properties or similar
    public static class Properties {
        private final java.util.Map<String, String> properties;

        public Properties() {
            this.properties = new java.util.HashMap<>();
        }

        public void setProperty(String key, String value) {
            properties.put(key, value);
        }

        public String getProperty(String key) {
            return properties.get(key);
        }

        public boolean containsKey(String key) {
            return properties.containsKey(key);
        }
    }
}