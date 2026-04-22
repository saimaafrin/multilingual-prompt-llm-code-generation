import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableUtils {

    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (table == null || pane == null) {
            throw new IllegalArgumentException("Table and pane must not be null.");
        }

        // Seleziona la riga specificata
        table.setRowSelectionInterval(row, row);

        // Ottieni il rettangolo che rappresenta la cella della riga selezionata
        Rectangle cellRect = table.getCellRect(row, 0, true);

        // Scorri lo JScrollPane fino a rendere visibile la riga selezionata
        pane.getViewport().scrollRectToVisible(cellRect);

        // Ritarda la chiamata a repaint() per permettere alla tabella di dipingere correttamente la riga selezionata
        SwingUtilities.invokeLater(() -> {
            table.repaint();
        });
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Column 1", "Column 2", "Column 3"};
        Object[][] data = {
            {"1", "Row 1", "Data 1"},
            {"2", "Row 2", "Data 2"},
            {"3", "Row 3", "Data 3"},
            {"4", "Row 4", "Data 4"},
            {"5", "Row 5", "Data 5"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);

        // Seleziona la riga 3 e scorri fino a renderla visibile
        selectRow(3, table, scrollPane);
    }
}