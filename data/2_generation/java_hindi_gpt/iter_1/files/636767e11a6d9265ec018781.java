public class MetricsHandler {

    // Assuming METRICS is a class that holds some data
    private METRICS currentMetrics;

    /**
     * कैश में डेटा स्वीकार करें और मौजूदा मान के साथ विलय करें। यह विधि थ्रेड-सुरक्षित नहीं है, इसे समवर्ती कॉलिंग से बचना चाहिए।
     * @param data जिसे संभावित रूप से जोड़ा जाना है।
     */
    @Override
    public void accept(final METRICS data) {
        if (currentMetrics == null) {
            currentMetrics = data;
        } else {
            mergeMetrics(currentMetrics, data);
        }
    }

    private void mergeMetrics(METRICS current, METRICS newData) {
        // Implement the logic to merge current metrics with newData
        // This is a placeholder for the actual merging logic
        // For example, if METRICS has a method to add values:
        current.add(newData);
    }
}

// Assuming METRICS is defined as follows
class METRICS {
    // Example fields
    private int value;

    public void add(METRICS other) {
        this.value += other.value; // Example merging logic
    }
}