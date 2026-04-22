class _M:
    def _get_alignment_value(self, alignment):
        """
        Devuelve el valor de alineación correspondiente a la cadena de alineación dada.
        :param alignment: str, la cadena de alineación ('izquierda', 'centro' o 'derecha').
        :return: int, el valor de alineación.
        """
        alignment_map = {
            'izquierda': 0,
            'centro': 1,
            'derecha': 2
        }
        
        return alignment_map.get(alignment.lower(), 0)