public class ByteArrayChecker {
    
    private Object body;

    public ByteArrayChecker(Object body) {
        this.body = body;
    }

    /** 
     * 如果主体是字节数组，则返回真
     * @return 如果主体是字节数组，则返回真
     */
    public boolean hasBytes() {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        ByteArrayChecker checker1 = new ByteArrayChecker(new byte[]{1, 2, 3});
        System.out.println(checker1.hasBytes()); // 输出: true

        ByteArrayChecker checker2 = new ByteArrayChecker("Not a byte array");
        System.out.println(checker2.hasBytes()); // 输出: false
    }
}