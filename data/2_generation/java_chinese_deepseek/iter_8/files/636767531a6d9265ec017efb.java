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

    public void insertBefore(Bucket bucket) {
        if (head == null || bucket == null) {
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