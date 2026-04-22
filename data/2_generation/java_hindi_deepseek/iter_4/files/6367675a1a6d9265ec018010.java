import java.util.*;

class Bucket {
    private List<Bucket> dataStructure;

    public Bucket(List<Bucket> dataStructure) {
        this.dataStructure = dataStructure;
    }

    /**
     * इस बकेट को डेटा संरचना से हटा देता है।
     */
    public void removeSelf() {
        if (dataStructure != null) {
            dataStructure.remove(this);
        }
    }
}