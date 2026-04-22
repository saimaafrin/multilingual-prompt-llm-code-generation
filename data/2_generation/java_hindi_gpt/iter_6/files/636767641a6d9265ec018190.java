import java.util.List;
import java.util.Set;

public class BucketRelabeler {

    /**
     * {@code minLabel} लेबल वाले बकेट से सभी वर्टिस को लेबल 0 वाले बकेट में स्थानांतरित करता है। {@code minLabel} लेबल वाले बकेट को साफ करता है। लेबलिंग को तदनुसार अपडेट करता है।
     * @param bucketsByLabel वे बकेट जहाँ वर्टिस संग्रहीत हैं
     * @param labels वर्टिस के लेबल
     * @param minLabel गैर-खाली बकेट का न्यूनतम मान
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        if (minLabel < 0 || minLabel >= bucketsByLabel.size()) {
            throw new IllegalArgumentException("minLabel is out of bounds");
        }

        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);

        // Move vertices from minLabel bucket to zero label bucket
        for (Integer vertex : minLabelBucket) {
            zeroLabelBucket.add(vertex);
            labels.set(vertex, 0); // Update the label of the vertex to 0
        }

        // Clear the minLabel bucket
        minLabelBucket.clear();
    }
}