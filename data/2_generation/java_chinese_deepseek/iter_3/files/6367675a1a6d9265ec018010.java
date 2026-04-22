import java.util.*;

class Bucket {
    private List<Bucket> buckets;

    public Bucket(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public void removeSelf() {
        if (buckets != null) {
            buckets.remove(this);
        }
    }
}