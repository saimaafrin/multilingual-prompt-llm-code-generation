public class ColumnName {

    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        // Logica per sostituire il nome
        // Questo è un esempio di implementazione
        System.out.println("Sostituzione del nome: " + oldName + " con " + newName);
        
        // Qui si potrebbe aggiungere la logica per aggiornare un database o una struttura dati
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("vecchioNome", "nuovoNome");
    }
}