import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TableUtils {

    /**
     * निर्दिष्ट JTable में निर्दिष्ट पंक्ति का चयन करता है और निर्दिष्ट JScrollPane को नए चयनित पंक्ति की ओर स्क्रॉल करता है। सबसे महत्वपूर्ण बात यह है कि repaint() कॉल को इतना देर से किया जाता है कि तालिका नए चयनित पंक्ति को सही तरीके से पेंट कर सके, जो कि स्क्रीन से बाहर हो सकती है।
     * @param row चयन करने के लिए पंक्ति सूचकांक
     * @param table को निर्दिष्ट JScrollPane से संबंधित होना चाहिए
     * @param pane JScrollPane जिसमें JTable है
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null || row < 0 || row >= table.getRowCount()) {
            return;
        }

        // Select the row
        table.setRowSelectionInterval(row, row);

        // Scroll to the selected row
        SwingUtilities.invokeLater(() -> {
            table.scrollRectToVisible(table.getCellRect(row, 0, true));
            pane.repaint();
        });
    }
}