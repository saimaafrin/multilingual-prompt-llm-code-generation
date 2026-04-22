public class ByteChecker {
    private byte[] body;

    public ByteChecker(byte[] body) {
        this.body = body;
    }

    /** 
     * 如果主体是字节数组，则返回真
     * @return 如果主体是字节数组，则返回真
     */
    public boolean hasBytes() {
        return body != null;
    }

    public static void main(String[] args) {
        byte[] sampleBytes = {1, 2, 3};
        ByteChecker checker = new ByteChecker(sampleBytes);
        System.out.println(checker.hasBytes()); // 输出: true
    }
}