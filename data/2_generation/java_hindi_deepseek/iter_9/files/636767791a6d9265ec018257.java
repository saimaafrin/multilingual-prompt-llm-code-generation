import java.util.logging.LogRecord;
import javax.swing.SwingUtilities;

public class LogTable {

    /**
     * लॉगटेबल में प्रदर्शित करने के लिए एक लॉग रिकॉर्ड संदेश जोड़ें। यह विधि थ्रेड-सेफ है क्योंकि यह सीधे प्रोसेस करने के बजाय स्विंग थ्रेड पर अनुरोध भेजती है।
     */
    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // यहां लॉग रिकॉर्ड को टेबल में जोड़ने का कोड होगा
                // उदाहरण के लिए:
                // logTableModel.addLogRecord(lr);
            }
        });
    }
}