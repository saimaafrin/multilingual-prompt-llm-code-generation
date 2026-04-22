public class Log2FloorPlusOne {
    /**
     * Calcula el piso(log2(n)) + 1
     * @param n el número para el cual se calculará el piso(log2(n)) + 1
     * @return el valor de piso(log2(n)) + 1
     */
    public static int calculateLog2FloorPlusOne(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser un número positivo");
        }
        int log2 = 0;
        while (n > 1) {
            n = n / 2;
            log2++;
        }
        return log2 + 1;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("El piso(log2(" + n + ")) + 1 es: " + calculateLog2FloorPlusOne(n));
    }
}