public class ColumnName {
    
    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        // Logica per sostituire il nome
        // Questo è un esempio di implementazione
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("I nomi non possono essere null");
        }
        
        // Supponiamo di avere una mappa per memorizzare i nomi delle colonne
        java.util.Map<String, String> columnNames = new java.util.HashMap<>();
        
        // Sostituisci il vecchio nome con il nuovo nome
        if (columnNames.containsKey(oldName)) {
            String value = columnNames.remove(oldName);
            columnNames.put(newName, value);
        } else {
            System.out.println("Il nome da sostituire non esiste.");
        }
    }
    
    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("vecchioNome", "nuovoNome");
    }
}