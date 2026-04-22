import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class StringSupplierGenerator {
    
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        AtomicInteger counter = new AtomicInteger(start);
        return () -> String.valueOf(counter.getAndIncrement());
    }
}