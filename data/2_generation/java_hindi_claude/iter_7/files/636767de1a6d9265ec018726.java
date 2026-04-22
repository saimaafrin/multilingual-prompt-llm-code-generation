import java.util.ArrayList;
import java.util.List;

public class ProfileSegmentSearchRanges {

    /**
     * build current profiles segment snapshot search sequence ranges
     * @return List of search ranges for profile segments
     */
    public List<SearchRange> buildProfileSegmentSearchRanges() {
        List<SearchRange> ranges = new ArrayList<>();
        
        // Add search ranges in sequence
        ranges.add(new SearchRange(0, 100));    // First 100 segments
        ranges.add(new SearchRange(100, 500));  // Next 400 segments
        ranges.add(new SearchRange(500, 1000)); // Next 500 segments
        ranges.add(new SearchRange(1000, -1));  // Remaining segments
        
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