import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import java.awt.Rectangle;

public class TableUtils {

    /**
     * निर्दिष्ट JTable में निर्दिष्ट पंक्ति का चयन करता है और निर्दिष्ट JScrollPane को नए चयनित पंक्ति की ओर स्क्रॉल करता है। सबसे महत्वपूर्ण बात यह है कि repaint() कॉल को इतना देर से किया जाता है कि तालिका नए चयनित पंक्ति को सही तरीके से पेंट कर सके, जो कि स्क्रीन से बाहर हो सकती है।
     * @param row चयन करने के लिए पंक्ति सूचकांक
     * @param table को निर्दिष्ट JScrollPane से संबंधित होना चाहिए
     * @param pane JScrollPane जिसमें JTable है
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        // पंक्ति का चयन करें
        table.setRowSelectionInterval(row, row);

        // पंक्ति के दृश्य क्षेत्र को प्राप्त करें
        Rectangle cellRect = table.getCellRect(row, 0, true);

        // JViewport को प्राप्त करें और उसे नई पंक्ति की ओर स्क्रॉल करें
        JViewport viewport = pane.getViewport();
        viewport.scrollRectToVisible(cellRect);

        // तालिका को पुनः पेंट करें
        table.repaint();
    }
}