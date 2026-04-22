class _M:
    import re
    
    def match(self, pattern, text):
        """
        Verifica si el texto coincide con la expresión regular
        :param pattern: cadena, Patrón de expresión regular
        :param text: cadena, Texto a coincidir
        :return: True o False, que representa si el texto coincide con la expresión regular o no
        >>> ru = RegexUtils()
        >>> ru.match(r'\b\d{3}-\d{3}-\d{4}\b', "123-456-7890")
        True
        """
        if re.search(pattern, text):
            return True
        return False