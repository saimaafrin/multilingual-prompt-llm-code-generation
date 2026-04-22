import java.util.Objects;

public class Bucket {
    private BucketList bucketList; // 假设桶是BucketList的一部分
    
    /**
     * 从数据结构中移除此桶。
     */
    void removeSelf() {
        if (bucketList != null) {
            bucketList.removeBucket(this);
            bucketList = null;
        }
    }
    
    // 构造函数
    public Bucket(BucketList bucketList) {
        this.bucketList = bucketList;
    }
    
    // getter和setter
    public BucketList getBucketList() {
        return bucketList;
    }
    
    public void setBucketList(BucketList bucketList) {
        this.bucketList = bucketList;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(bucketList, bucket.bucketList);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(bucketList);
    }
}