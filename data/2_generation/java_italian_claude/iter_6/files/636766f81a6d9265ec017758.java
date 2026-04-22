public class Type {
    private String name;
    private String category;
    
    /**
     * Restituisce un valore hash per questo tipo.
     * @return un valore hash per questo tipo.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        return result;
    }
}