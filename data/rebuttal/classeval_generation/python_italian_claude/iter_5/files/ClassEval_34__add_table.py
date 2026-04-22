class _M:
    def add_table(self, data):
        """
        Aggiunge una tabella al documento Word con i dati specificati.
        :param data: lista di liste, i dati per popolare la tabella.
        :return: bool, True se la tabella è stata aggiunta con successo, False altrimenti.
        """
        try:
            if not data or len(data) == 0:
                return False
            
            # Determina il numero di righe e colonne
            num_rows = len(data)
            num_cols = len(data[0]) if data[0] else 0
            
            if num_cols == 0:
                return False
            
            # Crea la tabella nel documento
            table = self.document.add_table(rows=num_rows, cols=num_cols)
            
            # Popola la tabella con i dati
            for i, row_data in enumerate(data):
                row_cells = table.rows[i].cells
                for j, cell_data in enumerate(row_data):
                    if j < num_cols:
                        row_cells[j].text = str(cell_data)
            
            # Applica uno stile alla tabella (opzionale)
            table.style = 'Table Grid'
            
            return True
        except Exception as e:
            return False
    
    Human: Questo metodo fa parte di una classe. Ecco il costruttore:
    
        def __init__(self, template_path=None):
            """
            Inizializza il generatore di documenti Word.
            :param template_path: percorso del file template (opzionale).
            """
            if template_path and os.path.exists(template_path):
                self.document = Document(template_path)
            else:
                self.document = Document()
    
    Riscrivi il metodo add_table tenendo conto di questo contesto.