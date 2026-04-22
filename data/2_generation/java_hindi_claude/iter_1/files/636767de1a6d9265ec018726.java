import java.util.ArrayList;
import java.util.List;

public class ProfileSegmentSearchRanges {

    /**
     * Build current profiles segment snapshot search sequence ranges
     * @return List of search range pairs
     */
    public List<SearchRange> buildSearchRanges() {
        List<SearchRange> ranges = new ArrayList<>();
        
        // Add search ranges in sequence
        ranges.add(new SearchRange(0, 100));
        ranges.add(new SearchRange(100, 1000)); 
        ranges.add(new SearchRange(1000, 10000));
        ranges.add(new SearchRange(10000, Integer.MAX_VALUE));
        
        return ranges;
    }
    
    // Inner class to represent a search range
    public static class SearchRange {
        private int start;
        private int end;
        
        public SearchRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getStart() {
            return start;
        }
        
        public int getEnd() {
            return end;
        }
    }
}