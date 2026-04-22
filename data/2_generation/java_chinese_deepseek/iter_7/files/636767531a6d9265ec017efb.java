public class Bucket {
    private Bucket next;

    public Bucket(Bucket next) {
        this.next = next;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }
}

public class BucketList {
    private Bucket head;

    public BucketList(Bucket head) {
        this.head = head;
    }

    public Bucket getHead() {
        return head;
    }

    public void setHead(Bucket head) {
        this.head = head;
    }

    /**
     * 在数据结构中将此桶插入到 {@code bucket} 之前。
     * @param bucket 作为当前桶下一个的桶。
     */
    public void insertBefore(Bucket bucket) {
        if (bucket == null || head == null) {
            return;
        }

        if (head == bucket) {
            Bucket newBucket = new Bucket(head);
            head = newBucket;
            return;
        }

        Bucket current = head;
        while (current.getNext() != null && current.getNext() != bucket) {
            current = current.getNext();
        }

        if (current.getNext() == bucket) {
            Bucket newBucket = new Bucket(bucket);
            current.setNext(newBucket);
        }
    }
}