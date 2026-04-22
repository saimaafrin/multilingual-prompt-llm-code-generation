import java.util.*;

class Bucket {
    private List<Bucket> bucketList;

    public Bucket(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    /**
     * Rimuove questo bucket dalla struttura dati.
     */
    public void removeSelf() {
        if (bucketList != null) {
            bucketList.remove(this);
        }
    }
}