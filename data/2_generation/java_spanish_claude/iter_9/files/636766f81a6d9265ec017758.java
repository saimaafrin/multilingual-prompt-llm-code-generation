public class MyClass {
    private String value;
    private int number;
    
    /** 
     * Devuelve un valor de código hash para este tipo.
     * @return un valor de código hash para este tipo.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + number;
        return result;
    }
}