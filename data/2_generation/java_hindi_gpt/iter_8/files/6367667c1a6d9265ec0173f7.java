public class ByteArrayChecker {
    
    private byte[] body;

    public ByteArrayChecker(byte[] body) {
        this.body = body;
    }

    /** 
     * यदि बॉडी एक बाइट एरे है तो सत्य है
     * @return यदि बॉडी एक बाइट एरे है तो सत्य है
     */
    public boolean hasBytes() {
        return body != null && body.length > 0;
    }

    public static void main(String[] args) {
        ByteArrayChecker checker = new ByteArrayChecker(new byte[]{1, 2, 3});
        System.out.println(checker.hasBytes()); // Output: true

        ByteArrayChecker emptyChecker = new ByteArrayChecker(new byte[]{});
        System.out.println(emptyChecker.hasBytes()); // Output: false

        ByteArrayChecker nullChecker = new ByteArrayChecker(null);
        System.out.println(nullChecker.hasBytes()); // Output: false
    }
}