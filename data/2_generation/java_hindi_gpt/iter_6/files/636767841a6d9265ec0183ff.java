import javax.swing.*;
import java.awt.*;

public class TableRowSelector {

    /** 
     * निर्दिष्ट JTable में निर्दिष्ट पंक्ति का चयन करता है और निर्दिष्ट JScrollPane को नए चयनित पंक्ति की ओर स्क्रॉल करता है। सबसे महत्वपूर्ण बात यह है कि repaint() कॉल को इतना देर से किया जाता है कि तालिका नए चयनित पंक्ति को सही तरीके से पेंट कर सके, जो कि स्क्रीन से बाहर हो सकती है।
     * @param row चयनित पंक्ति का अनुक्रमांक
     * @param table को निर्दिष्ट JScrollPane से संबंधित होना चाहिए
     * @param pane JScrollPane जिसमें JTable है
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        // Set the selected row
        table.setRowSelectionInterval(row, row);
        
        // Scroll to the selected row
        SwingUtilities.invokeLater(() -> {
            Rectangle rect = table.getCellRect(row, 0, true);
            table.scrollRectToVisible(rect);
            table.repaint();
        });
    }

    public static void main(String[] args) {
        // Sample usage
        JFrame frame = new JFrame("Table Row Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] columnNames = {"Column 1", "Column 2"};
        Object[][] data = {
            {"Row 1", "Data 1"},
            {"Row 2", "Data 2"},
            {"Row 3", "Data 3"},
            {"Row 4", "Data 4"},
            {"Row 5", "Data 5"},
        };
        
        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
        
        // Select a row after a delay
        Timer timer = new Timer(1000, e -> selectRow(2, table, pane));
        timer.setRepeats(false);
        timer.start();
    }
}