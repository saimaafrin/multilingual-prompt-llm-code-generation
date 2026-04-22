public class Bucket {
    private Bucket next;

    public Bucket() {
        this.next = null;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }

    /**
     * 在数据结构中将此桶插入到 {@code bucket} 之前。
     * @param bucket 作为当前桶下一个的桶。
     */
    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // 将当前桶的 next 指向传入的 bucket
        this.next = bucket;
    }
}