import java.util.*;

class Bucket {
    private List<Bucket> bucketList;

    public Bucket(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    /**
     * 从数据结构中移除此桶。
     */
    public void removeSelf() {
        if (bucketList != null) {
            bucketList.remove(this);
        }
    }
}