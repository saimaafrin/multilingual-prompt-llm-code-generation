class Bucket {
    // Assuming Bucket has some properties
    private String data;
    Bucket next;

    public Bucket(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }
}

class BucketList {
    private Bucket head;

    public BucketList() {
        this.head = null;
    }

    /** 
     * Inserisce questo bucket nella struttura dati prima del {@code bucket}.
     * @param bucket il bucket, che sarà il successivo a questo bucket.
     */
    public void insertBefore(Bucket bucket) {
        if (head == null || bucket == null) {
            return; // No insertion if the list is empty or bucket is null
        }

        Bucket newBucket = new Bucket("New Data"); // Create a new bucket with some data
        if (head == bucket) {
            newBucket.next = head;
            head = newBucket;
            return;
        }

        Bucket current = head;
        while (current != null && current.next != bucket) {
            current = current.next;
        }

        if (current != null) {
            newBucket.next = current.next;
            current.next = newBucket;
        }
    }

    // Additional methods for testing purposes
    public void printList() {
        Bucket current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void addBucket(String data) {
        Bucket newBucket = new Bucket(data);
        if (head == null) {
            head = newBucket;
        } else {
            Bucket current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBucket;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BucketList bucketList = new BucketList();
        bucketList.addBucket("Bucket 1");
        bucketList.addBucket("Bucket 2");
        bucketList.addBucket("Bucket 3");

        System.out.println("Before insertion:");
        bucketList.printList();

        Bucket bucketToInsertBefore = bucketList.head.next; // This is "Bucket 2"
        bucketList.insertBefore(bucketToInsertBefore);

        System.out.println("After insertion:");
        bucketList.printList();
    }
}