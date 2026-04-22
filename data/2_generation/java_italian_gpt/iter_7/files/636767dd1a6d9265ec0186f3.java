public class ColumnName {
    
    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        // Logica per sostituire il nome
        System.out.println("Sostituzione del nome: " + oldName + " con " + newName);
        // Qui puoi aggiungere la logica per aggiornare il nome nel tuo sistema di archiviazione
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("vecchioNome", "nuovoNome");
    }
}