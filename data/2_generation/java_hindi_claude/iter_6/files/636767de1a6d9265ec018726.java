import java.util.ArrayList;
import java.util.List;

public class ProfileSegmentSearchRanges {

    /**
     * build current profiles segment snapshot search sequence ranges
     * @return List of search ranges for profile segments
     */
    public List<SearchRange> buildProfileSegmentSearchRanges() {
        List<SearchRange> ranges = new ArrayList<>();
        
        // Add default search range
        ranges.add(new SearchRange(0, 100));
        
        // Add additional ranges with overlap
        ranges.add(new SearchRange(90, 190));
        ranges.add(new SearchRange(180, 280));
        ranges.add(new SearchRange(270, 370));
        
        return ranges;
    }
    
    // Helper class to define search ranges
    private class SearchRange {
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