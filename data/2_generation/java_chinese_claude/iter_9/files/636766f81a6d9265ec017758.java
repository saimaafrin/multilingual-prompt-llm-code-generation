public class MyClass {
    private String field1;
    private int field2;
    private double field3;
    
    /**
     * 返回此类型的哈希码值。
     * @return 此类型的哈希码值。
     */
    @Override 
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
        result = prime * result + field2;
        long temp = Double.doubleToLongBits(field3);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}