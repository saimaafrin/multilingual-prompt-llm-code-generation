import java.util.function.Supplier;

public class StringSupplier {

    /** 
     * Crea un fornitore di stringhe che restituisce stringhe uniche. Le stringhe restituite sono semplicemente interi che partono da start.
     * @param start da dove iniziare la sequenza
     * @return un fornitore di stringhe
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
        Supplier<String> stringSupplier = createStringSupplier(0);
        System.out.println(stringSupplier.get()); // Output: 0
        System.out.println(stringSupplier.get()); // Output: 1
        System.out.println(stringSupplier.get()); // Output: 2
    }
}