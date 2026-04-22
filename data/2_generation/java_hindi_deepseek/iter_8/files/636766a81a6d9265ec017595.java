import java.util.ArrayList;

final class ByteVector {
    private ArrayList<Byte> vector;

    public ByteVector() {
        this.vector = new ArrayList<>();
    }

    public ByteVector put11(final int byteValue1, final int byteValue2) {
        // Ensure the values are within byte range
        if (byteValue1 < -128 || byteValue1 > 127 || byteValue2 < -128 || byteValue2 > 127) {
            throw new IllegalArgumentException("Byte values must be between -128 and 127");
        }

        // Add the bytes to the vector
        vector.add((byte) byteValue1);
        vector.add((byte) byteValue2);

        return this;
    }

    // Optional: Method to get the byte vector as an array
    public byte[] toByteArray() {
        byte[] byteArray = new byte[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            byteArray[i] = vector.get(i);
        }
        return byteArray;
    }
}