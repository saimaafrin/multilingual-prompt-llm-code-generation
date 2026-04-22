import java.util.List;
import java.util.Map;

public class DataTable {
    private List<Map<String, Object>> data;

    public DataTable(List<Map<String, Object>> data) {
        this.data = data;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }
}

public class BucketChecker {

    /**
     * @return यदि बकेट समान है तो true लौटाता है।
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null || dataset.getData() == null || dataset.getData().isEmpty()) {
            return false;
        }

        // Assuming compatibility is determined by checking if all rows have the same set of keys
        Map<String, Object> firstRow = dataset.getData().get(0);
        for (Map<String, Object> row : dataset.getData()) {
            if (!row.keySet().equals(firstRow.keySet())) {
                return false;
            }
        }

        return true;
    }
}