import java.util.function.Supplier;

public class StringSupplier {

    /**
     * Crea un proveedor de cadenas que devuelve cadenas únicas. Las cadenas devueltas son simplemente enteros que comienzan desde el inicio.
     * @param start desde dónde comenzar la secuencia
     * @return un proveedor de cadenas
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        return new Supplier<String>() {
            private int current = start;

            @Override
            public String get() {
                return String.valueOf(current++);
            }
        };
    }

    public static void main(String[] args) {
        Supplier<String> supplier = createStringSupplier(10);
        System.out.println(supplier.get()); // Output: 10
        System.out.println(supplier.get()); // Output: 11
        System.out.println(supplier.get()); // Output: 12
    }
}