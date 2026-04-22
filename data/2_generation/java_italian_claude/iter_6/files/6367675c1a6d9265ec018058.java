import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicInteger;

public class StringSupplierCreator {

    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        AtomicInteger counter = new AtomicInteger(start);
        return () -> String.valueOf(counter.getAndIncrement());
    }
}