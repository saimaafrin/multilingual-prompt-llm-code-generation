public class LineNumberManager {
    
    private int lineNumber;

    /** 
     * इस लेबल के लिए एक स्रोत पंक्ति संख्या जोड़ता है।
     * @param lineNumber एक स्रोत पंक्ति संख्या (जो कि सख्ती से सकारात्मक होनी चाहिए)।
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Line number must be strictly positive.");
        }
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public static void main(String[] args) {
        LineNumberManager manager = new LineNumberManager();
        manager.addLineNumber(5);
        System.out.println("Line Number: " + manager.getLineNumber());
    }
}