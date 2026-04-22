import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class MetricsCache {
    private AtomicReference<METRICS> cache = new AtomicReference<>();

    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Input data cannot be null");
        
        METRICS currentValue = cache.get();
        if (currentValue == null) {
            cache.set(data);
        } else {
            METRICS mergedValue = currentValue.mergeWith(data);
            cache.set(mergedValue);
        }
    }
}