class _M:
    def _get_alignment_value(self, alignment):
        """
            Devuelve el valor de alineación correspondiente a la cadena de alineación dada.
            :param alignment: str, la cadena de alineación ('izquierda', 'centro' o 'derecha').
            :return: int, el valor de alineación.
            """
        if alignment == 'left':
            return WD_PARAGRAPH_ALIGNMENT.LEFT
        elif alignment == 'center':
            return WD_PARAGRAPH_ALIGNMENT.CENTER
        elif alignment == 'right':
            return WD_PARAGRAPH_ALIGNMENT.RIGHT
        else:
            return WD_PARAGRAPH_ALIGNMENT.LEFT