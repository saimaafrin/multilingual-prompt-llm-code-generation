import java.awt.geom.Rectangle2D;
import java.util.AbstractMap;
import java.util.Map;

public class BoxSplitter {
    /**
     * Split a box along the x axis into two equal boxes.
     * @param box the box to split
     * @return a pair with the two resulting boxes
     */
    public static Map.Entry<Rectangle2D, Rectangle2D> splitBox(Rectangle2D box) {
        double x = box.getX();
        double y = box.getY();
        double width = box.getWidth();
        double height = box.getHeight();
        
        // Create left box
        Rectangle2D leftBox = new Rectangle2D.Double(
            x, 
            y,
            width/2,
            height
        );
        
        // Create right box
        Rectangle2D rightBox = new Rectangle2D.Double(
            x + width/2,
            y,
            width/2, 
            height
        );
        
        return new AbstractMap.SimpleEntry<>(leftBox, rightBox);
    }
}