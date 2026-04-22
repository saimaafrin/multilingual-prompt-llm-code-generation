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
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        if (head == null) {
            head = bucket;
            return;
        }

        Bucket current = head;
        Bucket previous = null;

        while (current != null && current != bucket) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            throw new IllegalArgumentException("Bucket not found in the list");
        }

        if (previous == null) {
            // Inserting before the head
            bucket.setNext(head);
            head = bucket;
        } else {
            // Inserting in the middle or at the end
            previous.setNext(bucket);
            bucket.setNext(current);
        }
    }
}