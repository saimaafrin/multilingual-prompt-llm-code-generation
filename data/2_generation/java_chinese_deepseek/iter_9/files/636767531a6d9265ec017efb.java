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
            // Bucket not found in the list
            return;
        }

        if (previous == null) {
            // Inserting before the head
            bucket.setNext(head);
            head = bucket;
        } else {
            // Inserting in the middle or end
            previous.setNext(bucket);
            bucket.setNext(current);
        }
    }
}