public class Type {
    private String name;
    private int id;
    private boolean isPrimitive;
    
    public Type(String name, int id, boolean isPrimitive) {
        this.name = name;
        this.id = id;
        this.isPrimitive = isPrimitive;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (isPrimitive ? 1231 : 1237);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}