import java.util.function.Supplier;

public class StringSupplierCreator {
    
    /**
     * Crea un fornitore di stringhe che restituisce stringhe uniche. Le stringhe restituite sono semplicemente interi che partono da start.
     * @param start da dove iniziare la sequenza
     * @return un fornitore di stringhe
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        final int[] counter = {start};
        return () -> String.valueOf(counter[0]++);
    }
}